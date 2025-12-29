package splc.ast;

public interface Visitor<T> {

    // Program
    T visit(ProgramNode node);

    // Statements
    T visit(VarDeclNode node);

    T visit(AssignNode node);

    T visit(IfNode node);

    T visit(WhileNode node);

    T visit(FunctionNode node);

    T visit(ReturnNode node);

    T visit(BlockNode node);

    // Expressions
    T visit(BinaryExprNode node);

    T visit(UnaryExprNode node);

    T visit(LiteralNode node);

    T visit(IdentifierNode node);
}
