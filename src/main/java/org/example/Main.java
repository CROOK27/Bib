package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while (true){
            library.printMenu();
            try {
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1:
                    System.out.print("Название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Автор: ");
                    String author = scanner.nextLine();
                    System.out.print("Индинтификатор книги: ");
                    try {
                        int isbn = Integer.parseInt(scanner.nextLine());
                        library.addBook(new Book(title, author, isbn));
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод: введите числовой идентификатор.");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Индинтификатор книги: ");
                        int isbn = Integer.parseInt(scanner.nextLine());
                        library.borrowBook(isbn);
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод: введите числовой идентификатор.");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Индинтификатор книги: ");
                        int isbn = Integer.parseInt(scanner.nextLine());
                        library.returnBooks(isbn);
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод: введите числовой идентификатор.");
                    }
                    break;
                case 4:
                    System.out.print("Список книги: ");
                    library.listAvailableBooks();
                    break;


                    }

                }catch (NumberFormatException e){
                System.out.println("Неверный ввод.");
            }
        }
    }
}

