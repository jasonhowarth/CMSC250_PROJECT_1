/*
 * JASON HOWARTH
 * UMGC CMSC 250-6382 PROJECT 1
 * 25 JAN 2022
 * CLASS DESCRIPTION: CONVERTS INPUTTED EXPRESSION FROM PREFIX TO POSTFIX OR POSTFIX TO PREFIX
 */
package cmsc250_project_1;

//IMPORT
import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionConverter {

    //PREFIX TO POSTFIX METHOD
    public String preToPost(String expression) {
        Stack<String> reversalStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/^ ", true);
        
        //tokenize the string containing the prefix expression while there are more tokens
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            //push the token onto a reversal stack if it is not a space
            if (!token.equals(" ")) {
                reversalStack.push(token);
            }
        }

        //  while the reversal stack is not empty
        while (!reversalStack.isEmpty()) {
            //pop the next token from the reversal stack
            String rsToken = reversalStack.pop();
            //if it is an operand
            if (Character.isDigit(rsToken.charAt(0))) {
                //push it onto the *operand stack*
                operandStack.push(rsToken);
            //else it is an operator
            } else if (!rsToken.equals(" ")) {
                //pop two operands off of the operand stack
                String operand1 = operandStack.pop();
                String operand2 = operandStack.pop();
                //create a string with the two operands followed the operator
                String temp = operand1 + " " + operand2 + " " + rsToken + " ";
                //push that string onto the operand stack
                operandStack.push(temp);
            }
        }
        //pop the postfix expression off the stack
        String result = operandStack.pop();
        return result;
    }//END PRE TO POST

    //POSTFIX TO PREFIX METHOD
    public String postToPre(String expression) {
        Stack<String> operandStack = new Stack<>();
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/^ ", true);
        
        //tokenize the string containing the postfix expression while there are more tokens
        while (tokenizer.hasMoreTokens()) {
            //get the next token
            token = tokenizer.nextToken();
            //if it is a space skip it
            if (token.equals(" ")) {
                //else if it is an operand
            } else if (Character.isDigit(token.charAt(0))) {
                //push it onto the operand stack
                operandStack.push(token);
            // else it is an operator
            } else {
                //pop two operands off of the operand stack
                String rightOperand = operandStack.pop();
                String leftOperand = operandStack.pop();
                // create a string with the operator followed by two operands (operand order matters)
                String temp = token + " " + leftOperand + " " + rightOperand + " ";
                //push that string onto the operand stack
                operandStack.push(temp);
            }
        }
        //pop the prefix expression off the stack
        String result = operandStack.pop();
        return result;
    }//END POST TO PRE

}//END EXPRESSIONCONVERTER
