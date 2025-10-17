package libraryTest;

import org.example.Book;
import org.example.Library;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeMethod
    public void setUp() {
        library = new Library();
        book1 = new Book("Война и мир", "Лев Толстой", 12345);
        book2 = new Book("Преступление и наказание", "Фёдор Достоевский", 67890);
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        library.addBook(book2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        library.listAvailableBooks();

        System.setOut(originalOut);
        String output = outputStream.toString();

        Assert.assertTrue(output.contains("Война и мир"));
        Assert.assertTrue(output.contains("Преступление и наказание"));
    }

    @Test
    public void testBorrowBook() {
        library.addBook(book1);

        Assert.assertTrue(book1.getAvailable());

        library.borrowBook(12345);

        Assert.assertFalse(book1.getAvailable());
    }

    @Test
    public void testBorrowNonExistentBook() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        library.borrowBook(99999);

        System.setOut(originalOut);
        String output = outputStream.toString();

        Assert.assertTrue(output.contains("Данной книги нет"));
    }

    @Test
    public void testReturnBook() {
        library.addBook(book1);

        book1.setAvailable(false);
        Assert.assertFalse(book1.getAvailable());

        library.returnBooks(12345);

        Assert.assertTrue(book1.getAvailable());
    }

    @Test
    public void testListAvailableBooks() {
        library.addBook(book1);
        library.addBook(book2);

        book2.setAvailable(false);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        library.listAvailableBooks();

        System.setOut(originalOut);
        String output = outputStream.toString();

        Assert.assertTrue(output.contains("Война и мир"));
        Assert.assertFalse(output.contains("Преступление и наказание"));
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        library.addBook(book1);

        library.borrowBook(12345);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        library.borrowBook(12345);

        System.setOut(originalOut);
        String output = outputStream.toString();

        Assert.assertTrue(output.contains("Данной книги нет"));
    }

    @Test
    public void testReturnAlreadyReturnedBook() {
        library.addBook(book1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        library.returnBooks(12345);

        System.setOut(originalOut);
        String output = outputStream.toString();

        Assert.assertTrue(output.contains("Книга уже возвращенна"));
    }

    @Test
    public void testReturnNonExistentBook() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        library.returnBooks(99999);

        System.setOut(originalOut);
        String output = outputStream.toString();

        Assert.assertTrue(output.contains("Данной книги нет"));
    }

    @Test
    public void testEmptyLibraryList() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        library.listAvailableBooks();

        System.setOut(originalOut);
        String output = outputStream.toString();

        Assert.assertEquals(output.trim(), "[]");
    }
}