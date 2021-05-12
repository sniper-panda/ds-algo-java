import java.util.Arrays;

public class RecursionLevel1 {

    /* General Exponential Function
        Form of x^n
        Input : 2,3
        Output : 2^3 = 8
     */
    private static int PowerRecursive(int x,int n){
        if(n==0) return 1;
        int smallAns = PowerRecursive(x,n-1);
        int ans = x * smallAns;
        return ans;
    }

    /* Printing 'N' Natural Numbers
        Input : 5
        Output : 1 2 3 4 5
     */
    private static void print12N_Recursive(int n){
        if (n==0) return;
        print12N_Recursive(n-1);
        System.out.println(n);
    }

    /* Printing 'N' Natural Numbers in reverse order
        Input : 5
        Output : 5 4 3 2 1
     */
    private static void printN21_Recursive(int n){
        if (n==0) return;
        System.out.println(n);
        printN21_Recursive(n-1);
    }

    /* Number of Digits in a Number
        Input : 5690
        Output : 4
     */
    private static int numDigitsRecursive(int n){
        if(n>0 && n<=9) return 1;
        return 1 + numDigitsRecursive(n/10);
    }

    /* Sum of Elements in an Array
        Input : [1,8,9,5,0]
        Output : 23
     */
    private static int sumOfArray(int[] arr){
        return sumOfArrayHelper(arr,0,arr.length-1);
    }

    private static int sumOfArrayHelper(int[] arr,int si,int ei){
        if(si>=ei) return 0;
        return arr[si] + sumOfArrayHelper(arr,si+1,ei);
    }

    /* Checking for a number within an array
        Input : [1,8,9,5,0], 5 (To be Checked)
        Output : Yes
     */
    private static boolean checkNumber(int[] arr,int x){
        return checkNumberHelper(arr,0,x);
    }

    private static boolean checkNumberHelper(int[] arr,int si,int x){
        if(si==arr.length) return false;
        boolean isElementInArrayExtended = checkNumberHelper(arr,si+1,x);
        if(isElementInArrayExtended) return true;
        else{
            if(arr[si]==x) return true;
            else return false;
        }
    }

    /* First Index of a Number in an Array
        Input : [1,8,9,5,5], 5
        Output : 3
     */
    private static int FirstIndexOfNumber(int[] arr,int x){
        return FirstIndexOfNumber(arr,0,x);
    }

    private static int FirstIndexOfNumber(int[] arr,int si,int x){
        if(si==arr.length) return -1;
        if(arr[si]==x) return si;
        return FirstIndexOfNumber(arr,si+1,x);
    }

    /* Last Index of a Number in an Array
        Input : [1,8,9,5,5], 5
        Output : 4
     */
    private static int LastIndexOfNumber(int[] arr,int x){
        return LastIndexOfNumber(arr,0,x);
    }

    private static int LastIndexOfNumber(int[] arr,int si,int x){
        if(si==arr.length) return -1;
        int LastIndex = LastIndexOfNumber(arr,si+1,x);
        if(LastIndex==-1){
            if(arr[si]==x) return si;
            else return -1;
        }
        else return LastIndex;
    }

    /* All Indices of a Number in an Array
        Input : [1,8,9,5,5], 5
        Output : [3,4]
     */
    private static int[] AllIndicesOfANumber(int[] arr,int x,int si){
        if(si==arr.length){
            int[] output = new int[0];
            return output;
        }
        int[] smallOutput = AllIndicesOfANumber(arr,x,si+1);
        if(arr[si]==x){
            int[] output = new int[smallOutput.length+1];
            output[0] = si;
            for(int i=0;i<smallOutput.length;i++){
                output[i+1] = smallOutput[i];
            }
            return output;
        }
        else return smallOutput;
    }

    private static int[] AllIndicesOfANumber(int[] arr,int x){
        return AllIndicesOfANumber(arr,x,0);
    }

    //Main Method
    public static void main(String[] args) {
        int x = 2, n =5;
        System.out.println("x : " + x + " raised to the power of n : " + n + " =  " + PowerRecursive(x,n));
        System.out.println("*********** " + "Printing 1 to " + n + " ***********");
        print12N_Recursive(n);
        System.out.println("*********** " + "Printing " + n + " To 1 " + " ***********");
        printN21_Recursive(n);
        System.out.println(numDigitsRecursive(10));
        int[] arr = new int[]{1,2,3,4,1,6,7,8,9,1};
        System.out.println("Sum of Array : " + Arrays.toString(arr) + " = " + sumOfArray(arr));
        n=11;
        System.out.println("Is " + n + " in the Array : " + Arrays.toString(arr) + " ? -> " + checkNumber(arr,n));
        System.out.println("First Index of " + n + " in the Array : " + Arrays.toString(arr) + " -> " + FirstIndexOfNumber(arr,n));
        System.out.println("Last Index of " + '1' + " in the Array : " + Arrays.toString(arr) + " -> " + LastIndexOfNumber(arr,1));
        System.out.println("All Indices of 1 in the Array : " + Arrays.toString(arr) + " are : " + Arrays.toString(AllIndicesOfANumber(arr,1)));
    }


}
