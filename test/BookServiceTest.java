/*Задание 2.

У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository. */

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task04.book.Book;
import task04.book.BookRepository;
import task04.book.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepository;

    @BeforeEach
    void arrange() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testFindBookById() {
        String bookId = "1";
        Book expectedBook = new Book(bookId, "Book title 1", "Author name 1");
        when(bookRepository.findById(bookId)).thenReturn(expectedBook);

        Book result = bookService.findBookById(bookId);

        assertEquals(expectedBook, result);
    }

    @Test
    void testFindAllBooks() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book title 1", "Author name 1"));
        expectedBooks.add(new Book("2", "Book title 2", "Author name 2"));

        when(bookRepository.findAll()).thenReturn(expectedBooks);
        List<Book> result = bookService.findAllBooks();

        assertEquals(expectedBooks, result);
    }
}
