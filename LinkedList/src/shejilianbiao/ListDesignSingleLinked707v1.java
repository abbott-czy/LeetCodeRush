package shejilianbiao;


public class ListDesignSingleLinked707v1 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class ListNode{
        int val;
        ListNode next;

        ListNode(){}

        ListNode(int val){
            this.val = val;
        }
    }

    class MyLinkedList {
        int size;
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);

        }

        public int get(int index) {

            if (index < 0 || index >= size){
                return  -1;
            }

            ListNode tem = head;
            for (int i = 0; i <= index; i++) {
                tem = tem.next;
            }
            return tem.val;

        }

        public void addAtHead(int val) {
            addAtIndex(0,val);

        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size)
                return;

            if (index < 0 )
                index = 0;

            size++;

            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }

            ListNode insertNode = new ListNode(val);
            insertNode.next = pre.next;
            pre.next = insertNode;

        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;
            size--;
            if (index == 0){
                head = head.next;
                return;
            }

            ListNode currentNode = this.head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next = currentNode.next.next;


        }
    }
}
