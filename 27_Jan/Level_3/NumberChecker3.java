public class NumberChecker3 {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] storeDigits(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int number, int[] digits) {
        int[] reversedDigits = reverseDigits(digits);
        return compareArrays(digits, reversedDigits);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true; // Duck number must have a non-zero digit
            }
        }
        return false; // If no non-zero digit, it's not a Duck number
    }

    public static void main(String[] args) {
        int number = 121;
        int[] digits = storeDigits(number);

        System.out.println("Count of digits: " + countDigits(number));

        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Is Palindrome: " + isPalindrome(number, digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));

        int[] reversedDigits = reverseDigits(digits);
        System.out.print("Reversed digits: ");
        for (int digit : reversedDigits) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }
}
