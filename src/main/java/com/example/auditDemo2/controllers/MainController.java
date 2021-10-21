package com.example.auditDemo2.controllers;

import com.example.auditDemo2.models.Book;
import com.example.auditDemo2.models.BookRepository;
import com.example.auditDemo2.models.Publication;
import com.example.auditDemo2.models.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublicationRepository publicationRepository;

    @PostMapping("add/publication")
    public Publication addPublication(@RequestBody Publication publication) {
        return publicationRepository.save(publication);
    }

    @PutMapping("update/publication/{id}")
    public String updatePublication(@PathVariable int id, @RequestBody Publication publication) {
        Publication p = publicationRepository.getById(id);
        publication.setId(p.getId());
        publicationRepository.save(publication);
        return "Publication updated";
    }

    @DeleteMapping("delete/publication/{id}")
    public String deletePublication(@PathVariable int id) {
        publicationRepository.deleteById(id);
        return "Publication deleted";
    }

    @PostMapping("add/book")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("update/book/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        Book b = bookRepository.getById(id);
        book.setId(b.getId());
        bookRepository.save(book);
        return "Book updated";
    }

    @DeleteMapping("delete/book/{id}")
    public String deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }
}
