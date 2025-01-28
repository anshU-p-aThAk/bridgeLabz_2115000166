public class OTPGenerator {

    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static boolean areOTPUnique(int[] otpNumbers) {
        for (int i = 0; i < otpNumbers.length; i++) {
            for (int j = i + 1; j < otpNumbers.length; j++) {
                if (otpNumbers[i] == otpNumbers[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otpNumbers = new int[10];

        for (int i = 0; i < 10; i++) {
            otpNumbers[i] = generateOTP();
            System.out.println("Generated OTP " + (i + 1) + ": " + otpNumbers[i]);
        }

        if (areOTPUnique(otpNumbers)) {
            System.out.println("All OTP numbers are unique.");
        } else {
            System.out.println("Some OTP numbers are not unique.");
        }
    }
}
