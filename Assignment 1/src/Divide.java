public class Divide extends Operator {//created Divide to hashmap

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
       //when we execute we are extending its operator and implement the execute method.
        Operand answer = new Operand(op1.getValue() / op2.getValue());
        return answer;
    }//returns the new constructor pushed in the operator stack

}