class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. 快慢指针找中点，slow 停在前半的最后一个（或中间）
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 反转后半部分
        ListNode second = slow.next;
        slow.next = null;            // 切断，前半以 slow 结尾
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        // 现在 prev 是反转后后半的头

        // 3. 交替合并两半
        ListNode first = head, secondHead = prev;
        while (secondHead != null) {
            ListNode t1 = first.next;
            ListNode t2 = secondHead.next;
            first.next = secondHead;
            secondHead.next = t1;
            first = t1;
            secondHead = t2;
        }
    }
}