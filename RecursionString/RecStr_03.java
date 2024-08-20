package RecursionString;

public class RecStr_03 {
    static int bestMinCost(int arr[],int n, int idx ){

        //base case 
        if (idx==n-1) {
            return 0;
        }
        //smaller problem + Recurseive call 
        int op1 = Math.abs(arr[idx]-arr[idx+1])+bestMinCost(arr, n, idx+1);
        //base case if array size is 1
        if (idx==n-2) {
            return op1;
        }
        int op2 =Math.abs(arr[idx]-arr[idx+2])+bestMinCost(arr, n, idx+2);

        return Math.min(op1,op2);
        //?\Time Complexity is O(2^n)
    }
    static void printComb(String digit,String kpArr[],String res){//"253"
        if(digit.length()==0){
            System.out.print(res+" ");
            return;
        }
        int kpArrIdx=digit.charAt(0)-'0';//convert character into integer for each char of digit //2
        String currChoices = kpArr[kpArrIdx];//"abc"
        for (int i = 0; i < currChoices.length(); i++) {
            //loop used so that we can click btn of keypad number of times that means, for btn 2: if one time click then press a ,if two times click then press b and if three times click then press c
            printComb(digit.substring(1), kpArr, res+currChoices.charAt(i));
        }
    }
    public static void main(String[] args) {
        //! Ques : There are N strines, numbered 0,1,2,...N-1. For each i (0<-i<=N), the height of Stone i is hi. There is a frog who is initially on Stone 0. He will repeat the followig action some numbre of times to rach stone N-1: If the frog is currently on Stone i, jump tot Stone i+1 or Strone i+2. Here, a cost of |hi-hj| is incurred, where j is hte stone to land on.
        
        int arr[]={10,30,40,20};
        int n=arr.length;
        
        System.out.println("The best cost for going intial to last position via jump by (i+1) or (i+2) is : "+bestMinCost(arr, n, 0));

        //! Ques : Give n a string containting digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
        String kpArr[]={"","","abc","def","ghe","ijk","lmn","pqrs","tuv","wxyz"};
        String digit="23";
        //? Ques : string permutation for each element of array
        printComb(digit,kpArr," ");
    }
}
