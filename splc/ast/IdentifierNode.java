package splc.ast;

public class IdentifierNode extends ExpressionNode {

    public final String name;

    public IdentifierNode(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
