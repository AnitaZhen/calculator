public class Add extends Operator{//created Add to hashmap

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
//when we execute we are extending its operator and implement the execute method.
        Operand result = new Operand(op1.getValue() + op2.getValue());
        return result;
    }//returns the new constructor pushed in the operator stack

}