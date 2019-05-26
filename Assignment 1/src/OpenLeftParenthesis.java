public class OpenLeftParenthesis extends Operator{//created ( to hashmap

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        //when we execute we are extending its operator and implement the execute method.
        return null;
    }
}
