package B_Searching;

public class Binary_04 {
    static boolean isDivisionPossible(int a[], int maxAllStu, int maxChocAllowed) {
        int numberOfStu = 1;
        int choc = 0;// number of choc current student has
        for (int i = 0; i < a.length; i++) {
            if (a[i] > maxChocAllowed)
                return false;
            if (choc + a[i] <= maxChocAllowed) {
                choc += a[i];
            } else {
                numberOfStu++;// to introduced next student from total number of maxAllStu
                choc = a[i];// to give choc next student
            }
        }
        // if (numberOfStu > maxAllStu) {
        //     return false;
        // }
        // return true;
        return numberOfStu <= maxAllStu;

        //?time complexity of this function call is : O(n)
    }

    static int distributedChocolate(int a[], int maxAllStu) {
        if (a.length < maxAllStu)
            return -1;
        int ans = 0, si = 1;
        int ei = (int) 1e9;// max chocolate can't be allowed greater than 10^4 + 10^5
        
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (isDivisionPossible(a, maxAllStu, mid)) {
                ans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return ans;
        //? time complexity take O(logn) without using isDividionPossible fun
    }

    static boolean isPossible(int a[],int kid,int dist){
          int kidPlaced= 1;
          int lastkid=a[0];//last kid so that we can find largest distance 
          for (int i = 0; i < a.length; i++) {
            if(a[i]-lastkid>=dist){
                kidPlaced++;
                lastkid=a[i];
            }
          }
          return kidPlaced>=kid;
    }
    static int raceTrack(int a[],int kid){
        int si=0,ei=(int) 1e9;
        int ans =-1;
        while (si<=ei) {
            int mid=si+(ei-si)/2;
            if (kid>a.length) return -1;
            if (isPossible(a,kid,mid)) {
                ans=mid;
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // ! Ques :
        //You have 'n'(n<=10^5) boxes of chocalate. Each box conatins a[i](a[i]<=10000) chocolates. You need to distribute these boxes among 'm' students such that the max of chocolates allocated to a strudent is minimum.
        //a> One box will be allocated to exactly one student .
        //b> All the boxes should be allocated.
        //c> Each student has to be allocated at least one box.
        //d> Allotment should be in contiguouts order, for instace , a syudent cannot be allocated box 1 and box 3 , skipping box 2.
        //Calculate and return the minimum possible number 



        //*findOut minimal maxima
        int a[] = { 12,34,67,90 };
        int maxAllStu = 2;
        System.out.println(distributedChocolate(a, maxAllStu));
        //? Overall time complexity is : O(logn)* O(n) ===> O(nlogn);



        //! Ques :
        // A new racing track for kids is being built in New Youk with 'n' string spots. The spots are located along a straight  line at positions x1,x2,...xn(xi <= 10^9). for each 'i', xi+1>xi.
        //At a time onlu 'm' children  are allowed to enter the race. Since the race track is for kids, they may run into each other while running. To prevent this, we want to choose the starting spots such taht the minimum distance between any tow of them is as large as possible . What is the largest minimum distance?
        //The first line of input will contain the calue of n, the number of starting spots.
        //The second line of input will contain the n numbers denoting the the location of each spot.
        // The third line will contain the value of m, number of children.

        //*findOut maximal minima
        int raceSpots[]={1,2,4,8,9};
        int allowKid=3;
        System.out.println(raceTrack(raceSpots,allowKid));
         //? Overall time complexity is : O(logn)* O(n) ===> O(nlogn);

    }
}
