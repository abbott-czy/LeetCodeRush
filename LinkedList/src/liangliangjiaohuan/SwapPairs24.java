package liangliangjiaohuan;



public class SwapPairs24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 方法1.设置虚拟头结点
     * @param head
     * @return
     */
    public ListNode swapPairsV1(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next !=null && prev.next.next !=null){
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummyNode.next;
    }

    public ListNode swapPairsV2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        // 获取当前节点的下一个节点
        ListNode  next =  head.next;
        ListNode newNode = swapPairsV2(next.next);
        //这里进行交换;
        next.next = head;
        head.next = newNode;
        return next;
    }

}
