// Program 4: Profit and loss calculation
public class Program4ProfitLoss {
    public static void main(String[] args) {
        double costPrice = 129, sellingPrice = 191;
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;
        System.out.println(profit);
        System.out.println(profitPercentage);
    }
}
