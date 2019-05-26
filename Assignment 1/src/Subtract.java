public class Subtract extends Operator {//created Subtract to hashmap

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        //when we execute we are extending its operator and implement the execute method.
        Operand change= new Operand(op1.getValue() - op2.getValue());
        return change;
    }//returns the new constructor pushed in the operator stack
}