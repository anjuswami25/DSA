import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result;

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];  

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {  
                int b = stack.pop();  
                int a = stack.pop();  
                if (token.equals("+")) result = a + b;
                else if (token.equals("-")) result = a - b;
                else if (token.equals("*")) result = a * b;
                else result = a / b;  // integer division
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));  
            }
        }

        return stack.pop(); 
    }
}
