package ru.kutepov.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kutepov.booklibrary.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
