package splc.ast;

public class BinaryExprNode extends ExpressionNode {

    public final ExpressionNode left;
    public final String operator;
    public final ExpressionNode right;

    public BinaryExprNode(ExpressionNode left, String operator, ExpressionNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
