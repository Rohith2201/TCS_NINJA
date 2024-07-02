A man wants to do rock climbing and reach the top of a steep peak. There is 'N' number of Convenient rocks on the mountain which the mountaineer can step onto to reach the 
peak a little easily. The initial position/rock on which the rock climber is standing currently is denoted as 'I'. 
From each rock, the person can skip utmost 'X' rocks. The task here is to find the number of ways a mountaineer can climb to reach the peak.

Example 1:
Input:
6-> Value of N
3-> Value of I
2-> Value of X

Output:
3-> Number of ways he can reach the peak

Case 1
Input (stdin)
6
3
2

Output (stdout)
3

Case 2
Input (stdin)
9
9
2

CODE (JAVA):

Output (stdout)
1

CODE(Java):

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        int I = scanner.nextInt(); 
        int X = scanner.nextInt(); 
        int ways = climbToPeak(N, I, X);
        System.out.println(ways);
    }
    
    public static int climbToPeak(int N, int I, int X) {
        if (I == N) {
            return 1;
        }        
        int ways = 0;  
        for (int rock = I + 1; rock <= Math.min(N, I + X); rock++) {
            ways += climbToPeak(N, rock, X);
        }
        
        return ways;
    }
}
