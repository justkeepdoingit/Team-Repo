package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.NavigationText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = {Resource.class},
        adapters = {NavigationText.class},
        resourceType = {NavigationTextImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class NavigationTextImpl implements NavigationText {
    protected static final String RESOURCE_TYPE = "wknd/components/navigationtext";

    @SlingObject
    Resource componentResource;

    @ValueMapValue
    private String selectSize;

    @ValueMapValue
    private String selectAlign;

    @Override
    public List<Map<String, String>> getNavigationText() {
        List<Map<String, String>> navigationLinks = new ArrayList<>();
        try {
            Resource navData = componentResource.getChild("navigationtext");
            if(navData != null){
                for(Resource navInfo : navData.getChildren()){
                    Map<String,String> navLinks = new HashMap<>();
                    navLinks.put("navigationName", navInfo.getValueMap().get("navigationName", String.class));
                    navLinks.put("urlPath", navInfo.getValueMap().get("urlPath", String.class));
                    navigationLinks.add(navLinks);
                }
            }
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return navigationLinks;
    }

    @Override
    public String getSelectSize() {
        return selectSize;
    }

    @Override
    public String getSelectAlign() {
        return selectAlign;
    }
    
}
