    import java.util.*;  
    class TestJavaCollection1{  
    public static void main(String args[]){  
      ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
      list.add("Eren");
      list.add("Mikasa");  
      list.add("Zoro");  
      list.add("Armin");  
    
      Iterator itr=list.iterator();  
      while(itr.hasNext()){  
        System.out.println(itr.next());  
      }  
      }  
    }  
