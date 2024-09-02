package A_JAVA.Java1;

public class Bitwise {
    public static void main(String[] args) {
        int num1=11;

        System.out.println(num1<<2);//left shift
        System.out.println(num1>>2);//right shift

        int a=9, b=10;
        System.out.println(a|b);//11
        System.out.println(a&b);//8
        System.out.println(a^b);//same bit is = 0

        System.out.println("Statement question start : ");
        int p=5,q;
        boolean r;
        q=p=15;//p=15,q=15
        r=p<15;//false
        System.out.println("p="+p+"q="+q+"r="+r);
    }
}
