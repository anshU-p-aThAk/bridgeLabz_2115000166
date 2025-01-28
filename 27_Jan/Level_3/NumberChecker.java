public class NumberChecker {

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

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number, int[] digits) {
        int sum = 0;
        int numDigits = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, numDigits);
        }
        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[] { largest, secondLargest };
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[] { smallest, secondSmallest };
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = storeDigits(number);

        System.out.println("Count of digits: " + countDigits(number));
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(number, digits));

        int[] largestAndSecondLargest = findLargestAndSecondLargest(digits);
        System.out.println("Largest: " + largestAndSecondLargest[0]);
        System.out.println("Second Largest: " + largestAndSecondLargest[1]);

        int[] smallestAndSecondSmallest = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest: " + smallestAndSecondSmallest[0]);
        System.out.println("Second Smallest: " + smallestAndSecondSmallest[1]);
    }
}
