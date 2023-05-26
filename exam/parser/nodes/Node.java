package exam.parser.nodes;

import java.util.List;

// Вершина разбора
public abstract class Node {
    // Внутренние элементы
    protected final List<Node> children;

    // Конструктор для элементов без внутренних элементов
    public Node() {
        this(List.of());
    }

    public Node(List<Node> children) {
        this.children = children;
    }

    // Каждый конкретный тэг опеределяет свое текстовое представление
    public abstract String getHtmlTag();

    public abstract String getBbTag();

    // Генерируем общий вид тэгов, при желании можно переопределить в наследующих классах
    public String getOpenHtmlTag() {
        return "<" + getHtmlTag() + ">";
    }

    public String getOpenBbTag() {
        return "[" + getBbTag() + "]";
    }

    public String getCloseHtmlTag() {
        return "</" + getHtmlTag() + ">";
    }

    public String getCloseBbTag() {
        return "[/" + getBbTag() + "]";
    }

    // Создание копии с сохранением типа вершины, но изменением содержимого
    public abstract Node withChildren(List<Node> children);

    // Запись строкового представления в StringBuilder
    public void writeDecoratedBBText(StringBuilder builder) {
        builder.append(getOpenBbTag());
        for (Node child : this.children) {
            child.writeDecoratedBBText(builder);
        }
        builder.append(getCloseBbTag());
    }
}
