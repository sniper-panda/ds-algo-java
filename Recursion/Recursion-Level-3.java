import java.util.Arrays;

public class RecursionLevel3 {

    /*
    Replacing Character c1 with Character c2 in a String
    */
    private static String replaceCharRecursively(String input,char c1,char c2){
        if(input.length()==0) return input;
        String smallString = replaceCharRecursively(input.substring(1),c1,c2);
        if(input.charAt(0) == c1){
            return c2 + smallString;
        }
        else return input.charAt(0) + smallString;
    }

    /*
    Replacing Duplicate Characters in a String
    */
    private static String replaceDuplicatesRecursively(String input){
        if(input.length()<=1) return input;
        String smallString = replaceDuplicatesRecursively(input.substring(1));
        if(input.charAt(0)==smallString.charAt(0)){
            return smallString;
        }
        else return input.charAt(0) + smallString;
    }

    /*
    Merge Sort Algorithm
    */
    private static void MergeSort(int[] arr){
        if(arr.length<=1) return;
        int mid = arr.length/2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length-mid];
        for(int i=0;i<mid;i++){ leftHalf[i] = arr[i]; }
        int k = 0;
        for(int i=mid;i<arr.length;i++){ rightHalf[k++] = arr[i]; }
        MergeSort(leftHalf);
        MergeSort(rightHalf);
        Merge(leftHalf,rightHalf,arr);
    }

    /*
    Merge Two Sorted Arrays (Part of Merge Sort Algorithm)
    */
    private static void Merge(int[] a1,int[] a2,int[] arr){
        int m = a1.length; int n = a2.length;
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(a1[i] < a2[j]) arr[k++]=a1[i++];
            else if(a1[i] > a2[j]) arr[k++]=a2[j++];
        }
        while(i<m){
            arr[k++]=a1[i++];
        }
        while(j<n){
            arr[k++]=a2[j++];
        }
    }

    /*
    Merge Sort Algorithm Alternate
    */
    private static int[] MergeSortAlter(int[] arr){
        if(arr.length<=1) { return arr;}
        int mid = arr.length/2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length-mid];
        for(int i=0;i<mid;i++){ leftHalf[i] = arr[i]; }
        int k = 0;
        for(int i=mid;i<arr.length;i++){ rightHalf[k++] = arr[i]; }
        int[] leftArray = MergeSortAlter(leftHalf);
        int[] rightArray = MergeSortAlter(rightHalf);
        return MergeAlter(leftArray,rightArray);
    }

    /*
    Merge Two Sorted Arrays Alternate (Part of Merge Sort Algorithm)
    */
    private static int[] MergeAlter(int[] a1,int[] a2){
        int m = a1.length; int n = a2.length;
        int[] arr = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(a1[i] < a2[j]) arr[k++]=a1[i++];
            else if(a1[i] > a2[j]) arr[k++]=a2[j++];
        }
        while(i<m){
            arr[k++]=a1[i++];
        }
        while(j<n){
            arr[k++]=a2[j++];
        }
        return arr;
    }

    /*
    Return all Subsequences of a String
    */
    private static String[] returnSubsequencesOfString(String input){
        if(input.length()==0){
            String[] empty = new String[]{""};
            return empty;
        }
        String[] smallStringArray = returnSubsequencesOfString(input.substring(1));
        String[] output = new String[2*smallStringArray.length];
        int index = 0;
        for(index=0;index<smallStringArray.length;index++){
            output[index] = smallStringArray[index];
        }
        for(int i=0;i<smallStringArray.length;i++){
            output[index++]= input.charAt(0) + smallStringArray[i];
        }
        return output;
    }

    /*
    Print all Subsequences of a String
    */
    private static void printSubsequencesOfString(String input){
        printSubsequencesOfString(input,"");
    }

    private static void printSubsequencesOfString(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        printSubsequencesOfString(input.substring(1),output);
        printSubsequencesOfString(input.substring(1),input.charAt(0) + output);
    }

    /*
    Return all KeyPad Options of a Number
    */
    private static String[] keypadOptions(int x){
        switch(x){
            case 2:
                return new String[]{"a","b","c"};
            case 3:
                return new String[]{"d","e","f"};
            case 4:
                return new String[]{"g","h","i"};
            case 5:
                return new String[]{"j","k","l"};
            case 6:
                return new String[]{"m","n","o"};
            case 7:
                return new String[]{"p","q","r","s"};
            case 8:
                return new String[]{"t","u","v"};
            case 9:
                return new String[]{"w","x","y","z"};
        }
        return new String[]{""};
    }


    private static String[] returnKeypadCode(int input){
        if(input==0 || input==1){
            String[] empty = new String[]{""};
            return empty;
        }
        String[] smallOutput = returnKeypadCode(input/10);
        String[] keypadOptions = keypadOptions(input%10);
        String[] output = new String[smallOutput.length * keypadOptions.length];
        int k=0;
        for(int i=0;i<keypadOptions.length;i++){
            for(int j=0;j<smallOutput.length;j++){
                output[k++] = smallOutput[j] + keypadOptions[i];
            }
        }
        return output;
    }

    /*
    Print all KeyPad Options of a Number
    */
    private static void printKeypadCode(int input){
        printKeypadCode(input,"");
    }

    private static void printKeypadCode(int input,String output){
        if(input==0) {
            System.out.println(output);
            return;
        }
        String[] options = keypadOptions(input%10);
        for(int i=0;i<options.length;i++){
            printKeypadCode(input/10,options[i] + output);
        }
    }

    /*
    Binary Search Algorithm
    */
    private static int BinarySearch(int[] input,int element){
        return BinarySearchHelper(input,0,input.length-1,element);
    }

    private static int BinarySearchHelper(int[] input,int start,int end,int element){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(input[mid]==element) return mid;
        else if(input[mid] > element) return BinarySearchHelper(input,start,mid-1,element);
        else return BinarySearchHelper(input,mid+1,end,element);
    }

    /*
    Return all Subsets of an Array
    */
    private static int[][] returnSubsets(int input[]){
        return returnSubsetsHelper(input,0);
    }

    private static int[][] returnSubsetsHelper(int input[],int startIndex){
        if(startIndex==input.length){
            int[][] output = new int[1][0];
            return output;
        }
        int[][] smallOutput = returnSubsetsHelper(input,startIndex+1);
        int[][] output = new int[2*smallOutput.length][];

        int k = 0;
        for(int i=0;i<smallOutput.length;i++){
            output[k] = new int[smallOutput[i].length]; //Create element in 2-D array acc to SmallOutput[i] Size
            for(int j = 0; j < smallOutput[i].length;j++){
                output[k][j] = smallOutput[i][j];
            }
            k++;
        }
        for(int i=0;i<smallOutput.length;i++){
            output[k] = new int[smallOutput[i].length+1];
            output[k][0] = input[startIndex];
            for(int j=1;j<=smallOutput[i].length;j++){
                output[k][j] = smallOutput[i][j-1];
            }
            k++;
        }
        return output;
    }

    /*
    Print all Subsets of an Array
    */
    private static void printSubsets(int[] input){
        int[] output = new int[0];
        printSubsetsHelper(input,0,output);
    }

    private static void printSubsetsHelper(int[] input,int startIndex,int[] output){
        if(startIndex==input.length){
            for(int i=0;i<output.length;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();return;
        }
        int[] elementAddedOutput = new int[output.length+1];
        int i=0;
        for(;i<output.length;i++){
            elementAddedOutput[i] = output[i];
        }
        elementAddedOutput[i] = input[startIndex];
        printSubsetsHelper(input,startIndex+1,output);
        printSubsetsHelper(input,startIndex+1,elementAddedOutput);
    }

    /*
    Return all Subsets of an Array which Sum to a number 'K'
    */
    private static int[][] returnSubsetsToSumKHelper(int[] input,int startIndex,int k){
        if(startIndex==input.length){
            if(k==0){
                return new int[1][0];
            }
            else return new int[0][0];
        }
        int[][] ExcludedOutput = returnSubsetsToSumKHelper(input,startIndex+1,k);
        int[][] IncludedOutput = returnSubsetsToSumKHelper(input,startIndex+1,k-input[startIndex]);
        int[][] output = new int[ExcludedOutput.length + IncludedOutput.length][];
        int index = 0;
        for(int i=0;i<ExcludedOutput.length;i++){
            output[index++] = ExcludedOutput[i];
        }
        for(int i=0;i<IncludedOutput.length;i++){
            output[index] = new int[IncludedOutput[i].length+1];
            output[index][0] = input[startIndex];
            for(int j=0;j<IncludedOutput[i].length;j++){
                output[index][j+1] = IncludedOutput[i][j];
            }
            index++;
        }
        return output;
    }

    private static int[][] returnSubsetsToSumK(int[] input,int k){
        return returnSubsetsToSumKHelper(input,0,k);
    }

    /*
    Print all Subsets of an Array which Sum to a number 'K'
    */
    private static void printSubsetsToSumK(int[] input,int k){
        printSubsetsToSumKHelper(input,0,k,new int[0]);
    }

    private static void printSubsetsToSumKHelper(int[] input,int startIndex,int k,int[] output){
        if(startIndex==input.length){
            if(k==0) System.out.println(Arrays.toString(output));
            return;
        }
        int[] AddedOutput = new int[output.length+1];
        int index = 0;
        for(int i=0;i<output.length;i++){
            AddedOutput[index++]=output[i];
        }
        AddedOutput[index] = input[startIndex];
        printSubsetsToSumKHelper(input,startIndex+1,k-input[startIndex],AddedOutput);
        printSubsetsToSumKHelper(input,startIndex+1,k,output);

    }

    private static String[] returnAlphaCodes(String input){
        if(input.length()==0){
            String[] emptyStringArray = {""};
            return emptyStringArray;
        }
        int firstDigit = input.charAt(0) - '0';
        String[] FirstStringCode = returnAlphaCodes(input.substring(1));
        String[] SecondStringCode = new String[0];

        int firstTwoDigits = 0;
        if(input.length()>=2){
            firstTwoDigits = firstDigit*10 + (input.charAt(1) - '0');
            if(firstTwoDigits > 10 && firstTwoDigits <= 26){
                SecondStringCode = returnAlphaCodes(input.substring(2));
            }
        }

        String[] output = new String[FirstStringCode.length + SecondStringCode.length];
        int k = 0;
        for(int i=0;i<FirstStringCode.length;i++){
            char FirstDigitChar = (char)(96+firstDigit);
            output[k++] = FirstDigitChar + FirstStringCode[i];
        }
        for(int i=0;i<SecondStringCode.length;i++){
            char FirstTwoDigitCode = (char)(96 + firstTwoDigits);
            output[k++] = FirstTwoDigitCode + SecondStringCode[i];
        }
        return output;
    }

    private static void printAlphaCodesHelper(String input,String output){
        if(input.length()==0){
            System.out.println(output);return;
        }
        int firstDigit = input.charAt(0) - '0';
        printAlphaCodesHelper(input.substring(1),output + (char)(firstDigit+96));
        if(input.length()>1){
            int firstTwoDigits = firstDigit*10 + (input.charAt(1) - '0');
            if(firstTwoDigits > 10 && firstTwoDigits <= 26){
                printAlphaCodesHelper(input.substring(2),output + (char)(96+firstTwoDigits));
            }
        }
    }

    private static void printAlphaCodes(String input){
        printAlphaCodesHelper(input,"");
    }

    /*
    Return all Permutations of a String
    */
    private static String[] returnPermutationOfString(String input){
        if(input.length()==0){
            String[] emptyStringArray = {""};
            return emptyStringArray;
        }
        String[] smallerOutput = returnPermutationOfString(input.substring(1));
        String[] output = new String[input.length()*smallerOutput.length]; //Basically Input.Length Factorial
        int k = 0;
        for(int i=0;i<smallerOutput.length;i++){
            String currString = smallerOutput[i];
            for(int j=0;j<=currString.length();j++){
                output[k] = currString.substring(0,j) + input.charAt(0) + currString.substring(j);
                //System.out.println("Output[k] = " + output[k]);
                System.out.println("Output Array : " + Arrays.toString(output));
                k++;
            }
        }
        return output;
    }

    /*
    Print all Permutations of a String
    */
    private static void printPermutationOfString(String input){
        printPermutationOfStringHelper(input,"");
    }

    private static void printPermutationOfStringHelper(String input,String output){
        if(input.length()==0){
            System.out.println(output);return;
        }
        for(int i=0;i<input.length();i++){
            printPermutationOfStringHelper(input.substring(0,i) + input.substring(i+1),output+input.charAt(i));
        }
    }


    public static void main(String[] args) {
        char c1 = 'a'; char c2= 'x'; String mainString = "aabbaacdd";
        System.out.println("Replacing '" + c1 + "' with '" + c2 + "' in " + mainString + ", we have " + replaceCharRecursively(mainString,c1,c2));
        System.out.println("Replacing duplicates in " + mainString + " we have " + replaceDuplicatesRecursively(mainString));
        int[] sortedArray1 = new int[]{1,4,7,9};
        int[] sortedArray2 = new int[]{2,3,6,10};
        int[] arr = new int[]{4,6,3,1,2,10,9,7};
        MergeSort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{4,6,3,1,2,10,9,7};
        System.out.println(Arrays.toString(MergeSortAlter(arr)));
        System.out.println(Arrays.toString(returnSubsequencesOfString("abc")));
        int x = 245;
        System.out.println("Keypad Code for " + x + " is : " + Arrays.toString(returnKeypadCode(x)));
        printSubsequencesOfString("abc");
        printKeypadCode(234);
        x = 11;
        System.out.println("Binary Search of Element -> " + x + " in Array " + Arrays.toString(arr) + " gives : " + BinarySearch(arr,x));
        arr = new int[]{15,20,12};
        System.out.println("Subsets of the array : " + Arrays.toString(arr) + " are -> ");
        int[][] returnedSubsets = returnSubsets(arr);
        for(int i=0;i<returnedSubsets.length;i++){
            System.out.println(Arrays.toString(returnedSubsets[i]));
        }
        System.out.println("Printing Subsets of the array : " + Arrays.toString(arr));
        printSubsets(arr);
        arr = new int[]{1,2,3,4,5,6,7};
        int k = 6;
        System.out.println("Subsets of the Array : " + Arrays.toString(arr) + " to sum " + k + " are -> ");
        int[][] returnedSubsetsSumK = returnSubsetsToSumK(arr,k);
        for(int i=0;i<returnedSubsetsSumK.length;i++){
            System.out.println(Arrays.toString(returnedSubsetsSumK[i]));
        }
        System.out.println("Printing Subsets of the array : " + Arrays.toString(arr) + " to sum " + k + " are -> ");
        printSubsetsToSumK(arr,k);
        x = 1123;
        System.out.println("Alpha Codes of the Number " + x + " can be any of : " + Arrays.toString(returnAlphaCodes(Integer.toString(x))));
        System.out.println("Alpha Codes printing for " + x + " -> ");
        printAlphaCodes(Integer.toString(x));
        String abcString = "abc";
        System.out.println(Arrays.toString(returnPermutationOfString(abcString)));
        System.out.println("Printing Permutations for String -> " + abcString);
        printPermutationOfString(abcString);
    }

}
