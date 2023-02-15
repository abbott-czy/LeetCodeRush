import java.util.ArrayList;
import java.util.List;

public class IsPalindrome234v2 {
    //给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,2,1]
//输出：true
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围[1, 10⁵] 内
// 0 <= Node.val <= 9
//
//
//
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
//
// Related Topics 栈 递归 链表 双指针 👍 1614 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 如果为空或者仅有一个节点，返回true
            if (head == null && head.next == null) return true;
            ListNode slow = head;
            ListNode fast = head;
            ListNode pre = head;
            while (fast != null && fast.next != null){
                pre = slow;  // 记录slow的前一个结点
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;  // 分割两个链表

            // 前半部分
            ListNode cur1 = head;
            // 后半部分。这里使用了反转链表
            ListNode cur2 = reverseList(slow);

            while (cur1 != null){
                if (cur1.val != cur2.val) return false;

                // 注意要移动两个结点
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return true;
        }
        ListNode reverseList(ListNode head){
            // 反转链表
            ListNode tmp = null;
            ListNode pre = null;
            while (head != null){
                tmp = head.next;
                head.next = pre;
                pre = head;
                head = tmp;
            }
            return pre;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


/*
    解答成功:
    执行耗时:8 ms,击败了38.50% 的Java用户
    内存消耗:53.4 MB,击败了84.91% 的Java用户
*/

}
