package splc.interpreter;

import splc.ast.*;
import java.util.List;

public class Interpreter implements Visitor<Value> {

    private Environment environment = new Environment();

    /* ================= PROGRAM ================= */

    @Override
    public Value visit(ProgramNode node) {
        for (ASTNode stmt : node.statements) {
            stmt.accept(this);
        }
        return null;
    }

    /* ================= STATEMENTS ================= */

    @Override
    public Value visit(VarDeclNode node) {
        Value value = null;
        if (node.initializer != null) {
            value = node.initializer.accept(this);
        }
        environment.define(node.name, value);
        return null;
    }

    @Override
    public Value visit(AssignNode node) {
        Value value = node.value.accept(this);
        environment.assign(node.name, value);
        return null;
    }

    @Override
    public Value visit(BlockNode node) {
        Environment previous = environment;
        environment = new Environment(previous);

        try {
            for (StatementNode stmt : node.statements) {
                stmt.accept(this);
            }
        } finally {
            environment = previous;
        }
        return null;
    }

    @Override
    public Value visit(IfNode node) {
        boolean condition = node.condition.accept(this).asBoolean();

        if (condition) {
            node.thenBlock.accept(this);
        } else if (node.elseBlock != null) {
            node.elseBlock.accept(this);
        }
        return null;
    }

    @Override
    public Value visit(WhileNode node) {
        while (node.condition.accept(this).asBoolean()) {
            node.body.accept(this);
        }
        return null;
    }

    @Override
    public Value visit(FunctionNode node) {
        FunctionValue function = new FunctionValue(node.parameters, node.body, environment);
        environment.define(node.name, new Value(function));
        return null;
    }

    @Override
    public Value visit(ReturnNode node) {
        Value value = null;
        if (node.value != null) {
            value = node.value.accept(this);
        }
        throw new ReturnSignal(value);
    }

    /* ================= EXPRESSIONS ================= */

    @Override
    public Value visit(BinaryExprNode node) {
        Value left = node.left.accept(this);
        Value right = node.right.accept(this);

        switch (node.operator) {
            case "+":
                return new Value(left.asInt() + right.asInt());
            case "-":
                return new Value(left.asInt() - right.asInt());
            case "*":
                return new Value(left.asInt() * right.asInt());
            case "/":
                return new Value(left.asInt() / right.asInt());
            case ">":
                return new Value(left.asInt() > right.asInt());
            case "<":
                return new Value(left.asInt() < right.asInt());
            case "==":
                return new Value(left.value.equals(right.value));
            default:
                throw new RuntimeException("अमान्य संक्रिया: " + node.operator);
        }
    }

    @Override
    public Value visit(UnaryExprNode node) {
        Value value = node.expression.accept(this);

        switch (node.operator) {
            case "-":
                return new Value(-value.asInt());
            case "!":
                return new Value(!value.asBoolean());
            default:
                throw new RuntimeException("अमान्य एकाङ्ग संक्रिया");
        }
    }

    @Override
    public Value visit(LiteralNode node) {
        return new Value(node.value);
    }

    @Override
    public Value visit(IdentifierNode node) {
        return environment.get(node.name);
    }
}
