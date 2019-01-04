package search;

import base.CommonAPI;

public class SearchPage extends CommonAPI {
    public void searchMenu(){
        typeOnElementNEnter("#twotabsearchtextbox", "Books");
        navigateBack();
        //clearField("#twotabsearchtextbox");
        typeOnElementNEnter("#twotabsearchtextbox", "honey");
        navigateBack();
        //clearField("#twotabsearchtextbox");
        typeOnElementNEnter("#twotabsearchtextbox", "iPhone");

    }
}
