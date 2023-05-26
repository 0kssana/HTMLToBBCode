package exam.parser.nodes;

import java.util.List;

public class SNode extends Node {
    public SNode() {
        super();
    }

    public SNode(List<Node> children) {
        super(children);
    }

    @Override
    public String getHtmlTag() {
        return "s";
    }

    @Override
    public String getBbTag() {
        return "s";
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new SNode(children);
    }
}
