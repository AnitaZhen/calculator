public class Operand{
    String token;//store token into the string
    private int value;
    
    public int getValue() {//getters
        return value;
    }
    public Operand( int value ) {//setters
        this.value = value;
    }

    public Operand( String token ) {
        this.value = Integer.parseInt(token);

    }
    public static boolean check( String token ) {//checks to see if the number 
    //is a number, integer provide function composes a number and convert to a 
    //number-function overloading
        //if not a number it will catch its error
        try{
            Integer.parseInt(token);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;

    }
}
