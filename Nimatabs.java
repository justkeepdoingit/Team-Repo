package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

/**
 * Represents the Byline AEM Component for the WKND Site project.
 **/
public interface Nimatabs {
    /***
     * @return a string to display as the name.
     */
    String getTitle();

    /***
     * @return a string to display as the name.
     */
    String getText();

    /***
     * @return a string to display as the name.
     */
    String getId();

    /***
     * @return a boolean if the component has enough content to display.
     */
    boolean isEmpty();
}
