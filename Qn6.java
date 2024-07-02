You have given n piles in which each pile contains some numbers of stones/coins and you have also given the information about who can made the 
first move from player 1 and 2. In each turn, a player can choose only one pile and remove any number of stones (at least one) from that pile. 
The player who cannot move is considered to lose the game (i.e., one who take the last stone is the winner). ”

Input Format :
First line will contain two integers n and t - number of piles and 
who will made the first move first or 2nd player (if t is 1 then 1st player will start game otherwise 2nd player will start the game) 
(1 <= n <= 10^5, 1 <= t <= 2).
Second line will contain n space separated integers (1 <= a[i] <= 100000).

Output Format :
Print 1 if player 1 will win otherwise print 2.

Sample Input 1:
3 1
3 4 5

Sample Output 1:
1

Sample Input 2:
3 2
3 4 5

Sample Output 2:
2


Case 1
Input (stdin)
3 2
3 4 5

Output (stdout)
2

Case 2
Input (stdin)
3 1
3 4 5

Output (stdout)
1

CODE(JAVA):
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = scanner.nextInt();
        }
        scanner.close();

        int xorSum = 0;
        for (int pile : piles) {
            xorSum ^= pile;
        }

        if (xorSum == 0 || (t == 1 && n % 2 == 0) || (t == 2 && n % 2 == 1)) {
            System.out.println("2");
        } else {
            System.out.println("1");
        }
    }
}
