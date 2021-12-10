class Solution {
    public boolean isValid(String s) {
        // 1. Read each character in string
        // 2. Push closing bracket to stack
        // 3. If character doesn't match a closing bracket or doesn't have a closing bracket, then invalid
        // 4. Valid if stack is empty after all comparisons

        Stack<Character> stack = new Stack<Character>();
        
        // Loop through characters in input string
        for (char c : s.toCharArray()) {
            // Push closing bracket of input character to stack
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            // If top bracket doesn't match input (closing bracket) or is empty, then invalid
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        // Valid if no brackets left in string (every bracket must be closed)
        return stack.isEmpty();
    }
}