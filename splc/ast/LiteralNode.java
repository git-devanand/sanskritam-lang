package splc.ast;

public class LiteralNode extends ExpressionNode {

    // 5,"राम",सत्य

    public final Object value;

    public LiteralNode(Object value) {
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
