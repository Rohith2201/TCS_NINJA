A shopkeeper in a nearby town always starts a business ₹0. He never uses the previous days money for transaction. 
Any item in his shop costs ₹30.There are N number of customers waiting in the queue to buy items. A customer can buy any number of items but worth only ₹30.
The customer can transact with shopkeeper only with the denominations ₹30,₹60,₹120.The task here is to find the transaction between the shopkeeper and customer is possible.

The customer should be able to buy the item.
The amount each customer uses for his transaction is given as array elements .
The shopkeeper should be able to return the exact change.
Display ‘Transaction Successful’ on the successful transaction with all the customers in the queue.
Display ‘Transaction failed’ on the unsuccessful transaction with any one customer in the queue.


Example 1
Sample Input:
3 -> value of N
30
30
60->a[] ,Elements a[0] to a[N-1],where input of each element is seperated by a new line.

Sample Output:
Transaction successful.

Test Cases:

Case 1
Input (stdin)
3
30
30
60

Output (stdout):
Transaction successful

Case 2:
Input (stdin)
1
120

Output (stdout)
Transaction failed

CODE(JAVA):

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = { 0, 0, 0 };
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 30) {
                arr[0]++;
            } else if (a == 60) {
                if (arr[0] >= 1) {
                    arr[1]++;
                    arr[0]--;
                } else {
                    System.out.println("Transaction failed");
                    return;
                }
            } else if (a == 120) {
                if (arr[0] >= 3) {
                    arr[2]++;
                    arr[0] = arr[0] - 3;
                } else if (arr[0] >= 1 && arr[1] >= 1) {
                    arr[2]++;
                    arr[0]--;
                    arr[1]--;
                } else {
                    System.out.println("Transaction failed");
                    return;
                }
            }
        }
        sc.close();
        System.out.println("Transaction successful");
    }
}
