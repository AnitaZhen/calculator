import java.util.*;

public class Evaluator {
    //Both Operand and Operator Stack holds in the operator class
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;

    private StringTokenizer tokenizer;//tokenizr get the equation of the expression
    private static final String DELIMITERS = "()+-*^/#! ";//goes through each operator 
    
    public void process(){//analyze the expression and see if the numbers exist and start popping off numbers off the stack
        while(operatorStack.peek().priority() > 1){
            Operator oldOpr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push( oldOpr.execute( op1, op2 ));
        }
        operatorStack.pop();

    }

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

   //the string expression takes the equation and breaks it into the operand class and operator class
    public int evaluate( String expression ) {
        //stores the expression into token function in the Hash
        //in this Evaluate method, we will look at the expression and pass in the values in the Delimeter.
        //We have a true in the parameters because it checks whether the integer exists or not. If not, it will print that it is an invalid expression and exit
        
        String token;
        operatorStack.push(new Hash());
        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        //    expression=expression+"!";
        this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );
        
         // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
    
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators

        // TODO Operator is abstract - this will need to be fixed:
        // operatorStack.push( new Operator( "#" ));

    // When is it a good time to add the "!" operator?
        
        while ( this.tokenizer.hasMoreTokens() ) {//we havde a series of while loops because in the expression we have more tokens when user enters its values
            // filter out spaces
             token = this.tokenizer.nextToken();
            if ( !token.equals( " " )) {
                // check if token is an operand
                if ( Operand.check(token)) {
                    operandStack.push( new Operand( token ));
                     System.out.println("stack peek "+ operandStack.peek().getValue());
                } else {
                    if (! Operator.check( token )) {
                        System.out.println( "*****invalid token******" );
                        System.exit( 1 );
                       
                    }
                    Operator newOperator =(Operator)Operator.operators.get(token);
                  // TODO Operator is abstract - these two lines will need to be fixed:
                  // The Operator class should contain an instance of a HashMap,
                  // and values will be instances of the Operators.  See Operator class
                  // skeleton for an example.
           //the subtract symbol is not an operator, so we go to the else operator and pushes the operator into the stack
            //this let the system check whether the expression on the stack is created or not        
                    if(token.equals("(")){
                        operatorStack.push(new OpenLeftParenthesis());
                        continue;
                    }
                    if(token.equals(")")){
                        process();
                        continue;
                    }
                    //first when it runs the program, the system will believe we just started to run the expression; 
                    // meaning it starts with an empty operator stack
                    //Operator newOperator = Operator.getOperator(token);
                    if(operatorStack.isEmpty()){//checks if the stack is empty
                        operatorStack.add(newOperator);
                        continue;
                    }
                    //then we will put things onto the stack so we can build the operator stack
                    //in the while loop, the operand and operator stack gets separated and we pop its values and lastly, evaulate its equation
                    // the pop operator and operand pushes the calculated value onto the operand stack
                   while ( operatorStack.peek().priority() >= newOperator.priority()) {
                        Operator oldOpr = operatorStack.pop();
                        Operand op2 = operandStack.pop();
                        Operand op1 = operandStack.pop();
                        operandStack.push( oldOpr.execute( op1, op2 ));
                    }
                    operatorStack.push(newOperator);
                }
            }
        }
           // note that when we eval the expression 1 - 2 we will
            // push the 1 then the 2 and then do the subtraction operation
            // This means that the first number to be popped is the
            // second operand, not the first operand - see the following code
        while(operatorStack.peek().priority() > 0){
            Operator Opr = operatorStack.pop();
            Operand o2 = operandStack.pop();
            Operand o1 = operandStack.pop();
            operandStack.push(Opr.execute(o1, o2));
        }
        // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop; also, move the stacks out of the main
    // method
        return operandStack.peek().getValue();
    }

}
