package Java5;
import java.util.regex.*;
public class Regex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("L[a-zA-Z]*V");
        Matcher matcher=pattern.matcher("lhkh Ldfgds  stansde for LpreajtV  apf Lhigv   af");
        System.out.println(" <=== Matche Operation Start ===> ");
        if(matcher.matches()){//matches whole input with pattern
            System.out.println("String Matches the patterns ");
        }else{
            System.out.println("String doesn't match");
        }
        if(matcher.lookingAt()){
            System.out.println("Pattern found at begining");
        }else{
            System.out.println("Pattern does not found at begining");
        }
        if(matcher.find()){
            System.out.println("pattern match in the input string");
            System.out.println("matcher start : "+matcher.start());
            System.out.println("matcher end character : "+matcher.end());
        }else{
            System.out.println("Patten does not match in the string");
        }
        if(matcher.find(15)){
            System.out.println("L[a-zA-Z]*V is in the string after position");
        }else{
            System.out.println("not at 15 position");
        }
    }
}
