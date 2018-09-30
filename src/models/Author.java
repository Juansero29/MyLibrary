package models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utils.IdGenerator;

import java.time.LocalDate;

/**
 * Represents the author of a readable object
 *
 * @see Readable
 */
public class Author implements Identifiable {

    //region Properties

    //region nameProperty
    private StringProperty name;

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
    //endregion

    //region birthdayProperty

    private ObjectProperty<LocalDate> birthday;

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    //endregion

    //endregion

    //region Utility Methods
    @Override
    public long getId() {
        return IdGenerator.generateLongId();
    }
    //endregion

    public Author(String name, LocalDate birthday) {

        this.name = new SimpleStringProperty();
        this.birthday = new SimpleObjectProperty<>();

        setName(name);
        setBirthday(birthday);
    }
}
