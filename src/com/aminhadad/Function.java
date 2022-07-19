package com.aminhadad;
import java.util.ArrayList;
import java.util.Scanner;
public class Function {
    public static Scanner scanner=new Scanner(System.in);
    ArrayList<Data> list=new ArrayList<Data>();

    public void create(){
      Data data=new Data();
      System.out.println("PLZ enter contact name");
      data.setName(scanner.nextLine());
      System.out.println("PLZ enter contact number");
      data.setPhoneNumber(scanner.next());
      list.add(data);
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
        for (Data data:list) {
            if (data.getName()==searchedName) {
                return data;
            }
        }
        return null;
    }
}
