package Question3_2;

import java.util.Stack;

public class yuanStackWithMin {
    Stack<Integer> valStack; 
    Stack<Integer> minStack;
     
     public  yuanStackWithMin() {
         valStack = new Stack<Integer>();
         minStack = new Stack<Integer>();
     }
     
     public void push(int val) {
         valStack.push(val);
         if (minStack.empty()) {
             minStack.push(val);
         } else {
             if (val<=minStack.peek()) {
                 minStack.push(val);
             }
         }
     }
     
     public Integer pop() {
         int val = valStack.pop();
         if (val==minStack.peek()) {
             minStack.pop();
         }
         return val;
     }
     
     public int min() {
         if (!minStack.isEmpty()) {
             return minStack.peek();
         } else {
             return Integer.MAX_VALUE;
         }
     }
     
}