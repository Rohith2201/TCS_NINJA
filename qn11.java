Given a string in which the same character occurs in many consecutive character elements. 
Your task is to find the characters that have even frequency and are consecutive. Display the sum of every frequency count( For even frequency only)

Example 1:
Sample Input:
aaabbaccccdd    

Sample Output:
8

Example 2
Sample Input:
vdkkmmmnn  

Sample Output:
4


Case 1
Input (stdin)
aaabbaccccdd

Output (stdout)
8

Case 2
Input (stdin)
vdkkmmmnn

Output (stdout)
4

CODE(JAVA):
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int sum = findSumOfEvenFrequencyConsecutive(input);
        System.out.println(sum);
    }

    public static int findSumOfEvenFrequencyConsecutive(String input) {
        int sum = 0;
        int count = 1;
        
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                if (count % 2 == 0) {
                    sum += count;
                }
                count = 1;
            }
        }
        
        if (count % 2 == 0) {
            sum += count;
        }
        
        return sum;
    }
}

