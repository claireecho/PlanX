import java.util.*;

public class Queue<anyType> {
   
   private List<anyType> list;
   
   public Queue() {
      list = new LinkedList();
   }
   
   public boolean isEmpty() {
      return list.size() == 0;
   }
   
    public void add(anyType x) {
      list.add(x);
    }
    
    public anyType remove() {
      return list.remove(0);
    }
    
    public anyType peek() {
      return list.get(0);
    }
   
}