package ru.kutepov.booklibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kutepov.booklibrary.model.Book;
import ru.kutepov.booklibrary.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book findById(Integer id) {
        return bookRepository.findById(id).orElseThrow();
    }


    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

}
