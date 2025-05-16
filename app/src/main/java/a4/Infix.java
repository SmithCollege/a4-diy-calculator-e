package a4;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * A class that converts an infix expression into a postfix expression and evaluates it
 */
public class Infix {


    /**
     * A method converting an infix expression to postfix and evaluating it 
     * @param tokens an ArrayDeque of Character and Double objects representing the infix expression 
     * @return the resulting Double
     */
    public static double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Object> stack = new ArrayDeque<Object>();
        ArrayDeque<Object> outputQueue = new ArrayDeque<Object>();
        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put((Character)'(', 4);
        precedence.put((Character)')', 4);
        precedence.put((Character)'^', 3); 
        precedence.put((Character)'*', 2);
        precedence.put((Character)'/', 2);
        precedence.put((Character)'+', 1);
        precedence.put((Character)'-', 1); 

        int tokensLength = tokens.size();
        // read a token
        for(int i = 0; i < tokensLength; i++){
            System.out.println("");
            System.out.println("tokens: " + tokens);
            System.out.println("Stack: " + stack);
            System.out.println("outputQueue: " + outputQueue);
            System.out.println("");
            // if the token is a number, add it to the output queue
            if(tokens.getFirst() instanceof Double){
                outputQueue.add(tokens.getFirst());
                tokens.removeFirst();
            } 
            //if the token is an operator
            else if(tokens.getFirst() instanceof Character && tokens.getFirst() != (Object)'(' && tokens.getFirst() != (Object)')'){
                //while there is an operator token at the top of the stack and the stack operator has >= precedence
                Object queueOperator = tokens.getFirst();
                System.out.println("Stack: " + stack);
                while(stack.size() > 0 && stack.getLast() instanceof Character && precedence.get(stack.getLast()) >= precedence.get(queueOperator) && stack.getLast() != (Object)'(' && stack.getLast() != (Object)')'){
                    //pop the stack operator off the stack and add it to the output queue
                    outputQueue.addLast(stack.getLast());
                    stack.remove(stack.getLast());
                }  
                //when no more >= operators remain, push the queue operator onto the stack
                stack.addLast(tokens.getFirst());
                tokens.remove(tokens.getFirst());
            }
            //if the token is a left parenthesis, then push it onto the stack 
            else if(tokens.getFirst() == (Object)'('){
                stack.addLast(tokens.getFirst());
                tokens.remove(tokens.getFirst());
            } 
            //if the token is a right parenthesis, 
            else if(tokens.getFirst() == (Object)')'){
                System.out.println("Right Paren Detected");
                //until the token at the top of the stack is a left parenthesis
                while(stack.size() > 0 && stack.getLast() != (Object)'('){
                    //pop operators off the stack onto the output queue
                    System.out.println("Stack: " + stack);
                    System.out.println("Queue: " + outputQueue);
                    System.out.println("stack.getLast() is " + stack.getLast() + " removing top stack operator");
                    outputQueue.add(stack.getLast());
                    stack.removeLast();
                    System.out.println(stack.getLast());
                }
                //pop the left parenthesis from the stack, but not onto the output queue 
                if(stack.size() > 0 && stack.getLast() == (Object)'('){
                    stack.removeLast();
                } else {
                    //if the stack runs out without finding a left parenthesis,
                    //then there are mismatched parentheses 
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
                tokens.removeFirst();
            }
        }
        //when there are no more tokens to read
        //while there are still tokens in the stack  
        while(stack.size() > 0){
            //if the token on top of the stack is a parenthesis, 
            //then there are mismatched parentheses 
            if(precedence.get(stack.getLast()) == 4){
                throw new IllegalArgumentException("Mismatched parentheses");
            } 
            //if its an operator pop it onto the output queue 
            else if(stack.getLast() instanceof Character){
                outputQueue.add(stack.getLast());
                stack.remove(stack.getLast());
            }
        }
        //exit 
        return Postfix.postfix(outputQueue);
    }

}

