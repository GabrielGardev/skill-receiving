package softuni.bookshopsystem.entities;

import lombok.Getter;
import lombok.Setter;
import softuni.bookshopsystem.entities.enums.AgeRestriction;
import softuni.bookshopsystem.entities.enums.EditionType;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "edition_type", nullable = false)
    private EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "age_restriction", nullable = false)
    private AgeRestriction ageRestriction;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_categories",
    joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories;
}
