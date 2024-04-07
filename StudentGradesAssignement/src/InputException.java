public class InputException {
    public void marks(int mark){
        if((mark>=0)&&(mark<=100)){
          throw new ArithmeticException("Mark should be between 0 and 100");

        }

    }
}
