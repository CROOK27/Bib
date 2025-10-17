package bookTest;

import org.example.Book;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTest {

    private Book book;

    @BeforeMethod
    public void setUp() {
        book = new Book("Война и мир", "Лев Толстой", 12345);
    }

    @Test
    public void testBookCreation() {
        Assert.assertEquals(book.getTitle(), "Война и мир");
        Assert.assertEquals(book.getAuthor(), "Лев Толстой");
        Assert.assertEquals(book.getISBN(), 12345);
        Assert.assertTrue(book.getAvailable());
    }

    @Test
    public void testBookSetters() {
        book.setTitle("Новое название");
        book.setAuthor("Новый автор");
        book.setISBN(54321);
        book.setAvailable(false);

        Assert.assertEquals(book.getTitle(), "Новое название");
        Assert.assertEquals(book.getAuthor(), "Новый автор");
        Assert.assertEquals(book.getISBN(), 54321);
        Assert.assertFalse(book.getAvailable());
    }

    @Test
    public void testBookToString() {
        String toString = book.toString();

        Assert.assertTrue(toString.contains("Война и мир"));
        Assert.assertTrue(toString.contains("Лев Толстой"));
        Assert.assertTrue(toString.contains("12345"));
        Assert.assertTrue(toString.contains("isAvailable=true"));
    }

    @Test
    public void testBookInitialAvailability() {
        Book newBook = new Book("Test", "Author", 99999);
        Assert.assertTrue(newBook.getAvailable());
    }
}