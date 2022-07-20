package com.aminhadad;
import java.util.ArrayList;
import java.util.Scanner;
public class Function {
    public static Scanner scanner=new Scanner(System.in);
    ArrayList<Contact> list=new ArrayList<Contact>();

    public void create(){
      Contact contact =new Contact();
      System.out.println("PLZ enter contact name");
      contact.setFirstName(scanner.nextLine());
      System.out.println("PLZ enter contact number");
      contact.setPhoneNumber(scanner.next());
      list.add(contact);
      System.out.println("Contact saved.\n");
    }
    public void delete(){}
    public void read(){
        Object data=searchByName();
        System.out.println(data.toString());

    }
    public void update(){}
    public void showMenu(){
        System.out.println("1-Create Contact\n2-Show Contact\n3-Update Contact\n4-Delete Contact\n5-Exit\n");
        System.out.print("Your Command : ");
    }
    public Object searchByName(){
        System.out.println("enter the name");
        String searchedName=scanner.nextLine();
        for (Contact contact :list) {
            if (contact.getFirstName()==searchedName) {
                return contact;
            }
        }
        return null;
    }
}
