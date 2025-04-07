package Question1;

public class InfixExpressionEvaluator {

    public static int evaluate(String expression) {
        StackInterface<Integer> operands = new ArrayStack<>();
        StackInterface<String> operators = new ArrayStack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isInteger(token)) {
                operands.push(Integer.parseInt(token)); // pushing integer into stack
            } else if (isOperator(token)) {
                // is operator of lower presedence is input then all operators of higher presedence are evaluated
                while (!operators.isEmpty() && hasHigherPrecedence(operators.peek(), token)) {
                    processOperator(operators, operands); 
                }
                operators.push(token);
            } else if (token.equals("(")) { // Case for curved brackets
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    processOperator(operators, operands);
                }
                operators.pop(); // Pop the '('
            }
        }

        // Evaluate remaining operators
        while (!operators.isEmpty()) {
            processOperator(operators, operands);
        }

        return operands.pop();
    }

    // Check if the token is an integer or not
    private static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Check if the token is an operator
    private static boolean isOperator(String token) {
        return "+-*/==!=<><=>>=&&||!".contains(token);
    }

    // Compare precedence
    private static boolean hasHigherPrecedence(String op1, String op2) {
        return getPrecedence(op1) > getPrecedence(op2) ||
               (getPrecedence(op1) == getPrecedence(op2) && isLeftAssociative(op1));
    }

    // Assign precedence to each operator
    private static int getPrecedence(String operator) {
        switch (operator) {
            case "||": return 1;
            case "&&": return 2;
            case "==": case "!=": return 3;
            case "<": case ">": case "<=": case ">=": return 4;
            case "+": case "-": return 5;
            case "*": case "/": return 6;
            case "!": return 7;
            default: return 0;
        }
    }

    // For left-only operators, e.g., !
    private static boolean isLeftAssociative(String operator) {
        return !operator.equals("!");
    }

    // Evaluate the operator with the left and right operand
    private static void processOperator(StackInterface<String> operators, StackInterface<Integer> operands) {
        String operator = operators.pop();
        int right = operands.pop();
        int left = operator.equals("!") ? 0 : operands.pop(); // '!' is unary

        int result;
        switch (operator) {
            case "+": result = left + right; break;
            case "-": result = left - right; break;
            case "*": result = left * right; break;
            case "/": result = left / right; break;
            case "==": result = (left == right) ? 1 : 0; break;
            case "!=": result = (left != right) ? 1 : 0; break;
            case "<": result = (left < right) ? 1 : 0; break;
            case ">": result = (left > right) ? 1 : 0; break;
            case "<=": result = (left <= right) ? 1 : 0; break;
            case ">=": result = (left >= right) ? 1 : 0; break;
            case "&&": result = ((left != 0) && (right != 0)) ? 1 : 0; break;
            case "||": result = ((left != 0) || (right != 0)) ? 1 : 0; break;
            case "!": result = (right == 0) ? 1 : 0; break;
            default: throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
        operands.push(result);
    }

    public static void main(String[] args) {
        String expression = "3 + 5 * ( 10 - 4 )";
        System.out.println(evaluate(expression));
    }
}