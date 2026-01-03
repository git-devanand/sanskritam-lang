package splc.interpreter;

public class Value {

    public final Object value;

    public Value(Object value) {
        this.value = value;
    }

    public int asInt() {
        return (int) value;
    }

    public double asDouble() {
        return (double) value;
    }

    public boolean asBoolean() {
        return (boolean) value;
    }

    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

