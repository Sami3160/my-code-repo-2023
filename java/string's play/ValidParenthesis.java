import java.util.*;

public class ValidParenthesis {
    public static boolean checkValidString(String s) {
        Stack<Character> sc = new Stack<Character>();
        // if(s.charAt(0)=='(' && s.length()==1)return false;
        int c = 0, r = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                l++;
            if (s.charAt(i) == ')')
                r++;
            if (s.charAt(i) == '*') {
                c++;
                sc.push('*');
                continue;
            }
            if (sc.isEmpty()) {
                sc.push(s.charAt(i));
                continue;
            }
            if (sc.peek() == '(' && s.charAt(i) == ')') {
                sc.pop();
            } else {
                sc.push(s.charAt(i));
            }
        }
        String newSc="";
        for(int i=0;i<sc.size();i++){
            if(sc.peek()=='*'|| sc.peek()==')'){
                newSc+=sc.peek();
                sc.pop();
            }
            else{
                if(newSc.length()>0){
                    sc.pop();
                    newSc=newSc.substring(0, newSc.length()-1);
                }
            }
        }
        System.out.println(sc.size() + "\t" + c + "\t+" + l + "|" + r + "|" + s.length());
        
        if (sc.size() >0)
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString(
                "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}
