
public class goodString {
    public static String makeGood(String s) {
        String stack = new String("");
        for (int i = 0; i < s.length(); i++) {
            System.out.println(stack.length());
            // System.out.println(stack.charAt(stack.length()));
            if (stack.length()==0) {
                stack += s.charAt(i);
            } else {
                if (s.charAt(i) ==Character.toUpperCase(stack.charAt(stack.length()-1))) {
                    stack = stack.substring(0, stack.length()-1);
                } else {
                    stack += s.charAt(i);
                }
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }
}