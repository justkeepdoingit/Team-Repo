package com.adobe.aem.guides.wknd.core.models;

import java.util.List;
import java.util.Map;

public interface Listings {
    String getText();
    /*
     * List<String> getListings();
     * this is for single field multifield
     * 
    */
    List<Map<String,String>> getListings();
}
