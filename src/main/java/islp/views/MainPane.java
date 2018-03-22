package islp.views;

import islp.islp.controllers.CloseAction;
import islp.islp.controllers.ImportAction;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {

    private MenuBar menuBar;

    private Menu menuFile;

    private Menu menuDb;
    private MenuItem fermer;
    private MenuItem importer;
    private InputArea inputArea;
    private ResultArea resultArea;
    private ButtonArea buttonArea;

   ;

    public MainPane() {
        super();


        menuBar = new MenuBar();
        menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);
        menuDb = new Menu("Data Base");
        menuBar.getMenus().add(menuDb);

        initMenuItem();
        initInputArea();
        initResultArea();
        initButtonArea();

        this.setTop(menuBar);

    }

    private void initMenuItem(){

        fermer = new MenuItem("Fermer");
        fermer.setOnAction(new CloseAction());
        menuFile.getItems().add(fermer);

        importer = new MenuItem("Importer des données");
        importer.setOnAction(new ImportAction());
        menuDb.getItems().add(importer);
    }

    private void initInputArea(){
        inputArea = new InputArea();
        this.setLeft(inputArea);

    }

    private void initResultArea(){
        resultArea = new ResultArea();
        this.setCenter(resultArea);
    }

    private void initButtonArea(){
        buttonArea = new ButtonArea();
        this.setBottom(buttonArea);
    }


}
