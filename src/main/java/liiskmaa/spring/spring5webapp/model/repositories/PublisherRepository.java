package liiskmaa.spring.spring5webapp.model.repositories;

import liiskmaa.spring.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
