package splc.interpreter;

import splc.ast.BlockNode;
import java.util.List;

public class FunctionValue {

    public final List<String> parameters;
    public final BlockNode body;
    public final Environment closure;

    public FunctionValue(List<String> parameters, BlockNode body, Environment closure) {
        this.parameters = parameters;
        this.body = body;
        this.closure = closure;
    }
}
