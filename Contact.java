public class Contact {
   public String data;
   public Contact next;
   
   public Contact() {
      this("blank", null);
   }
   
   public Contact(String data) {
      this(data, null);
   }
   
   public Contact(String data, Contact next) {
      this.data = data;
      this.next = next;
   }
}