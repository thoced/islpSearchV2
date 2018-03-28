package islp.Models;

import java.io.Serializable;

public class NumeroModel implements Serializable {
    private String numero;

    public NumeroModel() {
    }

    public NumeroModel(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
