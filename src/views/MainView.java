package views;

import data.StubData;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Bookshelf;
import models.Readable;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * The MainView controller class
 */
public class MainView implements Initializable {


    //region FXML Fields
    @FXML
    public Button addReadableButton;
    @FXML
    public Button previousButton;
    @FXML
    public Button readButton;
    @FXML
    public Button nextButton;
    @FXML
    public ImageView readableCover;
    @FXML
    public Label readablesCountLabel;
    @FXML
    public Label currentReadableIndexLabel;
    @FXML
    public Button listMyBookshelfButton;
    @FXML
    private TextField readableTitleTextField;
    @FXML
    private Label authorLabel;
    @FXML
    private Label authorBirthdayLabel;
    @FXML
    private Label pageCountLabel;

    @FXML
    private Label descriptionLabel;
    //endregion

    //region Private Fields
    /**
     * The bookshelf to showcase
     */
    private Bookshelf myBookshelf;
    //endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setupCss();

        bindBookshelf();

        bindCurrentReadable();

        setupListeners();

    }

    //region Utility Methods

    /**
     * Sets up the CSS Ids to the FXML elements
     */
    private void setupCss() {
        HBox hbox = new HBox();
        hbox.getStyleClass().add("HBox");
    }

    /**
     * Binds the bookshelf to the view's elements
     */
    private void bindBookshelf() {
        myBookshelf = new Bookshelf();
        readablesCountLabel.textProperty().set(Integer.toString(myBookshelf.getReadablesCount()));
        currentReadableIndexLabel.textProperty().set(Integer.toString(myBookshelf.getCurrentReadableIndex() + 1));
    }

    /**
     * Binds the current readable of the bookshelf to the view's elements
     *
     * @see Bookshelf
     */
    private void bindCurrentReadable() {

        Readable currentReadable = myBookshelf.getcurrentReadable();

        readableTitleTextField.textProperty().bindBidirectional(currentReadable.titleProperty());

        authorLabel.textProperty().bind(currentReadable.authorProperty().getValue().nameProperty());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        authorBirthdayLabel.textProperty().bind(
                Bindings.createStringBinding(() ->
                        dtf.format(
                                currentReadable.authorProperty().getValue().birthdayProperty().get()
                        )));
        descriptionLabel.textProperty().bind(currentReadable.descriptionProperty());
        readableCover.imageProperty().bind(currentReadable.coverProperty());
        pageCountLabel.textProperty().bind(currentReadable.pagesCountProperty().asString());

    }

    /**
     * Sets up all the listeners needed for this view
     */
    private void setupListeners() {

        previousButton.setOnAction(__ -> myBookshelf.previous());
        nextButton.setOnAction(__ -> myBookshelf.next());
        addReadableButton.setOnAction(__ -> myBookshelf.addReadable(StubData.getStubBook()));
        listMyBookshelfButton.setOnAction(__ -> launchListedLib());


        myBookshelf.currentReadableIndexProperty().addListener((obs, old, newV) -> {
            unbind((Integer) old);
            bindCurrentReadable();
            currentReadableIndexLabel.textProperty().bind(myBookshelf.currentReadableIndexProperty().add(1).asString());
        });
        myBookshelf.readablesCountProperty().addListener(__ ->
                readablesCountLabel.textProperty().bind(myBookshelf.readablesCountProperty().asString())
        );
    }

    private void launchListedLib() {

        try {
            //TODO: Launch the window correctly
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/fxml/MyListedLibView.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "The list of books couldn't be opened!", ButtonType.OK);
            e.printStackTrace();
            a.showAndWait();
        }
    }

    /**
     * Unbinds the readable at the index's position
     *
     * @param index - the index
     */
    private void unbind(int index) {

        Readable r = myBookshelf.getReadableAt(index);
        readableTitleTextField.textProperty().unbindBidirectional(r.titleProperty());
        authorLabel.textProperty().unbind();
        authorBirthdayLabel.textProperty().unbind();
        descriptionLabel.textProperty().unbind();
        readableCover.imageProperty().unbind();
        pageCountLabel.textProperty().unbind();

    }
    //endregion
}
