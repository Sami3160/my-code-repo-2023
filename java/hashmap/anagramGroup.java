import java.util.*;
class anagramGroup {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> l2=new ArrayList<String>();
        List<List<String>> res=new ArrayList<List<String>>();
        HashMap<String, List<String>> hmap=new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            // l2.add(strs[i]);
            if(hmap.containsKey(elivishChu(strs[i]))){
                // l2.clear();
                List<String> temp =hmap.get(elivishChu(strs[i]));
                temp.add(strs[i]);
                hmap.put( elivishChu(strs[i]) , temp);
                // l2.clear();
            }else{
                // l2.clear();
                List <String> temp=new ArrayList<String>();
                temp.add(strs[i]);
                hmap.put(elivishChu(strs[i]) , temp);
                // l2.clear();
                //ducking shimt
            }
        }
        for(List<String> ele: hmap.values()){
            res.add(ele);
        }
        return res;
    }
    
    public static String elivishChu(String str){
        String[] s=str.split("");
        String newStr=new String();
        Arrays.sort(s);
        for(int i=0; i<s.length; i++){
            newStr+=s[i];
        }
        System.out.println(newStr);
        return newStr;
    }


    public static void main(String[] args) {
        //grouping f anagrams using hasgmap....
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        anagramGroup obj = new anagramGroup();
        List<List<String>> result = obj.groupAnagrams(strs);
        System.out.println(result);
    }
}