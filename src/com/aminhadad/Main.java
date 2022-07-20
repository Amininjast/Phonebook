package com.aminhadad;
import java.util.Scanner;
public class Main {
public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        Function function=new Function();
        int selectedMenu=0;

        while (selectedMenu!=5) {
        System.out.println("Phonebook");
        function.showMenu();
        selectedMenu=scanner.nextInt();
            switch (selectedMenu) {
                case 1:
                    function.create();
                    break;
                case 2:
                    function.read();
                    break;
                case 3:
                    function.update();
                    break;
                case 4:
                    function.delete();
                    break;
                case 5:
                    break;

            }
        }
    }
}
