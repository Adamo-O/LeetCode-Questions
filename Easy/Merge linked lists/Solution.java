class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // Create new linked list
        ListNode newHead = new ListNode(0);
        
        // Save new linked list head for output
        ListNode newHeadStart = newHead;
                        
        // Edge case for null lists
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        // Create a pointer per linked list
        ListNode l1 = list1;
        ListNode l2 = list2;
        
        // Loop until one list is empty
        while (l1 != null && l2 != null) {
            
            // Add lowest of both lists to linked list, then increment that pointer
            if (l1.val < l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            }
            else {
                newHead.next = l2;
                l2 = l2.next;
            }
            
            // Prepare for next linked list node
            newHead = newHead.next;
        }
        
        // Add remaining linked list to end of new list
        if (l1 == null) 
            newHead.next = l2;
        else if (l2 == null)
            newHead.next = l1;
        
        // Return new head (skip first value -> empty)
        return newHeadStart.next;
    }
}