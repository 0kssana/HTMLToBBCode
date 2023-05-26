package exam.parser.nodes;

import java.util.List;

public class BNode extends Node {
    public BNode() {
        super();
    }

    public BNode(List<Node> children) {
        super(children);
    }

    @Override
    public String getHtmlTag() {
        return "b";
    }

    @Override
    public String getBbTag() {
        return "b";
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new BNode(children);
    }
}
