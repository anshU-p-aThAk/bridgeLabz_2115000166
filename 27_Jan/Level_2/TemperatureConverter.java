public class TemperatureConverter {
    public static double convertFarhenheitToCelsius(double farhenheit) {
        return (farhenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static void main(String[] args) {
        System.out.println("100F to Celsius: " + convertFarhenheitToCelsius(100));
        System.out.println("100 kg to pounds: " + convertKilogramsToPounds(100));
    }
}
