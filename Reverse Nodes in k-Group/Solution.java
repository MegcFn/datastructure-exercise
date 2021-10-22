//Leetcode No.25
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //若长度为k的整数倍,最终返回null
        if(head == null){
            return head;
        }
        //剩余长度不是k的整数倍,直接返回head
        int length = 0;
        ListNode ptr = head;
        while(ptr != null){
            length++;
            ptr = ptr.next;
        }
        if(length < k){
            return head;
        }
        //每组链表反转
        int count = 1;
        ListNode pre = head, suf = pre.next;
        ListNode tmp = null;
        while(count < k){
            tmp = suf.next;
            suf.next = pre;
            pre = suf;
            suf = tmp;
            count++;
        }
        //利用head拼接
        head.next = reverseKGroup(suf,k);
        head = pre;
        return head;
    }
}
