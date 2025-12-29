package splc.ast;

public class UnaryExprNode extends ExpressionNode {

    public final String operator;
    public final ExpressionNode expression;

    public UnaryExprNode(String operator, ExpressionNode expression) {
        this.operator = operator;
        this.expression = expression;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
