package org.example;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    public Library() {
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void borrowBook(int isbn) {
        Book book = getBookIsbn(books, isbn);
        if (book != null) {
            if (book.getAvailable() != false){
                book.setAvailable(false);
                System.out.println("Книга взята");
            }
            else {
                System.out.println("Данной книги нет");
            }
        }
        else {
            System.out.println("Данной книги нет");
        }
    }

    public void returnBooks(int isbn){
        Book book = getBookIsbn(books,isbn);
        if (book != null) {
            if (book.getAvailable() != true) {
                book.setAvailable(true);
                System.out.println("Книга возвращенна");
            }
            else {
                System.out.println("Книга уже возвращенна");
            }

        }
        else {
            System.out.println("Данной книги нет");
        }
    }

    public void listAvailableBooks(){
        ArrayList<Book> isAvailableBook = new ArrayList<Book>();
        for (Book book : books){
            if (book.getAvailable()){
                isAvailableBook.add(book);
            }
        }
        System.out.println(isAvailableBook);
    }

    private Book getBookIsbn(ArrayList<Book> books,int isbn){
        for (Book book : books){
            if (book.getISBN() == isbn);
                return book;
        }
        return null;
    }
    public void printMenu(){
        System.out.println("Меню");
        System.out.println("1 - Добавить книгу");
        System.out.println("2 - Взять книгу");
        System.out.println("3 - Вернуть книгу");
        System.out.println("4 - Список книг");
    }


}
