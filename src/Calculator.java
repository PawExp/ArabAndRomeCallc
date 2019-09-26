public class Calculator {
    private int a;
    private int b;

    public Calculator(int a, int b) {
            this.a = a;
            this.b = b;
    }

    public int sum(){
        return a + b;
    }
    public int sub(){
        return a - b;
    }
    public int mul(){
        return a * b;
    }
    public int div(){
        return a / b;
    }

    protected static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
