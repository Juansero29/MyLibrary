package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import utils.IdGenerator;

/**
 * Represents a magazine
 */
public class Magazine extends Readable {

    //region Private Fields


    //region issueCountProperty
    /**
     * The issue number for this magazine
     */
    private IntegerProperty issueCount;

    public int getIssueCount() {
        return issueCount.get();
    }

    public IntegerProperty issueCountProperty() {
        return issueCount;
    }

    public void setIssueCount(int issueCount) {
        this.issueCount.set(issueCount);
    }
    //endregion
    //endregion

    //region Constructors


    /**
     * builds a magazine with some default parameters
     *
     * @param title       - magazine's title
     * @param a           - magazine's author
     * @param description - magazine's description
     * @param cover       - magazine's cover
     */
    public Magazine(String title, Author a, String description, Image cover) {
        this(title, a, description, cover, 0, 50);
    }

    /**
     * Builds a magazine
     *
     * @param title       - magazine's title
     * @param a           - magazine's author / publisher
     * @param description - magazine's description
     * @param cover       - magazine's cover
     * @param issueCount  - magazine's issue count
     * @param pagesCount  - magazine's pages count
     */
    public Magazine(String title, Author a, String description, Image cover, int issueCount, int pagesCount) {
        this.issueCount = new SimpleIntegerProperty();

        this.author = new SimpleObjectProperty<>();
        this.description = new SimpleStringProperty();
        this.title = new SimpleStringProperty();
        this.cover = new SimpleObjectProperty<>();
        this.pagesCount = new SimpleIntegerProperty();


        setTitle(title);
        setAuthor(a);
        setDescription(description);
        setCover(cover);

        setIssueCount(issueCount);
        setPagesCount(pagesCount);

    }
    //endregion

    //region Utility Methods
    @Override
    public long getId() {
        return IdGenerator.generateLongId();
    }


    //endregion
}
