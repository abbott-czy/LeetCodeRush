import java.util.ArrayList;
import java.util.List;

public class ReorderList143v1 {
    //给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
//
//L0 → L1 → … → Ln - 1 → Ln
//
//
// 请将其重新排列后变为：
//
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [1,2,3,4]
//输出：[1,4,2,3]
//
// 示例 2：
//
//
//
//
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3]
//
//
//
// 提示：
//
//
// 链表的长度范围为 [1, 5 * 10⁴]
// 1 <= node.val <= 1000
//
//
// Related Topics 栈 递归 链表 双指针 👍 1135 👎 0


//leetcode submit region begin(Prohibit modification and deletion)




     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void reorderList(ListNode head) {
            // 方法1 使用数组存储结点
            List<ListNode> list = new ArrayList<>();
            ListNode cur = head;
            while(cur != null){
                list.add(cur);
                cur = cur.next;
            }
            cur = head;
            int l = 1, r = list.size() - 1;
            int count = 0;
            while(l<=r){
                if (count % 2 == 0){
                    // 偶数
                    cur.next = list.get(r);
                    r--;
                }else{
                    //基数
                    cur.next = list.get(l);
                    l++;
                }
                cur = cur.next;
                count++;
            }
            cur.next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
