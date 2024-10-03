package A_JAVA.Java3.Revision;

public class Method_01 {
    static class Subtract{
        int c;
        int d;
        Subtract(int c,int d){
            this.c= c;
            this.d=d;
        }
        void sub(){
            System.out.println("Iam Sub insider the subtract class ");
        }
    }
    static class Addition extends Subtract{
        // You cannot directly instantiateAddition inside the main method because main is static, and static methods cannot access instance members (including non-static inner classes) without an instance of the outer class.
        int a ;
        int b ;
         
       Addition(int c,int a  ,int b,int d){
            super(c,d);
            this.a= a;
            this.b=b;
        }
        void add(){
            int d = this.a+this.b;
            int e = this.a-this.c;
            System.out.println("a , b & c are : "+ a +", "+b+", "+c);
            System.out.println("a + b = "+d +", a-c= "+e);
        }
        @Override//for good practice only allowed if same name mehod present in superClass 
        void sub(){//! Method Overriding 
            System.out.println("Iam Sub inside the Addition class ,this is called method over riding");
            int c =this.b/this.c;
            System.out.println(c);
            super.sub();
        }
        // super.sub(); can't call super class method  outside the body/method 
    }
    public static void main(String[] args) {
        Addition calc = new Addition(4,8,9,7);
        // "err message": "No enclosing instance of type Method_01 is accessible. Must qualify the allocation with an enclosing instance of type Method_01 (e.g. x.new A() where x is an instance of Method_01).",
        
        calc.add();
        calc.sub();
    }
}
