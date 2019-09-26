import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Roman {
    NULLA(0), I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10), XI(11),
    XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17),
    XVIII(18), XIX(19), XX(20), XL(40), L(50), XC(90), C(100);
    private int num;

    Roman(int num) {
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    protected static String arabicToRoman(int result) { //https://www.codeflow.site/ru/article/java-convert-roman-arabic
        if(result == 0)return Roman.NULLA.toString();

        List<Roman> romanNumerals = Arrays.asList(Roman.values());
        Collections.reverse(romanNumerals);
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((result > 0) && (i < romanNumerals.size())) {
            Roman currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getNum() <= result) {
                sb.append(currentSymbol.name());
                result -= currentSymbol.getNum();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
