package splc.ast;

public class AssignNode extends StatementNode {

    public final String name;
    public final ExpressionNode value;

    public AssignNode(String name, ExpressionNode value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
