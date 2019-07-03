package islp.views;

import islp.ResultPackage.ContextMenuAction;
import islp.ResultPackage.ResultArea;
import islp.ResultPackage.ShowInfoAction;
import islp.controllers.SingletonObjectManager;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainPane extends BorderPane {

    private Stage parentStage;
    private InputArea inputArea;
    private ResultArea resultArea;
    private ButtonArea buttonArea;
    private MenuArea menuArea;

    public MainPane(Stage parentStage) {
        super();
        this.parentStage = parentStage;
        initMenuItem();
        initInputArea();
        initResultArea();
        initButtonArea();

    }

    public InputArea getInputArea() {
        return inputArea;
    }

    public ResultArea getResultArea() {
        return resultArea;
    }

    public ButtonArea getButtonArea() {
        return buttonArea;
    }

    public MenuArea getMenuArea() {
        return menuArea;
    }

    private void initMenuItem(){
        menuArea = new MenuArea(parentStage);
        SingletonObjectManager.getInstance().getObjects().put(MenuArea.class,menuArea);
        this.setTop(menuArea);
    }

    private void initInputArea(){
        inputArea = new InputArea();
        SingletonObjectManager.getInstance().getObjects().put(InputArea.class,inputArea);
        this.setLeft(inputArea);

    }

    private void initResultArea(){
        resultArea = new ResultArea();
        resultArea.setOnContextMenuRequested(new ContextMenuAction(resultArea));
        resultArea.setOnMouseClicked(new ShowInfoAction(resultArea));
        SingletonObjectManager.getInstance().getObjects().put(ResultArea.class,resultArea);
        this.setCenter(resultArea);
    }

    private void initButtonArea(){
        buttonArea = new ButtonArea(parentStage);
        SingletonObjectManager.getInstance().getObjects().put(ButtonArea.class,buttonArea);
        this.setBottom(buttonArea);

    }


}
