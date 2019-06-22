package islp.Models;

import java.io.Serializable;

public class SearchModel implements Serializable {

    private String searchValue;

    public SearchModel(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @Override
    public boolean equals(Object o) {
        if(((SearchModel)o).searchValue.equals(searchValue))
            return true;
        else
            return false;
    }
}
