A boy enters a stationery shop. There are N number of pencils and M number of erasers available in the shop. But the boy's mother insists that he can buy only P number of pencils and E number of erasers. 
The task here is to find the number of ways the boy can choose 'P' pencils and 'E' erasers from the available N and
M pencils & erasers respectively.

Note:
The boy can choose in any order.

N-number of pencils available in the shop
M-number of erasers available in the shop
P-number of pencils he can choose to buy from N
E-number of erasers he can choose to buy from M

Example 1:

Input:
3 ->Value of N M
1 ->Value of M W
2 ->Value of P X
1 ->Value of E Y

Output:
3 ->Number of ways we can choose
  
Explanation 1

From the input given above
1st way of selecting:
Select 1st and 2nd pencils, 1 eraser
2nd way of selecting:
Select 2nd and 3rd pencils, 1 eraser
1st way of selecting:
Select 1st and 3rd pencils, 1 eraser
The Possible number of ways selecting 2 pencils and 1 eraser is 3
Hence the output is 3.



Example 2

Input:
5->Value of N
3->Value of M
5->Value of P
3->Value of E

Output:
1->.Number of ways we can choose

Explanation 2

From the input given above:
1st way of selecting:
Select 1,2,3,4,5 Pencils and 1,2,3 erasers
There is only one possible way of selecting 5 pencils and 3
Hence, the output is 1.

Constarins:

0<N<<=50 , 0<M<=50 , 0<=P<=50 ,0<=E<=50

The Input format for testing
The candidate has to write the code to accept 4 input(s).
First Input - Accept value for N(Positive integer number)
Second Input-Accept value for M(Positive integer number)
Third input Accept value for P(Positive integer number)
Fourth input Accept value for E(Positive integer number) 

The Output format for testing
The output should be a positive integer number or print the message (if any) given in the problem statement
(Check the output in Example 1, Example 2) 

CASE1:
Input (stdin)
3
1
2
1

Output (stdout)
3

CASE2:
Input (stdin)
4
3
2
2

Output (stdout)
18

CODE:
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.close();
        System.out.println(comb(m,n,p,q));
    }
    private static int comb(int m, int n, int p, int q){

        int numerator = factorial(m) / (factorial(p) * factorial(m - p));
        int denominator = factorial(n) / (factorial(q) * factorial(n - q));
        return numerator * denominator;
    }
    private static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
}
