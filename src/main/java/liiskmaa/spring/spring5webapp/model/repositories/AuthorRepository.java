package liiskmaa.spring.spring5webapp.model.repositories;

import liiskmaa.spring.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
