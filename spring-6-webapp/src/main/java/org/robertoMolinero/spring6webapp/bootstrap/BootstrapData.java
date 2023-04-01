package org.robertoMolinero.spring6webapp.bootstrap;

import org.robertoMolinero.spring6webapp.domain.Author;
import org.robertoMolinero.spring6webapp.domain.Book;
import org.robertoMolinero.spring6webapp.domain.Publisher;
import org.robertoMolinero.spring6webapp.repository.AuthorRepository;
import org.robertoMolinero.spring6webapp.repository.BookRepository;
import org.robertoMolinero.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        saveAnAuthorWithOneBook("Eric", "Evans", "Domain Driven Design", "123456", "Springer");
        saveAnAuthorWithOneBook("Rod", "Johnson", "J2EE Development without EJB", "654321", "Microsoft Press");

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
        System.out.println();
    }

    private void saveAnAuthorWithOneBook(String firstName, String lastName, String title, String isbn, String publisherName) {
        // init
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherName);

        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);

        // save
        Author authorSaved = authorRepository.save(author);
        Book bookSaved = bookRepository.save(book);
        Publisher publisherSaved = publisherRepository.save(publisher);

        // connect
        authorSaved.getBooks().add(bookSaved);
        bookSaved.getAuthors().add(authorSaved);
        bookSaved.setPublisher(publisherSaved);

        // save again
        authorRepository.save(authorSaved);
        bookRepository.save(bookSaved);
    }
}
