import java.util.*;

public class bitStuffing1 {
    public static void main(String[] args) {
        int[] res=bitStuffing(new int[]{1,1,0,1,1,1,1,1,1,1,1});
        System.out.println("data after stuffing bits");
        for (int i : res) {
            System.out.print(i+", ");
        }

        int[] newRes=bitStuffing(new int[]{1,1,0,1,1,1,1,1,1,1,1});
        System.out.println("\n\nunstuffed dataa");
        for (int i : newRes) {
            System.out.print(i+", ");
        }
    }
    public static int[] bitStuffing(int arr[]){
        int count=0;
        List<Integer> l1=new ArrayList<Integer>();
        for(int x: arr){
            if(x==1 && count <5){
                count++;
                l1.add(x);
            }else{
                count=0;
                l1.add(x);
            }
            if(count==5){
                l1.add(0);
                count=0;
            }
        }

        int[] res=new int[l1.size()];
        for(int x=0; x<l1.size(); x++){
            res[x]=l1.get(x);
        }
        return res;
    }

    public static int[] bitUnstuffing(int[] arr){
        List<Integer> l1=new ArrayList<Integer>();
        int count=0;
        for(int x: arr){
            if(x==1 && x<5){
                count++;
                l1.add(x);
            }else{
                count=0;
                l1.add(0);
            }
            if (count==5) {
                count=0;
            }
        }
        return arr;
    }
}

