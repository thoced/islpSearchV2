package islp.views;

import islp.islp.controllers.CloseAction;
import islp.islp.controllers.ImportAction;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuArea extends MenuBar{
    private MenuItem fermer;
    private Menu menuFile;
    private Menu menuDb;
    private Menu menuAbout;
    private MenuItem importer;
    private MenuItem aide;

    private Stage parentStage;


    public MenuArea(Stage parentStage) {
        super();
        this.parentStage = parentStage;
        initMenuItem();
    }

    private void initMenuItem(){

        menuFile = new Menu("File");
        this.getMenus().add(menuFile);
        menuDb = new Menu("Data Base");
        this.getMenus().add(menuDb);
        menuAbout = new Menu("Au sujet de");
        this.getMenus().add(menuAbout);

        fermer = new MenuItem("Fermer");
        fermer.setOnAction(new CloseAction());
        menuFile.getItems().add(fermer);

        importer = new MenuItem("Importer des données");
        importer.setOnAction(new ImportAction(parentStage));
        menuDb.getItems().add(importer);

        aide = new MenuItem("Aide");
        menuAbout.getItems().add(aide);

    }
}
