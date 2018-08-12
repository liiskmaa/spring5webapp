package liiskmaa.spring.spring5webapp.bootstrap;

import liiskmaa.spring.spring5webapp.model.Author;
import liiskmaa.spring.spring5webapp.model.Book;
import liiskmaa.spring.spring5webapp.model.Publisher;
import liiskmaa.spring.spring5webapp.model.repositories.AuthorRepository;
import liiskmaa.spring.spring5webapp.model.repositories.BookRepository;
import liiskmaa.spring.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Publisher harper = new Publisher();
        harper.setName("Harper Collins");
        harper.setAddress("Address 1");

        publisherRepository.save(harper);

        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Publisher wrox = new Publisher();
        wrox.setName("Wrox");
        wrox.setAddress("Address 2");

        publisherRepository.save(wrox);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
