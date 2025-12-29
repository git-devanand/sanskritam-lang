package splc.ast;

public class ReturnNode extends StatementNode {

    public final ExpressionNode value;

    public ReturnNode(ExpressionNode value) {
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
