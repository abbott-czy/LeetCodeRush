public class HasCycle141v1 {
    //给你一个链表的头节点 head ，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
//
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 10⁴]
// -10⁵ <= Node.val <= 10⁵
// pos 为 -1 或者链表中的一个 有效索引 。
//
//
//
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
//
// Related Topics 哈希表 链表 双指针 👍 1741 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            // 空链表、单节点链表一定不会有环
            while (fast != null && fast.next != null) {
                fast = fast.next.next; // 快指针，一次移动两步
                slow = slow.next;      // 慢指针，一次移动一步
                if (fast == slow) {   // 快慢指针相遇，表明有环
                    return true;
                }
            }
            return false; // 正常走到链表末尾，表明没有环
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
