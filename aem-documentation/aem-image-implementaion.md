## Image Initiation

Always import the following APIs.

These imports are all related in creating an Image Object.

```java
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.factory.ModelFactory;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import com.adobe.cq.wcm.core.components.models.Image;
```

This import is important for creating the `init` method

```java
import javax.annotation.PostConstruct;
```

After importing all the needed `APIs`. Next is declare the variables

```java
protected static final String RESOURCE_TYPE = "wknd/components/bettertitle";

//SlingHttpServletRequest is needed for the parameter for initiating the image variable
@Self
private SlingHttpServletRequest request;

//Model Factory helps you to initiate the variable image inside the @PostConstruct init function
@OSGiService
private ModelFactory modelFactory;

private Image image;
```

Afterd declaring the needed variables, create the init method then initialize the image variable

```java
@PostConstruct private void init() {
image = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Image.class);
}
```

Then create a method that will return the image

```java
private Image getImage() {
  return image;
}
```
