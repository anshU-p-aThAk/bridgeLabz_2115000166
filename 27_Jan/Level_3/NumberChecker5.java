public class NumberChecker5 {

    public static int[] findFactors(int number) {
        int[] tempFactors = new int[number];
        int count = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                tempFactors[count] = i;
                count++;
            }
        }

        int[] factors = new int[count];
        System.arraycopy(tempFactors, 0, factors, 0, count);
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        int maxFactor = factors[0];
        for (int i = 1; i < factors.length; i++) {
            if (factors[i] > maxFactor) {
                maxFactor = factors[i];
            }
        }
        return maxFactor;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double productOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors);
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors);
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors);
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == number;
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 28; // Example number

        int[] factors = findFactors(number);
        System.out.println("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        System.out.println("\nGreatest Factor: " + greatestFactor(factors));
        System.out.println("Sum of Factors: " + sumOfFactors(factors));
        System.out.println("Product of Factors: " + productOfFactors(factors));
        System.out.println("Product of Cube of Factors: " + productOfCubeOfFactors(factors));

        System.out.println("Is Perfect Number: " + isPerfectNumber(number));
        System.out.println("Is Abundant Number: " + isAbundantNumber(number));
        System.out.println("Is Deficient Number: " + isDeficientNumber(number));
        System.out.println("Is Strong Number: " + isStrongNumber(number));
    }
}
