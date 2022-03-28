package ru.kutepov.booklibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kutepov.booklibrary.model.Book;
import ru.kutepov.booklibrary.service.BookService;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public String findAll(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }


    @GetMapping("/book-create")
    public String createBookForm(Book book) {
        return "book-create";
    }


    @PostMapping("/book-create")
    String createBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }


    @GetMapping("/book-delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }


    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Integer id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }


    @PostMapping("/book-update")
    public String updateUser(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }
}
