package a4;

class Main {
  public static void main(String[] args) {
    /* System.out.println("Calls from the command line:");
    System.out.println("    java Postfix <postfix-expr>");
    System.out.println("    java Calculate <infix-expr>");
     
    System.out.println(tokenizer.readTokens("3 2 +"));
    System.out.println(tokenizer.readTokens("3 2 +").getFirst()); */

    Tokenizer tokenizer = new Tokenizer();
    //System.out.println(Postfix.postfix(tokenizer.readTokens("1 1 + 1 +")));
    //System.out.println(tokenizer.readTokens("1 1 + 1 +"));
    //System.out.println(Postfix.postfix(tokenizer.readTokens("3.14159")));
    //System.out.println(tokenizer.readTokens("1 2 3 4 5 6 7 + + + + + +"));
    //System.out.println(Postfix.postfix(tokenizer.readTokens("1 3 3 + +")));
    //testPostfixPlus();
    //System.out.println(Postfix.postfix(tokenizer.readTokens("7 + 0")));
    System.out.println(Infix.infixToPostfix(tokenizer.readTokens("(5*(1+(((7-4)*(1+3))-((6+9)/(7-2)))-3)/0.2)/25")));

  }
}