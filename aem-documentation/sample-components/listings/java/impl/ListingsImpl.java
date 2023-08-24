package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Listings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = {Resource.class},
        adapters = {Listings.class},
        resourceType = {ListingsImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ListingsImpl implements Listings {
    protected static final String RESOURCE_TYPE = "wknd/components/listing";
    private static final Logger LOG = LoggerFactory.getLogger(ListingsImpl.class);
    
    @SlingObject
    Resource componentResource;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private List<String> listings;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<Map<String, String>> getListings() {
        List<Map<String, String>> listingsInfoMap = new ArrayList<>();
        try {
            Resource listingsInfo = componentResource.getChild("listings");
            if(listingsInfo != null){
                for (Resource listData : listingsInfo.getChildren()) {
                    Map<String,String> listingsMap = new HashMap<>();
                    listingsMap.put("address", listData.getValueMap().get("address",String.class));
                    listingsMap.put("price", listData.getValueMap().get("price", String.class));
                    listingsMap.put("bath", listData.getValueMap().get("bath", String.class));
                    listingsMap.put("beds", listData.getValueMap().get("beds", String.class));                    
                    listingsMap.put("sqft", listData.getValueMap().get("sqft", String.class));
                    listingsMap.put("image", listData.getValueMap().get("fileReference", String.class));

                    listingsInfoMap.add(listingsMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Listing Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ",listingsInfoMap.size());
        return listingsInfoMap;
    }

    //This is for single field multifield
    // @Override
    // public List<String> getListings() {
    //     if(listings == null){
    //         List<HashMap<String, String>> listingData = new ArrayList<HashMap<String, String>>();
    //         for(int i = 0; i < 10; i++){
    //             HashMap<String, String> test = new HashMap<String, String>();
    //             test.put("TestKey", "Test Value: " + i);
    //             listingData.add(i, test);
    //         }
    //         // return new ArrayList<>(listingData);
    //     }
    //     return new ArrayList<>(listings);
    // }
}