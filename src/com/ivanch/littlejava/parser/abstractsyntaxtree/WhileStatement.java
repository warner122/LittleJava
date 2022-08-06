package com.ivanch.littlejava.parser.abstractsyntaxtree;

public class WhileStatement implements Statement {
	
    private Expression condition;
    private Statement statement;

    public WhileStatement(Expression condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }
    
    @Override
    public void execute() {
        while (condition.eval().asNumber() != 0) {
            try {
                statement.execute();
            } catch (BreakStatement bs) {
                break;
            } catch (ContinueStatement cs) {
                // continue;
            }
        }
    }

    @Override
    public String toString() {
        return "while " + condition + " " + statement;
    }
}
