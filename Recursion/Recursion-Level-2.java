public class RecursionLevel2 {

    /* 
        Multiplication of Two Numbers Recursively
    */
    private static int Multiply(int m,int n){
        if(n==0 || m==0) return 0;
        int smallAns = Multiply(m,n-1);
        return m + smallAns;
    }

    /* 
        Counting Zeroes in a Number Recursively
    */
    private static int countZeros(int n){
        int lastDigit = n%10;
        if(n<=9){
            if(n==0) return 1;
            else return 0;
        }

        int ans = countZeros(n/10);
        if(lastDigit==0) ans+=1;
        return ans;
    }

    /* 
        Geometric Sum till 'N' terms
        Sum = 1/1 + 1/2^1 + 1/2^2 + ...... + 1/2^N
    */
    private static double GeometricSum(int n){
        if(n==0) return 1;
        double smallAns = GeometricSum(n-1);
        double ans = smallAns + 1/(Math.pow(2,n));
        return ans;
    }

    /* 
        Checking whether a String is a Palindrome Recursively
    */
    private static boolean checkPalindrome(String s){
        if(s.length()<=1) return true;
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return checkPalindrome(s.substring(1,s.length()-1));
        }
        else return false;
    }

    /* 
        Sum of Digits in a Number
    */
    private static int sumOfDigits(int n){
        if(n>=0 && n<=9) return n;
        int smallAns = sumOfDigits(n/10);
        return n%10 + smallAns;
    }

    /* 
      Replacing 'pi' by 3.14 in a String 
    */
    private static String replacePi(String input){
        if(input.length()<=1) return input;
        String smallAns = replacePi(input.substring(1));
        if(input.charAt(0)=='p' && smallAns.charAt(0)=='i'){
            return "3.14" + smallAns.substring(1);
        }
        else return input.charAt(0) + smallAns;
    }

    /* 
      Removing a character in a String 
    */
    private static String removeX(String input,char x){
        if(input.length()==0) return "";
        String smallAns = removeX(input.substring(1),x);
        if(input.charAt(0)==x) return smallAns;
        else return input.charAt(0) + smallAns;
    }

    /* 
      Converting String to Integer Recursively 
    */
    private static int convertStringToInt(String input){
        if(input.length()==1) return input.charAt(0) - '0';
        int smallOutput = convertStringToInt(input.substring(0,input.length()-1));
        int lastDigit = input.charAt(input.length()-1) - '0';
        return (smallOutput*10 + lastDigit);
    }

    /* 
      Replacing consecutively repeating characters with a '*' 
    */
    private static String pairStar(String s){
        if(s.length()<=1) return s;
        String AlteredSmallString = pairStar(s.substring(1));
        if(s.charAt(0)==AlteredSmallString.charAt(0)){
            return s.charAt(0) + "*" + AlteredSmallString;
        }
        else return s.charAt(0) + AlteredSmallString;
    }

    public static void main(String[] args) {
        System.out.println("Multiply 45 X 20 = " + Multiply(45,20));
        System.out.println("Number of Zeros are : " + countZeros(1000));
        System.out.println("Geometric Sum for N = 4 is : " + GeometricSum(4));
        String inputString = "Poodlees";
        System.out.println("Is String " + inputString + " a palindrome ? -> " + checkPalindrome(inputString));
        int num = 100;
        System.out.println("Sum of Digits of " + num + " is : " + sumOfDigits(num));
        System.out.println(replacePi("pip"));
        System.out.println(removeX("xaxbxxcxdx",'x'));
        System.out.println("Integer converted 1234 Plus 1 is : " + (1+convertStringToInt("1234")));
        String x = "aabbccddefgghhi";
        System.out.println("Pair Star Applied on " + x + " gives : " + pairStar(x));
        //TOWER OF HANOI PENDING ....
    }

}
