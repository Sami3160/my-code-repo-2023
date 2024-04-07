import java.util.Stack;

class RemoveParenthesis {
    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        String str = new String("");
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (stack.isEmpty() ) {
                    if(s.charAt(i)==')')continue;
                    stack.push(s.charAt(i));
                    str+=s.charAt(i);
                }else{
                    if (stack.peek() == '(' && s.charAt(i) == ')') {
                        str+=s.charAt(i);
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                        str += s.charAt(i);
                    }
                }
            } else {
                str += s.charAt(i);
            }
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}