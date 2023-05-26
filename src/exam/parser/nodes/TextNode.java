package exam.parser.nodes;

import java.util.List;

// Специальная нода, в которой содержится исключительно сырой текст
public class TextNode extends Node {
    private final String text;

    public TextNode(String innerText) {
        super();
        this.text = innerText;
    }

    @Override
    public String getHtmlTag() {
        throw new IllegalStateException("This object has no html tag");
    }

    @Override
    public String getBbTag() {
        throw new IllegalStateException("This object has no BB tag");
    }

    @Override
    public Node withChildren(List<Node> children) {
        throw new IllegalStateException("This object has no children");
    }

    public void writeDecoratedBBText(StringBuilder builder) {
        builder.append(text);
    }
}
