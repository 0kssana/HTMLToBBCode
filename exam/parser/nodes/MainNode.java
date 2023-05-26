package exam.parser.nodes;

import java.util.List;

public class MainNode extends Node {
    public MainNode() {
        super();
    }

    public MainNode(List<Node> children) {
        super(children);
    }

    @Override
    public String getHtmlTag() {
        return "";
    }

    @Override
    public String getBbTag() {
        return "";
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new MainNode(children);
    }

    public void writeDecoratedBBText(StringBuilder builder) {
        for (Node child : this.children) {
            child.writeDecoratedBBText(builder);
        }
    }
}
