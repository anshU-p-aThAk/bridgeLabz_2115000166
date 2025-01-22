public class Program6DiscountFee {
    public static void main(String[] args) {
        double fee = 125000, discountPercent = 10;
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.println(discount);
        System.out.println(finalFee);
    }
}
