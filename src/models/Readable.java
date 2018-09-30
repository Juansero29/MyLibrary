package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * Represents an object that can be read and stored in a bookshelf
 */
public abstract class Readable implements Identifiable {
    //region Properties

    //region pagesCountProperty
    protected IntegerProperty pagesCount;

    public int getPagesCount() {
        return pagesCount.get();
    }


    public IntegerProperty pagesCountProperty() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount.set(pagesCount);
    }
    //endregion

    //region titleProperty

    protected StringProperty title;

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }
    //endregion

    //region descriptionProperty
    protected StringProperty description;

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
    //endregion

    //region author
    protected ObjectProperty<Author> author;

    public Author getAuthor() {
        return author.get();
    }

    public ObjectProperty<Author> authorProperty() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author.set(author);
    }
    //endregion

    //region coverProperty
    protected ObjectProperty<Image> cover;

    public Image getCover() {
        return cover.get();
    }

    public ObjectProperty<Image> coverProperty() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover.set(cover);
    }
//endregion

    //endregion
}
