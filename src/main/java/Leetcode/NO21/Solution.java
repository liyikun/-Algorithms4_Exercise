package Leetcode.NO21;

class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode index = result;
        ListNode I1 = l1;
        ListNode I2 = l2;

        while (I1 != null && I2 != null) {
            if(I1.val < I2.val) {
                index.next = I1;
                index = index.next;
                I1 = I1.next;
                index.next = null;
            } else {
                index.next = I2;
                index = index.next;
                I2 = I2.next;
                index.next = null;
            }
        }

        if(I1 != null) {
            index.next = I1;
        }
        if(I2 != null) {
            index.next = I2;
        }

        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
