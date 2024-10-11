package ru.courses.math;

public class Fraction extends Number {
    private final int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        super();
        if (denominator<0) throw new IllegalArgumentException("Знаменатель не может быть отрицательным");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public byte byteValue() {
        return super.byteValue();
    }

    @Override
    public short shortValue() {
        return super.shortValue();
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    public Fraction sum(Fraction f) {
        int resDenominator = leastCommonMultiple(this.denominator, f.denominator);
        int thisMultiplyBy = resDenominator / this.denominator;
        int fMultiplyBy = resDenominator / f.denominator;
        int resNumerator = this.numerator * thisMultiplyBy + f.numerator * fMultiplyBy;
        int greatestCommonDivisor = greatestCommonDivisor(resNumerator, resDenominator);
        return new Fraction(resNumerator / greatestCommonDivisor,resDenominator / greatestCommonDivisor);
    }

    public Fraction sum(int x) {
        return sum(new Fraction(x, 1));
    }

    public Fraction minus(Fraction f) {
        return sum(new Fraction(-f.numerator, f.denominator));
    }

    public Fraction minus(int x) {
        return sum(-x);
    }

    private int leastCommonMultiple(int a, int b) {
        if (a==0 || b==0) return 0;
        a = Math.abs(a);
        b = Math.abs(b);
        int absMax = Math.max(a, b);
        int absMin = Math.min(a, b);
        int leastCommonMultiple = absMax;
        while (leastCommonMultiple % absMin != 0) {
            leastCommonMultiple+=absMax;
        }
        return leastCommonMultiple;
    }

    private int greatestCommonDivisor(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        return greatestCommonDivisor(b, a % b);
    }

    @Override
    public String toString() {
        return String.format("%d/%d%n", numerator, denominator);
    }
}
