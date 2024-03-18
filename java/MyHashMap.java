import java.util.HashMap;

public class MyHashMap {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar)
                    return false;
            } else {
                sToT.put(sChar, tChar);
            }

            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar)
                    return false;
            } else {
                tToS.put(tChar, sChar);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));    // Output: true
        System.out.println(isIsomorphic("foo", "bar"));    // Output: false
        System.out.println(isIsomorphic("paper", "title"));// Output: true
    }
}
