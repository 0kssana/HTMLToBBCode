package exam.parser.nodes;

import java.util.List;

public class UlNode extends Node {
    public UlNode() {
        super();
    }

    public UlNode(List<Node> children) {
        super(children);
    }

    @Override
    public String getHtmlTag() {
        return "ul";
    }

    @Override
    public String getBbTag() {
        return "ul";
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new UlNode(children);
    }
}
