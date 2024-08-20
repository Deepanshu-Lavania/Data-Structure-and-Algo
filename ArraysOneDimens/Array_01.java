package ArraysOneDimens;

import java.util.Scanner;

class ArrayCollection{
    //! Ques1 : To print sum of array
    void sumOfArray(){
        int sarr[] = {1,5,6};
        int sum =0;
        for (int i = 0; i < sarr.length; i++) {
            System.out.print(sarr[i]+" ");
            sum = sum+sarr[i];
        }
        System.out.println("the sum of array is : "+ sum);
    }
    //! Ques2 : To print greatestValue of array
    void greaterValue(){
        int[] garr={1,5,3};
        int gvalue=0;
        for (int i = 0; i < garr.length; i++) {
            if(garr[i]>gvalue){
                gvalue=garr[i];
            }
        }
        System.out.println("the greater value from the array is : "+gvalue);
    }

    //! Ques3 : To find Value in array
    void findValue(){
        int fVarr[]={1,5,3,5,6,7,7,8,8,8,9,9,9,9,9,6,6,5,4,4,4,3,3,3,3};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for find in arrray : ");
        int fvalue = sc.nextInt();
        int ans =-1;
        for (int i = 0; i < fVarr.length; i++) {
            if(fVarr[i]==fvalue){
                ans =i;
                break;
            }
        }
        if(ans==-1){
            System.out.println("There is no such value " + fvalue +" at any index");
        }else{
        System.out.println("Found "+fvalue+" is at index "+ ans +" number" );
        }
    }
}
public class Array_01 {
    public static void main(String[] args) {
        ArrayCollection Array = new ArrayCollection();
        int[][] arr= {{1,3,4},{5,6,7},{4,6,7},{3,5}};
        System.out.println(arr[0][1]);
        for (int i = 0; i < arr.length; i++) {
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
        Array.sumOfArray();
        Array.greaterValue();
        Array.findValue();
    }    
}