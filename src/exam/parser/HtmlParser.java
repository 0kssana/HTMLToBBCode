package exam.parser;

import exam.parser.nodes.*;

import java.util.ArrayList;
import java.util.List;

public class HtmlParser {
    public String rawText;
    public int position;
    // Поддерживаемые тэги
    public static List<Node> tags = List.of(
            new BNode(), new INode(), new LiNode(), new OlNode(), new SNode(), new UlNode(), new UNode()
    );

    public HtmlParser(String rawText) {
        this.rawText = rawText;
        this.position = 0;
    }

    public Node parse() {
        return parse(new MainNode());
    }

    // Рекурсивный парсер
    private Node parse(Node parentNode) {
        StringBuilder currentRawText = new StringBuilder();
        List<Node> children = new ArrayList<>();
        while (this.position < rawText.length()) {
            boolean found = false;
            // Проверяем все тэги на потенциальное открытие
            for (Node tag : tags) {
                if (rawText.startsWith(tag.getOpenHtmlTag(), this.position)) {
                    // Если к текущему моменту есть какой либо сырой текст, тогда сохраняем его
                    if (currentRawText.length() > 0) {
                        children.add(new TextNode(currentRawText.toString()));
                        currentRawText = new StringBuilder();
                    }
                    this.position += tag.getOpenHtmlTag().length();
                    // Запускаем парсер для поиска закрывающего тэга
                    children.add(parse(tag));
                    found = true;
                    break;
                }
            }
            // Если нашли закрывающий тэг, то возвращаемся из рекурсии, сохраняя вершину
            if (!found && rawText.startsWith(parentNode.getCloseHtmlTag(), this.position)) {
                if (currentRawText.length() > 0) children.add(new TextNode(currentRawText.toString()));
                this.position += parentNode.getCloseHtmlTag().length();
                return parentNode.withChildren(children);
            }
            // Если это не открывающий и не закрывающий тэг, тогда это просто текстовый символ
            if (!found) {
                currentRawText.append(rawText.charAt(this.position));
                this.position += 1;
            }
        }
        // Если текст закончился, тогда не должно быть незакрытых тэгов
        // Сюда должны прийти только в самом внешнем уровне рекурсии
        if (parentNode instanceof MainNode) {
            if (currentRawText.length() > 0) children.add(new TextNode(currentRawText.toString()));
            return parentNode.withChildren(children);
        } else {
            throw new IllegalArgumentException("Text is not correct html page");
        }
    }

    public static Node parse(String input) {
        return new HtmlParser(input).parse();
    }
}
