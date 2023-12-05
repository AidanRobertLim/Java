public class ContactList implements PhoneBook {
   private Contact front;
   
   public ContactList() {
      front = null;
   }

   public int size() {
      int count = 0;
      Contact current = front;
      while (current != null) {
         current = current.next;
         count++;
      }
      return count;
   }
   
   public String get(int index) {
      return nodeAt(index).data;
   }
   
   public String toString() {
      if (front == null) {
         return "[]";
      } else {
         String result = "[" + front.data;
         Contact current = front.next;
         while (current != null) {
            result += ", " + current.data;
            current = current.next;
         }
         result += "]";
         return result;
     }
  }
  
  public int indexOf(String info) {
      int index = 0;
      Contact current = front;
      while (current != null) {
         if (current.data.contains(info)) {   
            return index;
         }
         index++;
         current = current.next;
      }
      return index;
  }
  
  public void add(String info) {
      if (front == null) {
         front = new Contact(info);
      } else {
         Contact current = front;
         while (current.next != null) {
            current = current.next;
         }
         current.next = new Contact(info);
      }
  }
  
  public void add(int index, String info) {
      if (index == 0) {
         front = new Contact(info, front);
      } else {
         Contact current = nodeAt(index - 1);
         current.next = new Contact(info, current.next);
      }
  }
  
  public void remove(int index) {
      if (index == 0) {
         front = front.next;
      } else {
         Contact current = nodeAt(index - 1);
         current.next = current.next.next;
      }
   }
   
   private Contact nodeAt(int index) {
      Contact current = front;
      for (int i = 0; i< index; i++) {
         current = current.next;
      }
      return current;
   }
}