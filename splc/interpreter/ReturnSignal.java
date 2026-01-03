package splc.interpreter;

public class ReturnSignal extends RuntimeException {

    public final Value value;

    public ReturnSignal(Value value) {
        this.value = value;
    }
}

