import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input arabian or roman digits from 1 to 10. Format: 1 + 2 or III + IV");
        String s = reader.readLine().toUpperCase();
        String[] strings = s.split(" ");
        boolean arOrRom = false;
        int a = 0;
        int b = 0;
        try {
            if (Calculator.isDigit(strings[0]) && Calculator.isDigit(strings[2])) {
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[2]);
            } else if (Roman.valueOf(strings[0]) instanceof Enum && Roman.valueOf(strings[2]) instanceof Enum) {
                arOrRom = true;
                a = Roman.valueOf(strings[0]).getNum();
                b = Roman.valueOf(strings[2]).getNum();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect input format. Try again.");
            return;
        }
        int result = 0;
        if ((a > 0 && a <= 10) && (b > 0 && b <= 10)) {
            Calculator calculator = new Calculator(a, b);
            switch (strings[1]) {
                case "+": result = calculator.sum();break;
                case "-": result = calculator.sub();break;
                case "*": result = calculator.mul();break;
                case "/": result = calculator.div();break;
                default:
                    throw new IllegalStateException("Unexpected value: " + strings[1]);
            }
        } else throw new IOException("Too big/small number");

        if (arOrRom && result < 0) {
            throw new IOException("Rome number below 0, try arabian digits");
        } else if (arOrRom) {
            System.out.println(Roman.arabicToRoman(result));
        } else System.out.println(result);

        reader.close();
    }
}
