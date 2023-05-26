package exam.parser.nodes;

import java.util.List;

public class OlNode extends Node {
    public OlNode() {
        super();
    }

    public OlNode(List<Node> children) {
        super(children);
    }

    @Override
    public String getHtmlTag() {
        return "ol";
    }

    @Override
    public String getBbTag() {
        return "ol";
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new OlNode(children);
    }
}
