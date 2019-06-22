package islp.Models;

import java.util.ArrayList;

public class ArraySearch extends ArrayList<SearchModel>{
    public ArraySearch() {
        super();
    }

    @Override
    public boolean add(SearchModel searchModel) {

        if(!this.contains(searchModel))
            return super.add(searchModel);

        return false;
    }


}
