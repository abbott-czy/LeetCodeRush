package yichulianbiaoyuansu;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点数目在范围 [0, 10⁴] 内
// 1 <= Node.val <= 50
// 0 <= val <= 50
//
//
// Related Topics 递归 链表 👍 1061 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


// * Definition for singly-linked list.



public class RemoveElements203v1 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 不添加虚拟节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null)
            return head;

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 不添加虚拟节点and pre Node方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        while(head!=null && head.val==val){
            head = head.next;
        }
        ListNode curr = head;
        while(curr!=null){
            while(curr.next!=null && curr.next.val == val){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
