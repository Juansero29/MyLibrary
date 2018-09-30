package models;

import data.StubData;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bookshelf, containing readable objects
 *
 * @author Juan
 */
public class Bookshelf {

    //region Fields


    /**
     * The readbles in this bookshelf
     *
     * @see Readable
     */
    private List<Readable> myReadables;

    //endregion

    //region Properties

    //region currentReadableIndexProperty
    /**
     * The index of the current book
     */
    private IntegerProperty currentReadableIndex;

    public int getCurrentReadableIndex() {
        return currentReadableIndex.get();
    }

    public IntegerProperty currentReadableIndexProperty() {
        return currentReadableIndex;
    }

    private void setCurrentReadableIndex(int currentReadableIndex) {
        this.currentReadableIndex.set(currentReadableIndex);
    }
    //endregion

    //region readablesCountProperty
    private IntegerProperty readablesCount;

    public int getReadablesCount() {
        return readablesCount.get();
    }

    public IntegerProperty readablesCountProperty() {
        return readablesCount;
    }

    public void setReadablesCount(int readablesCount) {
        this.readablesCount.set(readablesCount);
    }
    //endregion

    //endregion

    //region Constructors
    public Bookshelf() {
        this(new ArrayList<>());
        addReadable(StubData.getStubBook());
    }

    public Bookshelf(List<Readable> myReadables) {
        this.myReadables = myReadables;

        this.currentReadableIndex = new SimpleIntegerProperty();
        this.readablesCount = new SimpleIntegerProperty();

        this.setCurrentReadableIndex(-1);
        this.setReadablesCount(myReadables.size());
    }

    //endregion

    //region Methods


    /**
     * gets the readable at the current index
     *
     * @return - the readable at the current index
     */
    public Readable getcurrentReadable() {
        return myReadables.get(getCurrentReadableIndex());
    }

    /**
     * Adds a redeable to the bookshelf
     *
     * @param r - the readable to add
     */
    public void addReadable(Readable r) {

        myReadables.add(r);
        setReadablesCount(myReadables.size());
        increment();

        System.out.println("ADDED READABLE " + r.getTitle());
    }

    /**
     * Shifts to the next readable
     */
    public void next() {
        increment();
        System.out.println("next clicked");
    }

    /**
     * Shifts to the previous readable
     */
    public void previous() {
        decrement();
        System.out.println("previous clicked");
    }

    public Readable getReadableAt(int index) {
        return myReadables.get(index);
    }
    //endregion

    //region Utility Methods

    /**
     * increments the current book index
     */
    private void increment() {
        if (getReadablesCount() > getCurrentReadableIndex() + 1) {
            setCurrentReadableIndex(getCurrentReadableIndex() + 1);
        }
    }

    /**
     * decrements the current book index
     */
    private void decrement() {
        if (getCurrentReadableIndex() > 0) {
            setCurrentReadableIndex(getCurrentReadableIndex() - 1);
        }
    }


    //endregion
}
