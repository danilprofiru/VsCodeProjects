package lab1;

public class Palindrome {
    public static void main(String args[]) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
        }
    }

    public static String reverseString(String s) {
        String ReversedString = "";
        for (int i = s.length() - 1; 0 <= i; i--) {
            ReversedString += s.charAt(i);
        }
        return ReversedString;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed);
    }
}
