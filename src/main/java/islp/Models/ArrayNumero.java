package islp.Models;

import java.util.ArrayList;

public class ArrayNumero extends ArrayList<NumeroModel>{
    public ArrayNumero() {
        super();
    }

    @Override
    public boolean add(NumeroModel numeroModel) {

        if(!this.contains(numeroModel))
            return super.add(numeroModel);

        return false;
    }


}
