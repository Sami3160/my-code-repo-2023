public class cyclicDistance{
    public static void main(String[] args) {
        String s1="zbbz";
        int k=3;
        System.out.println(distance(s1, k));
        
    }
    public static String distance(String s1, int k){
        char[] crr=s1.toCharArray();
        for(int i=0;i<crr.length;i++){
            int dist_a1=(crr[i]-'a');
            int dist_a2=26-(crr[i]-'a');
            int index=(crr[i]-'a');
            if(dist_a1<dist_a2){
                while(k>0 && crr[i]!='a'){
                    k--;
                    index=index-1;
                    crr[i]=(char)((index+'a'));
                    System.out.println("Current char: " + crr[i]+" k: " + k);
                }
            }else if(dist_a2<=k){
                while(k>0 && crr[i]!='a'){
                    k--;
                    index=(index+1)%26;
                    crr[i]=(char)((index+'a'));
                    System.out.println("Current char: " + crr[i]+"k: " + k);
                }
            }else{
                while(k>0 && crr[i]!='a'){
                    k--;
                    index=index-1;
                    crr[i]=(char)((index+'a'));
                    System.out.println("Current char: " + crr[i]+" k: " + k);
                }
            }
        }
        return new String(crr);
    }
}