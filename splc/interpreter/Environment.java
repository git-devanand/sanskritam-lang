package splc.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Environment {

    private final Map<String, Value> values = new HashMap<>();
    private final Environment parent;

    public Environment() {
        this.parent = null;
    }

    public Environment(Environment parent) {
        this.parent = parent;
    }

    public void define(String name, Value value) {
        values.put(name, value);
    }

    public void assign(String name, Value value) {
        if (values.containsKey(name)) {
            values.put(name, value);
            return;
        }
        if (parent != null) {
            parent.assign(name, value);
            return;
        }
        throw new RuntimeException("अपरिभाषित चलः: " + name);
    }

    public Value get(String name) {
        if (values.containsKey(name)) {
            return values.get(name);
        }
        if (parent != null) {
            return parent.get(name);
        }
        throw new RuntimeException("अपरिभाषित चलः: " + name);
    }
}
