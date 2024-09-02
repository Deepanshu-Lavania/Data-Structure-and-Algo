package A_JAVA.Java5;

import java.util.regex.*;

public class RegexGroup {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(Learn)(Vern)");
        Matcher m=p.matcher("Learn from the Best Experts at LearnVern from Vern at Learn");
        while (m.find()) {
            System.out.println("Strart of Group 0: "+ m.start(0));
            System.out.println("Start of Group 1: "+m.start(1));
            System.out.println("End of Group 1: "+m.end(1));
            System.out.println("Start of Group 2: "+m.start(2));
            System.out.println("Start of Group 1: "+m.start(1));
        }
    }
}
