public interface PhoneBook {
   public int size();
   public String get(int index);
   public String toString();
   public int indexOf(String contactInfo);
   public void add(String contactInfo);
   public void add(int index, String contactInfo);
   public void remove(int index);
}
