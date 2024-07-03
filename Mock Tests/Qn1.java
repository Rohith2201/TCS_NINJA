#Problemstatements
Given a doubly linked list, the task is to sort it using merge sort.

Input
First line contains a single integer N - the size of the list.
Next line contains N integers X - the nodes in the list.

Constraints
1 <= N <= 5000
1 <= X <= 10^9

Output
Print the list from both ends after sorting.

Sample Input
5
3 5 1 4 2

Sample Output
1 2 3 4 5
5 4 3 2 1

CODE:
class Node {
    int data;
    Node prev, next;
    
    public Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

class DoublyLinkedList {
    Node head;
    
    public DoublyLinkedList() {
        head = null;
    }
    
    // Function to merge two sorted linked lists
    Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        
        if (left.data <= right.data) {
            left.next = merge(left.next, right);
            left.next.prev = left;
            left.prev = null;
            return left;
        } else {
            right.next = merge(left, right.next);
            right.next.prev = right;
            right.prev = null;
            return right;
        }
    }
    
    // Function to perform merge sort on the linked list
    Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        
        middle.next = null;
        nextOfMiddle.prev = null;
        
        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);
        
        return merge(left, right);
    }
    
    // Function to get the middle node of the linked list
    Node getMiddle(Node node) {
        if (node == null) {
            return node;
        }
        
        Node slow = node, fast = node;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // Function to insert a node at the end of the linked list
    void insert(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    
    // Function to print the linked list from both ends
    void printList() {
        Node temp = head;
        
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int data = scanner.nextInt();
            list.insert(data);
        }
        scanner.close();
        list.head = list.mergeSort(list.head);
        list.printList();
    }
}
