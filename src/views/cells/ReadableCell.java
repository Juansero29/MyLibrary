package views.cells;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import models.Readable;


public class ReadableCell extends ListCell<Readable> {

    private ImageView coverImageView;

    @Override
    protected void updateItem(Readable item, boolean empty) {
        coverImageView = new ImageView();


        if (!empty) {
            textProperty().bind(item.titleProperty().concat(" by ").concat(item.authorProperty()));
            coverImageView.imageProperty().bind(item.coverProperty());
            setGraphic(coverImageView);
        } else {
            textProperty().unbind();
            setGraphic(null);
        }
    }
}
