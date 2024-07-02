An event management company has come up with a unique idea of printing their event tickets. Based on the ticket number combination (str1), the visitor is directed towards a particular class of audience. 
The task is to create a program/application to fetch the ticket number based on the following conditions:
Any occurrences of digits EF and G should be deleted. The characters EF should be in the same format.

Input format
The candidate has to write the code to accept 1 input(s). First Input -Accept value for str1 which is a string consisting of numbers and uppercase alphabets without any spaces

Output format
The output should be a string without any spaces (Check the output in Example 1 and Example 2) Additional messages in output will cause the failure of test cases.

Constraints
Str ((A,Z),(0-9))
No spaces and special characters allowed.
Only uppercase alphabets in the input string

Example 1:
Input:
 4523EF58G  -> A value of STR1

 Output :
 452358 -> A after removal of characters EF and G

Example 2:
 Input:
 E12F35G58  -> A value of STR1
  
 Output :
 E12F3558  -> A after removal of characters “G”
Explanation:
In the above example, characters E and F are not together So, they won't be deleted. The output will be with only character G removed.


Case 1
Input (stdin)
4523EF58G

Output (stdout)
452358

Case 2
Input (stdin)
9EF41G72

Output (stdout)
94172

CODE:

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String ans = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'F' && st.peek() == 'E') {
                st.pop();
            } else if (s.charAt(i) == 'G') {
                continue;
            } else {
                st.push(s.charAt(i));
            }
        }
        while (!st.empty()) {
            ans = st.pop() + ans;
        }
        System.out.println(ans);
    }
}
