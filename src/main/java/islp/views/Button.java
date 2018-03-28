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
       // this.setStyle("-fx-background-color:red");
        this.setStyle("-fx-background-radius:24;-fx-background-color:#EFECCA;-fx-border-size:8;-fx-border-color:#A7A37E;-fx-border-radius:24");
    }
}
