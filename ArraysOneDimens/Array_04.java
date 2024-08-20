package ArraysOneDimens;

// import java.util.Arrays;

class ArrayClass {
    //? Pattern : Target_Sum Questions
    // ! Ques: Count the number of pair whose sum is equal to the given value x
    void Pairsum() {
        int arr[] = { 4, 6, 3, 5, 8, 2, 1, 0 };
        int ele = 7;
        int pair = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (ele == (arr[i] + arr[j])) {
                    System.out.println("arr[i]  at index " + i + " is : " + arr[i] + " and " + "arr[j]  at index " + j
                            + " is : " + arr[j] + " i.e., ( " + arr[i] + " , " + arr[j] + ")");
                    pair++;
                }
            }
        }
        System.out.println("the number of pair is : " + pair);
    }

    // ! Ques: Count the number of triplets whose sum is equal to the given value x
    void Tripletsum() {
        int arr[] = { 1, 4, 5, 6, 3 };
        int ele = 12;
        int triplet = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (ele == (arr[i] + arr[j] + arr[k])) {
                        System.out.println("( " + arr[i] + " , " + arr[j] + " , " + arr[k] + ")");
                        triplet++;
                    }
                }
            }
        }
        System.out.println("the number of pair is : " + triplet);
    }

    //? Pattern : Target_Pattern Questions
    // !Imp Ques: Find the unique number in a given Array where all the elements are being repeated twice with one value being unique.
    // Algo : 
        //   step1 : Traverse all pairs 
        //   step2 : Equal pairs -> Mark -1
        //   step3 : Traverse array which is > 0
    //
    void uniqueVal() {
        int arr[] = { 1, 2, 3, 4, 5, 2, 1, 3 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                idx = arr[i];
            }
        }
        System.out.print("Unique element is : " + idx);
    }

    // ! Ques : Find the second largest element from array
    void IILargest() {
        System.out.println();
        int arr[] = { 5, 2, 5, 3, 5 };
        int FirstMax = Integer.MIN_VALUE;
        System.out.println(FirstMax);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > FirstMax) {
                FirstMax = arr[i];
            }
        }
        System.out.println("First Maximum element is : " + FirstMax);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == FirstMax) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
        int SecondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > SecondMax) {
                SecondMax = arr[i];
            }
        }
        System.out.println("Second Maximum element is : " + SecondMax);

        // ? or
        // But this approch is not applicable when largest element is similar to
        // previous one like ; {1,4,5,2,5,3,5}
        // Arrays.sort(arr);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]+ " ");
        // }
        // System.out.print(arr.length-1);

    }

}

public class Array_04 {
    //! Ques : Return the first value that is repeating in this array. If no value is being repeated return -1.
    static int FirstRepVal() {
        int arr[] = { 1, 5, 3, 4, 6, 3, 4 };
        // int RepeatVal = 0;
        // outerLoop:
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i + 1; j < arr.length; j++) {
        //         System.out.println(arr[i] +" , "+arr[j]);
        //         if (arr[i] == arr[j]) {
        //             RepeatVal = arr[i];
        //             break outerLoop;
        //         }
        //     }
        // }
        // if (RepeatVal == 0) {
        //     return -1;
        // } else {
        //     return RepeatVal;
        // }

        //* or 
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]==arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
    static int LastRepVal(){
        int RepeatLast = 0;
        int arr[]= { 1, 5, 3, 4, 6, 3, 4 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    RepeatLast=arr[i];
                }
            }
        }
        return RepeatLast;
    }

    public static void main(String[] args) {
        ArrayClass arr = new ArrayClass();

        arr.Pairsum();
        arr.Tripletsum();
        arr.uniqueVal();
        arr.IILargest();
        // FirstRepVal();
        System.out.println("Repeat value is : "+FirstRepVal());
       System.out.println("Repeat value is : "+LastRepVal());
    }
}
