package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import com.adobe.aem.guides.wknd.core.models.Nimatabs;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.models.factory.ModelFactory;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { Nimatabs.class }, resourceType = {
        NimatabsImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class NimatabsImpl implements Nimatabs {

    protected static final String RESOURCE_TYPE = "wknd/components/nimatabs";

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String id;

    private Image image;

    @PostConstruct
    private void init() {
        // set the image object
        image = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Image.class);
    }

    @Override
    public String getTitle() {
        return StringUtils.isNotBlank(title) ? title.toUpperCase() : "Title";
    }

    @Override
    public String getText() {
        return StringUtils.isNotBlank(text) ? text : "Text";
    }

    @Override
    public String getId() {
        return StringUtils.isNotBlank(id) ? id : "ID";
    }

    @Override
    public boolean isEmpty() {
        final Image componentImage = getImage();
        if (StringUtils.isBlank(title) || StringUtils.isBlank(text) || StringUtils.isBlank(id)) {
            // Name is missing, but required
            return true;
        } else if (componentImage == null || StringUtils.isBlank(componentImage.getSrc())) {
            // A valid image is required
            return true;
        } else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }

    private Image getImage() {
        return image;
    }
}
