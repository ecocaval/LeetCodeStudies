package queue;

import java.util.Stack;

public class EX_232 {

    public static void main(String[] args) {

    }

//    1 <= x <= 9
//    At most 100 calls will be made to push, pop, peek, and empty.
//    All the calls to pop and peek are valid.

    public class MyQueue {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        int front;

        public MyQueue() {

        }

        public void push(int x) {

            if(s1.isEmpty()) {
                front = x;
            }

            s1.add(x);
        }

        public int pop() {

            if(s1.size() == 1) {
                return s1.pop();
            }

            while(!s1.isEmpty()) {
                helper.add(s1.pop());
            }

            int temp = helper.peek();

            helper.pop();

            front = helper.peek();

            while(!helper.isEmpty()) {
                s1.add(helper.pop());
            }

            return temp;
        }

        public int peek() {
            return front;
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }

}
