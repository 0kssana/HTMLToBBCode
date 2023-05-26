package exam.parser.nodes;

import java.util.List;

public class LiNode extends Node {
    public LiNode() {
        super();
    }

    public LiNode(List<Node> children) {
        super(children);
    }

    @Override
    public String getHtmlTag() {
        return "li";
    }

    @Override
    public String getBbTag() {
        return "li";
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new LiNode(children);
    }
}
