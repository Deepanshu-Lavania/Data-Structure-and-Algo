package A_1DArray;
import java.util.*;

public class Hard_01 {
    public static int subArrDivK(int arr[], int k) {
        int ans = 0; // To store the count of subarrays
        HashMap<Integer, Integer> map = new HashMap<>(); // To store frequency of remainders
        map.put(0, 1); // Initialize for the case when the prefix sum itself is divisible by k
        int sum = 0, rem = 0; // Initialize sum and remainder
    
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Compute the prefix sum
            rem = sum % k; // Get the remainder of the prefix sum divided by k
    
            // Adjust remainder if it is negative
            if (rem < 0) {
                rem += k;
            }
    
            // Check if this remainder has been seen before
            if (map.containsKey(rem)) {
                ans += map.get(rem); // Add the count of this remainder to the answer
            }
    
            // Update the frequency of the current remainder in the map
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
    
        return ans; // Return the final count of subarrays
    }
    public static void allCombination(int arr[], int r, int start, List<Integer> comList){
        if (comList.size()==r) {//Base Condition
            System.out.print(comList+" ");
            return;
        }
        for (int i = start; i < arr.length; i++) {
            comList.add(arr[i]);//add curEle
            allCombination(arr, r, i+1, comList);//Recur to add next element
            comList.remove(comList.size()-1);//Backtracking
        }
    }

    public static void printCombinations(int arr[], int r){
        allCombination(arr, r, 0, new ArrayList<>());
    }
    
    public static void main(String[] args) {
        // int arr[]={2,3,5,4,5,3,4};
        int arr[]={4,5,0,-2,-3,1};
        Scanner sc = new Scanner(System.in);
        System.out.println("<========Count the Subarray Sum divisible by K=========>");
        System.out.print("Enter key to devide subarray : ");
        int k = sc.nextInt();
        System.out.println("Count of Subarray is : "+subArrDivK(arr, k));
        System.out.println("<========Print all combination of element r=========>");
        int[] arrCom = {1, 2, 3, 4};  // Example array
        int r = 2;  // Size of each combination
        System.out.println("All combinations of " + r + " elements:");
        printCombinations(arrCom, r);  // Print all combinations
    }
}
