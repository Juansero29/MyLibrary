package models;

import data.StubData;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.channels.ReadableByteChannel;
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
     * The readables in this bookshelf
     *
     * @see Readable
     */
    private ObservableList<Readable> theReadablesObs = FXCollections.observableArrayList();

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

    private void setReadablesCount(int readablesCount) {
        this.readablesCount.set(readablesCount);
    }
    //endregion

    //region theReadablesProperty
    /**
     * The observable list of readables.
     */

    private ReadOnlyListProperty<Readable> theReadables;

    public ReadOnlyListProperty<Readable> theReadablesProperty() {
        return theReadables;
    }

//endregion


    //endregion

    //region Constructors

    public Bookshelf() {
        this(new ArrayList<>());
        addReadable(StubData.getStubBook());
    }

    public Bookshelf(List<Readable> readables) {

        theReadablesObs.addAll(readables);
        theReadables = new SimpleListProperty<>();

        this.currentReadableIndex = new SimpleIntegerProperty();
        this.readablesCount = new SimpleIntegerProperty();

        this.setCurrentReadableIndex(-1);
        this.setReadablesCount(theReadablesObs.size());
    }

    //endregion

    //region Methods


    /**
     * gets the readable at the current index
     *
     * @return - the readable at the current index
     */
    public Readable getCurrentReadable() {
        return theReadablesObs.get(getCurrentReadableIndex());
    }

    /**
     * Adds a redeable to the bookshelf
     *
     * @param r - the readable to add
     */
    public void addReadable(Readable r) {

        theReadablesObs.add(r);
        setReadablesCount(theReadablesObs.size());
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

    /**
     * Gets the readable at the specified index
     *
     * @param index - the index
     * @return - the readable
     */
    public Readable getReadableAt(int index) {
        return theReadablesObs.get(index);
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
