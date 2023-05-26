package exam.parser.nodes;

import java.util.List;

public class INode extends Node {
    public INode() {
        super();
    }

    public INode(List<Node> children) {
        super(children);
    }

    @Override
    public String getHtmlTag() {
        return "i";
    }

    @Override
    public String getBbTag() {
        return "i";
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new INode(children);
    }
}
