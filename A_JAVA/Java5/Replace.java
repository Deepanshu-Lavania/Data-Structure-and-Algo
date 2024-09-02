package A_JAVA.Java5;
import java.util.regex.*;
public class Replace {
    public static void main(String[] args) {
        Pattern p1= Pattern.compile("     ");
        String s1= "Welcome     to LearnveranV,     and Enjoy  yout learning ";
        Matcher m1= p1.matcher(s1);
        String rFirst =m1.replaceAll(" ");
        System.out.println(rFirst);

        Pattern p2= Pattern.compile("1dollar");
        Matcher m2=p2.matcher("I have 1dollar of rate 75 rupees for 1dollar");
        String replaceString = m2.replaceFirst(m2.quoteReplacement("1$"));
        System.out.println(replaceString);
    }
}
