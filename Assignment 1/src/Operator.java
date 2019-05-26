import java.util.HashMap;
public abstract class Operator {

    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );
   static final HashMap<String, Operator> operators = new HashMap<>();
    public abstract int priority();//goes through each operator and start executing with which priority has the highest precedance prints first
    static{
        operators.put("^", new Power());
        operators.put("*", new Multiply());
        operators.put("/", new Divide());
        operators.put("+", new Add());
        operators.put("-", new Subtract());
        operators.put("(", new OpenLeftParenthesis());
        operators.put("#", new Hash());
    }
    //these operator will extend its functions into its own package outside 
    //the Operator class. Since it has its same name it will perform different 
    //functions and returns its new constructor and push the result into the operator stack
   public static boolean check( String token ) {

        return token.equals("^")|| token.equals("*")||token.equals("/") ||
                token.equals("+")||token.equals("-")||token.equals("(")||token.equals(")");
    }

    public abstract Operand execute( Operand op1, Operand op2 );

     public static Operator getOperator(String token){
        return operators.get(token);
    }
}
