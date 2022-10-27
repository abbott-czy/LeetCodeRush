package fanzhuanlianbiao;

public class ReverseList206v1 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
/*
 方法1：双指针反转
 */
    public ListNode reverseListV1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 方法二递归
     * @param head
     * @return
     */
    public ListNode reverseListV2(ListNode head) {
      return   reverse(null,head);

    }

    public ListNode reverse(ListNode prev, ListNode cur){
        if (cur == null)
            return prev;

        ListNode temp = null;
        temp = cur.next;
        cur.next = prev;
        return reverse(prev,temp);
    }

    /**
     * 从后向前递归
     * @param head
     * @return
     */
    public ListNode reverseListV3(ListNode head) {
       if (head == null) return  head;
       if (head.next == null) return  head;
       //递归调用，翻转第二个节点开始往后的链表;
        ListNode last = reverseListV3(head.next);
        // 翻转头节点和第二个节点的指向
        head.next.next = head;
        //此时的head节点为尾节点，next应该指向空；
        head.next = null;
        return last;

    }


}
