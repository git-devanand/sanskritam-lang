package splc.ast;

public class VarDeclNode extends StatementNode {

    public final String type;
    public final String name;
    public final ExpressionNode initializer;

    public VarDeclNode(String type, String name, ExpressionNode initializer) {
        this.type = type;
        this.name = name;
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
