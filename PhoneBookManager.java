import java.util.*;

public class PhoneBookManager {
   public static void main(String[] args) { // main
      ContactList myContactList = new ContactList();
      Scanner input = new Scanner(System.in);
      int command = 0;
      
      System.out.println("Welcome to the Phone Book. Here are some commands:");
      System.out.println("type 'book' to display phone book");
      System.out.println("type 'size' to display phone book size");
      System.out.println("press 'index' to search an index");
      System.out.println("press 'info' to search a name/address/city/phone");
      System.out.println("press 'add' to add a contact");
      System.out.println("press 'insert' to insert a contact");
      System.out.println("press 'remove' to remove a contact");
      System.out.println("press 'quit' to quit");
      System.out.println();
      System.out.println("Enter a command");
      String commandPrompt = input.next();
      
      if (commandPrompt.equals("quit")) { // enter command
         command = 8;
      }
         
      while (command != 8) { 
         command = 0;
         switch(commandPrompt) { // valid command
            case "book":
               displayingBook(myContactList);
               command = 1;
               break;
            case "size":
               displayingSize(myContactList);
               command = 2;
               break;
            case "index":
               searchingIndex(myContactList, input);
               command = 3;
               break;
            case "info":
               searchingInfo(myContactList, input);
               command = 4;
               break;
            case "add":
               adding(myContactList, input);
               command = 5;
               break;
            case "insert":
               inserting(myContactList, input);
               command = 6;
               break;
            case "remove":
               removing(myContactList, input);
               command = 7;
               break;
         }
         
         if (command != 1 && command !=2 && command !=3 && command !=4 && command !=5 && command !=6 && command !=7 && command !=8) { // invalid command
               System.out.println("Invalid input.");
               System.out.println();
         }
         
         System.out.println(); // enter command again
         System.out.println("Enter a command.");
         commandPrompt = input.next();
         
         if (commandPrompt.equals("quit")) { // quit command
            command = 8;
         }
      }
  }
  
  public static void displayingBook(ContactList myContactList) {  // display phone book
      System.out.println(myContactList.toString());
  }
  
  public static void displayingSize(ContactList myContactList) { // display phone book size
      System.out.println(myContactList.size());
  }
  
  public static void searchingIndex(ContactList myContactList, Scanner input) { // search for contact
      System.out.println("Enter a contact's index.");
      int indexPrompt = input.nextInt() - 1;
      System.out.println(myContactList.get(indexPrompt));
  }
  
  public static void searchingInfo(ContactList myContactList, Scanner input) { // search for index
      System.out.println("Enter contact info.");
      String infoPrompt = input.next();
      System.out.println(myContactList.indexOf(infoPrompt) + 1);
  }
  
  
  public static void adding(ContactList myContactList, Scanner input) { // add contact
      boolean bool = true;
      String yesno = "yes";
      String[] infoPrompt = new String[] {"name", "address", "city", "phone"};
            
      while (bool == true) { // repeated adding
         System.out.println("Enter a name.");
         infoPrompt[0] = input.next();
         System.out.println("Enter an address.");
         infoPrompt[1] = input.next();
         System.out.println("Enter a city.");
         infoPrompt[2] = input.next();
         System.out.println("Enter a phone number.");
         infoPrompt[3] = input.next();
         myContactList.add(Arrays.toString(infoPrompt));
         System.out.println("Continue?");
         yesno = input.next();
         if (yesno.equals("no")) { // done adding
            bool = !bool;
         }
      }  
  }
  
  public static void inserting(ContactList myContactList, Scanner input) { // insert contact
      boolean bool = true;
      String yesno = "yes";
      String[] infoPrompt = new String[] {"name", "address", "city", "phone"};
      int indexPrompt = 0;
            
      while (bool == true) { // repeated inserting
         System.out.println("Enter a name.");
         infoPrompt[0] = input.next();
         System.out.println("Enter an address.");
         infoPrompt[1] = input.next();
         System.out.println("Enter a city.");
         infoPrompt[2] = input.next();
         System.out.println("Enter a phone number.");
         infoPrompt[3] = input.next();
         System.out.println("To which index would you like to place this contact?");
         indexPrompt = input.nextInt();
         indexPrompt = indexPrompt - 1;
         myContactList.add(indexPrompt, Arrays.toString(infoPrompt));
         System.out.println("Continue?");
         yesno = input.next();
         if (yesno.equals("no")) { // done inserting
            bool = !bool;
         }
      }  
  }
  
  public static void removing(ContactList myContactList, Scanner input) { // remove contact
      boolean bool = true;
      int indexPrompt = 0;
      String yesno = "yes";
            
      while (bool == true) { // repeated removing
         System.out.println("Enter a contact's index.");
         indexPrompt = input.nextInt() - 1;
         myContactList.remove(indexPrompt);
         System.out.println("Continue?");
         yesno = input.next();
         if (yesno.equals("no")) { // stop removing
            bool = !bool;
         }
      }  
   }
}
