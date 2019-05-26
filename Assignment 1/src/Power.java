public class Power extends Operator{//created Power to hashmap

    @Override
    public int priority() {
        return 4;
    }
public int power(int a, int b){
        int key = a;
        for(int number = 2; number <= b; number++){
            key = key * a;
        }
        return key;

    }
    @Override
    public Operand execute(Operand op1, Operand op2) {
        //when we execute we are extending its operator and implement the execute method.
        Operand ans = new Operand(power(op1.getValue(),op2.getValue() ));
        return ans;
      //returns the new constructor pushed in the operator stack
    }
    

}
