package A_JAVA.Java4.ErrorHandling;


class NegativeRadiusException extends Exception{
    public String toString(){
        return "Radius can't be negative";
    }
    public String getMessage(){
        return "Radius cannot be negative";
    }
}

public class Error {

    public static int divide(int a, int b) throws ArithmeticException{
        if(a<=0 || b<=0){
            throw new ArithmeticException();
        }
        int result = a / b;
        return result;
    }
    public static double area(int r) throws NegativeRadiusException{
        if(r<=0){
            throw new NegativeRadiusException();
        }
        double result = Math.PI * r * r;
        return result;

    }


    public static void main(String[] args) {
        try{
            int c =divide(6,0);
            System.out.println(c);
        }catch(Exception e){
            System.out.println(e);
        }
        
        try {
            double result = area(0);
            System.out.println(result);
        } catch (NegativeRadiusException e) {
            System.out.println("NegativeRadiusException caught: " + e.getMessage());
        }

    }
}
