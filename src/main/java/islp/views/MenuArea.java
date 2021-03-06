package islp.views;

import islp.controllers.AboutAction;
import islp.controllers.CloseAction;
import islp.controllers.ExportCsvAction;
import islp.controllers.ExportPdfAction;
import islp.importPackage.ImportAction;
import islp.controllers.*;
import islp.optionPackage.OptionAction;
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
    private MenuItem option;
    private MenuItem export;
    private MenuItem exportOnlyItem;
    private MenuItem exportCSV;
    private MenuItem exportCSVOnlyItem;

    private Stage parentStage;

    public MenuArea(Stage parentStage) {
        super();
        this.parentStage = parentStage;
        initMenuItem();
    }

    private void initMenuItem(){


        menuFile = new Menu("Fichier");
        this.getMenus().add(menuFile);
        menuDb = new Menu("Data Base");
        this.getMenus().add(menuDb);
        menuAbout = new Menu("Au sujet de");
        this.getMenus().add(menuAbout);

        export = new MenuItem("Exporter en Pdf");
        export.setOnAction(new ExportPdfAction(parentStage,false));
        menuFile.getItems().add(export);

        exportOnlyItem = new MenuItem("Exporter en Pdf (Uniquement les items selectionnés)");
        exportOnlyItem.setOnAction(new ExportPdfAction(parentStage,true));
        menuFile.getItems().add(exportOnlyItem);

        exportCSV = new MenuItem("Exporter en CSV");
        exportCSV.setOnAction(new ExportCsvAction(parentStage,false));
        menuFile.getItems().add(exportCSV);

        exportCSVOnlyItem = new MenuItem("Exporter en CSV (Uniquement les items selectionnés)");
        exportCSVOnlyItem.setOnAction(new ExportCsvAction(parentStage,true));
        menuFile.getItems().add(exportCSVOnlyItem);

        option = new MenuItem("Option");
        option.setOnAction(new OptionAction(parentStage));
        menuFile.getItems().add(option);

        fermer = new MenuItem("Fermer");
        fermer.setOnAction(new CloseAction());
        menuFile.getItems().add(fermer);

        importer = new MenuItem("Importer des données");
        importer.setOnAction(new ImportAction(parentStage));
        menuDb.getItems().add(importer);

        aide = new MenuItem("Aide");
        menuAbout.getItems().add(aide);
        aide.setOnAction(new AboutAction(parentStage));

    }
}
