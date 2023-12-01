package Easy;

public class No121BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit;
        int minIndex = 0;

        for (int i = 1; i < prices.length; i++) {
            currentProfit = prices[i] - prices[minIndex];
            if (currentProfit < 0) {
                minIndex = i;
            }else if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
        assert maxProfit == 5;
    }
}
