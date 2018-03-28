package islp.Models;

import javafx.collections.ObservableArray;

import java.io.Serializable;

public class RegistreModel implements Serializable {

    private String registreName;

    public RegistreModel(String registreName) {
        this.registreName = registreName;
    }

    public RegistreModel() {
    }

    public String getRegistreName() {
        return registreName;
    }

    public void setRegistreName(String registreName) {
        this.registreName = registreName;
    }

    @Override
    public String toString() {
        return registreName;
    }
}
