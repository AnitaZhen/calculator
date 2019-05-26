public class Hash extends Operator {//created Hash to hashmap

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        //when we execute we are extending its operator and implement the execute method.
        return null;
    }//returns the new constructor pushed in the operator stack
}