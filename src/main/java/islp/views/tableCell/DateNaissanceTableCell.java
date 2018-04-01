package islp.views.tableCell;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class DateNaissanceTableCell<T> extends TableCell<T,String>{
    @Override
    protected void updateItem(String date, boolean empty) {
        super.updateItem(date, empty);

        if(!empty && date != null && date.length() == 8) {
            String annee = date.substring(0, 4);
            String mois = date.substring(4, 6);
            String jour = date.substring(6, 8);
            String dateNaissance = jour + "/" + mois + "/" + annee;

            this.setText(dateNaissance);
        }
        //setStyle("-fx-background-color:red");
    }


    /**
     * Fabrique statique.
     */
    public static <T> Callback<TableColumn<T, String>, TableCell<T, String>> forTableColumn() {
        return new Callback<TableColumn<T, String>, TableCell<T, String>>() {

            @Override
            public TableCell<T, String> call(TableColumn<T, String> param) {
                return new DateNaissanceTableCell<>();
            }
        };
    }

}
