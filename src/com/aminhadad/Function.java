package com.aminhadad;
import java.util.ArrayList;
import java.util.Scanner;
public class Function {
    public static Scanner scanner=new Scanner(System.in);
    ArrayList<Contact> contactList =new ArrayList<Contact>();

    public void create(){
      Contact contact =new Contact();
      System.out.println("PLZ enter contact name");
      contact.setFirstName(scanner.nextLine());
      PhoneNumber phoneNumber=new PhoneNumber();
      System.out.println("PLZ enter type of number\n[home =1,work =2 ,other =3,phone =4]");
      int type=scanner.nextInt();
       switch (type){
           case 1:
               phoneNumber.setNumberType(PhoneNumber.NumberType.home);
               break;
           case 2:
               phoneNumber.setNumberType(PhoneNumber.NumberType.work);
               break;
           case 3:
               phoneNumber.setNumberType(PhoneNumber.NumberType.other);
               break;
           case 4:
               phoneNumber.setNumberType(PhoneNumber.NumberType.phone);
               break;
       }

      System.out.println("PLZ enter contact number");
      phoneNumber.setNumber(scanner.next());
      contactList.add(contact);
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
        for (Contact contact : contactList) {
            if (contact.getFirstName()==searchedName) {
                return contact;
            }
        }
        return null;
    }
}
