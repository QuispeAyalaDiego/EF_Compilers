import java.util.HashMap;
import java.util.Map;

public class SimpleLanguageListener extends SimpleLanguageBaseListener {
    private Map<String, Integer> variables = new HashMap<>();

    @Override
    public void exitAssignment(SimpleLanguageParser.AssignmentContext ctx) {
        String variable = ctx.ID().getText();
        int value = evaluateExpression(ctx.expression());
        variables.put(variable, value);
        System.out.println("IR: " + variable + " = " + value);
    }

    @Override
    public void exitIfStatement(SimpleLanguageParser.IfStatementContext ctx) {
        boolean condition = evaluateLogicalExpression(ctx.logicalExpression());
        if (condition) {
            System.out.println("IR: Entering IF block");
            // Process statements inside IF block
            for (SimpleLanguageParser.StatementContext statementContext : ctx.statement()) {
                statementContext.exitRule(this);
            }
            System.out.println("IR: Exiting IF block");
        } else if (ctx.ELSE() != null) {
            System.out.println("IR: Entering ELSE block");
            // Process statements inside ELSE block
            for (SimpleLanguageParser.StatementContext statementContext : ctx.statement(1)) {
                statementContext.exitRule(this);
            }
            System.out.println("IR: Exiting ELSE block");
        }
    }

    @Override
    public void exitPrintStatement(SimpleLanguageParser.PrintStatementContext ctx) {
        int value = evaluateExpression(ctx.expression());
        System.out.println("IR: print " + value);
    }

    private int evaluateExpression(SimpleLanguageParser.ExpressionContext ctx) {
        if (ctx.ID() != null) {
            String variable = ctx.ID().getText();
            return variables.getOrDefault(variable, 0);
        } else if (ctx.NUMBER() != null) {
            return Integer.parseInt(ctx.NUMBER().getText());
        } else {
            int left = evaluateExpression(ctx.expression(0));
            int right = evaluateExpression(ctx.expression(1));
            return ctx.op.getType() == SimpleLanguageParser.ADD ? left + right : left - right;
        }
    }

    private boolean evaluateLogicalExpression(SimpleLanguageParser.LogicalExpressionContext ctx) {
        int left = evaluateExpression(ctx.expression(0));
        int right = evaluateExpression(ctx.expression(1));
        return left == right;
    }
}
