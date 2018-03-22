package islp.views;

public class Button extends javafx.scene.control.Button{
    public Button() {
        super();
        initButton();

    }

    public Button(String text) {
        super(text);
        initButton();
    }

    private void initButton(){
        this.setStyle("-fx-background-radius:24");
    }
}
