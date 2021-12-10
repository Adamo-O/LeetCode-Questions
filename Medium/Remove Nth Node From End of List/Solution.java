class Solution {
    // Have a 'fast' pointer 'n' nodes ahead of 'slow' pointer
    // When 'fast' reaches the end of the LL, 'slow' is at the node that should be removed
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create new linked list
        ListNode newHead = new ListNode(0);
        
        // Start slow and fast pointers at new linked list head
        ListNode slow = newHead;
        ListNode fast = newHead;
        
        // Point new linked list head to input head
        newHead.next = head;
        
        // Move fast 'n' away from slow
        for (int i = 0; i <= n; i++)
            fast = fast.next;
        
        // Move slow and fast until fast reaches the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Exclude slow's next node from new linked list
        slow.next = slow.next.next;
        return newHead.next;
    }
}
