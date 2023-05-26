package exam.parser.nodes;

import java.util.List;

public class UNode extends Node {
    public UNode() {
        super();
    }

    public UNode(List<Node> children) {
        super(children);
    }

    @Override
    public String getHtmlTag() {
        return "u";
    }

    @Override
    public String getBbTag() {
        return "u";
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new UNode(children);
    }
}
