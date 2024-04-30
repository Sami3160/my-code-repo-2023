
 class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class linkedlist1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode second = new ListNode(7);
        ListNode third = new ListNode(7);
        ListNode fourth = new ListNode(7);
        ListNode fifth = new ListNode(7);
        ListNode sixth = new ListNode(7);
        ListNode seventh = new ListNode(7);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        ListNode result = removeElements(head, 7);
        while (result != null) {
            System.out.print(result.val+"->");
            result = result.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head!=null && head.val == val) {
            head = head.next;
            
        }
        ListNode prev = head;
        ListNode current = head;
        int i = 0;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                // System.out.println(head.val + "" + i);
                i++;
            } else {
                prev = current;
            }
            // prev=current;
            current = current.next;
        }
        return head;



    }
}
