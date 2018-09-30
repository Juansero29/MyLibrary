package data;

import models.Bookshelf;

/**
 * Manages a bookshelf
 */
public class BookshelfManager {

    /**
     * The bookshelf
     */
    private static Bookshelf theBookshelf;

    static {
        theBookshelf = new Bookshelf();
    }

    public static Bookshelf getBookshelf() {
        return theBookshelf;
    }
}
