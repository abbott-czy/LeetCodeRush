import java.util.ArrayList;
import java.util.List;

public class IsPalindrome234v1 {
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
            List<Integer> numbers = new ArrayList<>();
            while (head!=null){
                numbers.add(head.val);
                head = head.next;
            }
            int size = numbers.size();
            int left = 0;
            int right = size - 1;
            while (left < right){
                if (numbers.get(left++) != numbers.get(right--)){
                    return false;
                }
            }
            return  true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


/*
    解答成功:
    执行耗时:8 ms,击败了38.50% 的Java用户
    内存消耗:53.4 MB,击败了84.91% 的Java用户
*/

}
