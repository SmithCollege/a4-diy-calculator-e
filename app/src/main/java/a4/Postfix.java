package a4;

import java.util.ArrayDeque;

/**
 * A class that evaluates an equation written in postfix notation. If the expression is incorrect, it will produce an error. 
 */
public class Postfix {

    /**
     * A method implementing the postfix evaluation
     * @param tokens An ArrayDeque of Doubles and Characters representing the postfix expression 
     * @return the resulting Double 
     */
    public static Double postfix(ArrayDeque<Object> tokens) {
        System.out.println("");
        System.out.println("STARTING POSTFIX");
        ArrayDeque<Double> digitStack = new ArrayDeque<Double>();
        //allowing for single digits to be returned 
        if(tokens.size() == 1){
            // throwing an error if a single operator is entered 
            if(tokens.getFirst() instanceof Character){
                throw new IllegalArgumentException("Invalid input.");
            }
            return (Double) tokens.getFirst();
        }
        int queueLength = tokens.size();
        // iterating through the queue 
        for(int i = 0; i < queueLength; i++){
            System.out.println("Loop for: " + tokens.getFirst());
            System.out.println("starting queue: " + tokens);
            System.out.println("starting stack: " + digitStack);
            System.out.println(tokens.getFirst().getClass());
            // if the token is a number, add it to the digit stack  
            if(tokens.getFirst() instanceof Double){
                System.out.println("Double");
                digitStack.add((Double) tokens.getFirst());
                tokens.removeFirst();
                System.out.println("queue: " + tokens);
                System.out.println("stack: " + digitStack);
            } 
            // if the token is an operator, pop two numbers off the stack, 
            // combine using an operator 
            // and push the result back onto the stack 
            else if(tokens.getFirst() instanceof Character){
                System.out.println("operator: " + tokens.getFirst());
                Character operator = (Character) tokens.pollFirst();
                // accounting for incomplete expressions 
                if(digitStack.size() < 2){
                    throw new IllegalArgumentException("Invalid input."); 
                }
                Double x = digitStack.pollLast(); 
                Double y = digitStack.pollLast();
                System.out.println("Tokens is " + tokens);
                System.out.println("DigitStack is " + digitStack);
                Double result; 
                if(operator == '+'){
                    // this is y + x to account for Stack switching the order 
                    result = y + x; 
                    digitStack.add((Double) result);
                } 
                if(operator == '-'){
                    result = y - x; 
                    digitStack.add((Double) result); 
                }
                if(operator == '*'){
                    result = y * x; 
                    digitStack.add((Double) result);
                }
                if(operator == '/'){
                    result = y / x;
                    digitStack.add((Double) result);
                }
                if(operator == '%'){
                    result = y % x; 
                    digitStack.add((Double) result);
                } 
            } else {
                throw new IllegalArgumentException("Invalid input.");
            }
        }
        // once all of the operations have been completed, there should be one answer, the result, left in the stack
        if(digitStack.size() == 1){
            return digitStack.getFirst();
        } else {
            // if there are more than one Objects in the stack, the equation was imbalanced 
            throw new IllegalArgumentException("Imbalanced equation");
        }
    }
}