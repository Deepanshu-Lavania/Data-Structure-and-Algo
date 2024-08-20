package C_String;

public class OOPs_01 {
    public static Fraction add(Fraction f1, Fraction f2){
        int numerator = f1.num*f2.den + f1.den*f2.num;
        int denominator =f1.den+f2.den;
        Fraction f3 = new Fraction(numerator,denominator);
        return f3;
    }
    public static Fraction add2(Fraction f1, Fraction f2){
        f1.num = f1.num*f2.den + f1.den*f2.num;
        f1.den=f1.den+f2.den;
        Fraction f3 = new Fraction(f1.num,f1.den);
        return f3;
    }
    public static Fraction mul(Fraction f1, Fraction f2){
        int numerator = f1.num*f2.num;
        int denominator =f1.den*f2.den;
        Fraction f3 = new Fraction(numerator,denominator);
        return f3;
    }
    public static int gcd(int num, int den) {
        // int min = Math.min(num, den);
        // for (int i = min; i > 0; i--) {
        //     if (num % i == 0 && den % i == 0) return i;
        // }
        // return min;
        int x=num;
        int y=den;
        while (y!=0) {
            int temp=y;
            y=x%y;
            x=temp;
        }
        return x;
    }

    public static class Fraction {
        int num;
        int den;

        public Fraction(int num, int den) {
            this.num = num;
            this.den = den;
            simplify();
        }

        public void simplify() {
            int hcf = gcd(num, den);
            num /= hcf;
            den /= hcf;
        }
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(35, 21);
        // f1.simplify();
        System.out.println(f1.num+"/"+f1.den);
        Fraction f2 = new Fraction(7, 3);
        System.out.println(f2.num+"/"+f2.den);
        System.out.println("<============ add into another variable ============>");
        Fraction f3 = add(f1,f2);
        System.out.println(f3.num+"/"+f3.den);
        Fraction f4 = mul(f1,f2);
        System.out.println(f4.num+"/"+f4.den);
        Fraction f5 = add2(f1,f2);
        System.out.println("<============ add into f1 variable ==============>");
        System.out.println(f5.num+"/"+f5.den);
    }
}
