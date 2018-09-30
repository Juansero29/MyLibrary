package views;

import data.BookshelfManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import models.Readable;
import views.cells.ReadableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class MyListedLibView extends BookshelfDisplayerView {

    //region FXML Fields
    @FXML
    public ListView<Readable> readablesListView;
    @FXML
    public TextField readableTitleTextFieldDetail;
    @FXML
    public Label authorLabelDetail;
    @FXML
    public Label authorBirthdayLabelDetail;
    @FXML
    public Label pageCountLabelDetail;
    @FXML
    public Label descriptionLabelDetail;
    @FXML
    public ToggleButton toggleButton;

    //endregion

    //region Utility Methods
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupCss();

        bindBookshelf();

        bindCurrentReadable();

        setupListeners();
    }

    @Override
    protected void setupCss() {
        HBox hbox = new HBox();
        hbox.getStyleClass().add("HBox");
    }

    @Override
    protected void bindBookshelf() {
        myBookshelf = BookshelfManager.getBookshelf();
        readablesListView.setCellFactory(param -> new ReadableCell());
        readablesListView.itemsProperty().bind(myBookshelf.theReadablesProperty());

    }

    @Override
    protected void bindCurrentReadable() {


    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void unbind(int index) {

    }
    //endregion

}
