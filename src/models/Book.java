package models;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import utils.IdGenerator;

/**
 * Represents a book
 */
public class Book extends Readable {

    //region Properties

    //region editionNumberProperty

    /**
     * Represents the edition number for this book
     */
    private IntegerProperty editionNumber;

    public int getEditionNumber() {
        return editionNumber.get();
    }

    public IntegerProperty editionNumberProperty() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber.set(editionNumber);
    }

    //endregion

    //region releaseYearProperty
    /**
     * The year in which this book was released
     */
    private IntegerProperty releaseYear;

    public int getReleaseYear() {
        return releaseYear.get();
    }

    public IntegerProperty releaseYearProperty() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear.set(releaseYear);
    }

    //endregion

    //endregion

    //region Constructors

    /**
     * Builds a book with some default parameters
     *
     * @param title       - the book's title
     * @param author      - the book's author
     * @param description - the book's description
     */
    public Book(String title, Author author, String description, Image cover) {
        this(title, author, description, 1, 1998, 100, cover);
    }


    /**
     * Builds a new book
     *
     * @param title         - the book's title
     * @param author        - the book's author
     * @param description   - the book's description
     * @param editionNumber - the book's edition number
     * @param releaseYear   - the book's release year
     * @param pagesCount    - the book's page count
     */
    public Book(String title, Author author, String description, int editionNumber, int releaseYear, int pagesCount, Image cover) {


        this.editionNumber = new SimpleIntegerProperty();
        this.releaseYear = new SimpleIntegerProperty();


        this.author = new SimpleObjectProperty<>();
        this.description = new SimpleStringProperty();
        this.title = new SimpleStringProperty();
        this.pagesCount = new SimpleIntegerProperty();
        this.cover = new SimpleObjectProperty<>();


        setTitle(title);
        setAuthor(author);
        setDescription(description);
        setPagesCount(pagesCount);
        setCover(cover);


        setEditionNumber(editionNumber);
        setReleaseYear(releaseYear);


    }


    //endregion

    //region Utility Methods

    @Override
    public long getId() {

        return IdGenerator.generateLongId();
    }
    //endregion

}
