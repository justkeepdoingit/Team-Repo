package com.adobe.aem.guides.wknd.core.models;

import java.util.List;
import java.util.Map;

public interface NavigationText {
    List<Map<String, String>> getNavigationText();
    String getSelectSize();
    String getSelectAlign();
}
