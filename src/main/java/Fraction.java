import java.util.Objects;

class Fraction implements Cloneable {
    int num,denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    public void num() {
        System.out.println("lel");
    }

    public String toString() {
        return num + "/" + denum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num && denum == fraction.denum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, denum);
    }

    @Override
    public Fraction clone() throws CloneNotSupportedException {
        return (Fraction) super.clone();
    }
}