You given a rod of length N and a list of rod prices of length i, where 1 <= i <= n, find the optimal way to cut the rod into smaller rods to maximize profit.

Input Format :
First line will contain one integer N - length of rod.
Second line will contain an array of N integers of prices for every length of rod from one to N(profit for ith length of rod is profit[i - 1], 0 based indexing).

Output Format :
Print one integer - maximum profit.
Sample Input :
8
1 5 8 9 10 17 17 20

Sample Output :
22

Constraints :
1 <= N <= 10^3.
1 <= Profit[i] <= 10^5.


CODE:
import java.util.Scanner;
public class Main{
    public static int maximizeProfit(int N, int[] prices) {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxProfit = Math.max(maxProfit, prices[j] + dp[i - j - 1]);
            }
            dp[i] = maxProfit;
        }

        return dp[N];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
        }

        int maxProfit = maximizeProfit(N, prices);
        System.out.println(maxProfit);
    }
}
