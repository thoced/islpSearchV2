package islp.ResultPackage.bngRenderFactory;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class BngTableCell<T> extends TableCell<T,String> {

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if(empty || item  == null || item.isEmpty()) {
            this.getChildren().clear();
            this.setText("");
        }
        else {

            if (!empty && item != null) {
                this.getChildren().add(new bngHBox(item));
            }
        }


    }

    /**
     * Fabrique statique.
     */
    public static <T> Callback<TableColumn<T, String>, TableCell<T, String>> forTableColumn() {
        return new Callback<TableColumn<T, String>, TableCell<T, String>>() {

            @Override
            public TableCell<T, String> call(TableColumn<T, String> param) {
                return new BngTableCell<>();
            }
        };
    }
}
