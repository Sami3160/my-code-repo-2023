package problems;

import java.util.*;

public class SharedQueue {
    Queue<Integer> queue=new LinkedList<>();
    int capacity=5;
    public synchronized void  produce(int num)throws Exception{
        if(queue.size()==capacity){
            wait();
        }
        queue.add(num);
        System.out.println("Produceed "+num);
        notify();
    }

    
    public synchronized int consume() throws Exception{
        if(queue.size()==0){
            wait();
        }
        int num=queue.poll();
        System.out.println("Consumed "+num);
        notify();
        return num;
    }


    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        SharedQueue sq=new SharedQueue();
        new Thread(()->{
            try {
                sq.produce(12);
                sq.produce(14);
                sq.produce(43);
                sq.produce(92);
                sq.produce(22);
                sq.produce(02);
                sq.produce(88);
            } catch (Exception e) {
               System.out.println(e.toString()); 
            }
        }).start();

                new Thread(()->{
            try {
                sc.nextLine();
                sq.consume();
                sc.nextLine();
                sq.consume();
                sc.nextLine();

                sq.consume();
                sc.nextLine();

                sq.consume();
            } catch (Exception e) {
               System.out.println(e.toString()); 
            }
        }).start();
    }
}
