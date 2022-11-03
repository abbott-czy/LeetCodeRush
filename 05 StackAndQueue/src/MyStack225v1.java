//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
//
// 实现 MyStack 类：
//
//
// void push(int x) 将元素 x 压入栈顶。
// int pop() 移除并返回栈顶元素。
// int top() 返回栈顶元素。
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
//
//
//
//
// 注意：
//
//
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
//
//
//
//
// 示例：
//
//
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
//
//
//
//
// 提示：
//
//
// 1 <= x <= 9
// 最多调用100 次 push、pop、top 和 empty
// 每次调用 pop 和 top 都保证栈不为空
//
//
//
//
// 进阶：你能否仅用一个队列来实现栈。
//
// Related Topics 栈 设计 队列 👍 561 👎 0




import java.util.LinkedList;
import java.util.Queue;

//	执行耗时:0 ms,击败了100.00% 的Java用户
//  内存消耗:39.3 MB,击败了40.87% 的Java用户


public class MyStack225v1 {

    class MyStack {
        // offer() 将指定的元素添加为LinkedList最后一个元素
        // poll()  检索并删除LinkedList的第一个元素
        // peek()  检索LinkedList的头部元素（第一个元素）
        Queue<Integer> input;
        Queue<Integer> output;

        public MyStack() {
            input = new LinkedList<>();
            output = new LinkedList<>();
        }

        public void push(int x) {
            output.offer(x);
            while (!input.isEmpty()){
                output.offer(input.peek());
                input.poll();
            }

            Queue<Integer> tem;
            tem = input;
            input = output;
            output = tem;

        }

        public int pop() {

            return input.poll();


        }

        public int top() {
            return input.peek();

        }

        public boolean empty() {
            return input.isEmpty();
        }
    }

}
