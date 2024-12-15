import java.util.regex.Pattern;

public class Sum {
    public static void main(String[] args) {
        double res = 0;
        for (int i = 0; i < args.length; i++) {
            if (isFloat(args[i])) {
                res += Double.parseDouble(args[i]);
            } else {
                res += 0;
            }
        }
        System.out.println(res);
    }

    //код проверки взял со StackOverflow: https://stackoverflow.com/questions/3543729/how-to-check-that-a-string-is-parseable-to-a-double
    private static final Pattern DOUBLE_PATTERN = Pattern.compile(
            "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
                    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
                    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
                    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");

    public static boolean isFloat(String s)
    {
        return DOUBLE_PATTERN.matcher(s).matches();
    }
}