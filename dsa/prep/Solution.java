import java.util.*;
public class Solution{
    public String highestScore(String[] names, int[] score){
        HashMap<String, Integer> map1=new HashMap<>();
        int n=names.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            map1.put(names[i], map1.getOrDefault(names[i], 0)+score[i]);
            max=Math.max(max, map1.get(names[i]));
        }
        HashSet<String> set=new HashSet<>(); 
        for(Map.Entry<String, Integer> entry: map1.entrySet()){
            if(entry.getValue()==max){
                set.add(entry.getKey());
            }
        }
        HashMap<String, Integer> curr=new HashMap<>();

        for(int i=0;i<n;i++){
            String name=names[i];
            int scr=score[i];
            curr.put(names[i], map1.getOrDefault(names[i], 0)+score[i]);
            if(curr.get(names[i])==max && set.contains(names[i])){
                System.out.println(names[i]);
                break;
            }
        }

        return "";
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        String[] names = {"mike", "andrew", "mike"};
        int[] score={3,5,2};
        System.out.println(s.highestScore(names, score));        
    }
}