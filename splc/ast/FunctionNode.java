package splc.ast;

import java.util.List;

public class FunctionNode extends StatementNode {

    public final String name;
    public final List<String> parameters;
    public final String returnType;
    public final BlockNode body;

    public FunctionNode(String name, List<String> parameters, String returnType, BlockNode body) {
        this.name = name;
        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
