package views;

import javafx.fxml.Initializable;
import models.Bookshelf;

/**
 * A view that can display a bookshelf
 *
 * @see Bookshelf
 */
public abstract class BookshelfDisplayerView implements Initializable {
    //region Private Fields
    /**
     * The bookshelf to showcase
     */
    protected Bookshelf myBookshelf;
    //endregion

    //region Utility Methods

    /**
     * Sets up the CSS Ids to the FXML elements
     */
    protected abstract void setupCss();

    /**
     * Binds the bookshelf to the view's elements
     */
    protected abstract void bindBookshelf();


    /**
     * Binds the current readable of the bookshelf to the view's elements
     *
     * @see Bookshelf
     */
    protected abstract void bindCurrentReadable();

    /**
     * Sets up all the listeners needed for this view
     */
    protected abstract void setupListeners();

    /**
     * Unbinds the readable at the index's position
     *
     * @param index - the index
     */
    protected abstract void unbind(int index);
    //endregion
}
