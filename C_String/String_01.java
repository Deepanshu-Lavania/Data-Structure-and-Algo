package C_String;

public class String_01 {
    public static void main(String[] args) {
        String s = "abcd";
        // ! Ques : To find substring of a string
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                System.out.print(s.substring(i, j) + " ");
            }
        }
        System.out.println();
        // !Quse : To toggle all the characters
        String input = "PhysiCS";
        String newString= "";
        for (int i = 0; i <input.length(); i++) {
            boolean flag=true;
            char ch=input.charAt(i);
            if(ch==' ') continue;
            System.out.println("P is : "+ch);
            int ascii=(int)ch;
            if(ascii>97) flag=false;
            if (flag==true) {//capital letter
                ascii+=32;
                char dh=(char)ascii;
                System.out.println("d is : "+dh);
                input = input.substring(0, i)+dh+input.substring(i+1);
            }else{
                ascii-=32;
                char uh=(char)ascii;
                input = input.substring(0, i)+uh+input.substring(i+1);

            }
        }
        System.out.print(input);
    }
}
