package liiskmaa.spring.spring5webapp.model.repositories;

import liiskmaa.spring.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
