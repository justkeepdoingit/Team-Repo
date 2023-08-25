# AEM Authoring Guide

Welcome to the AEM Authoring Guide. This comprehensive resource is designed to help you master the fundamentals of Adobe Experience Manager (AEM) authoring. From launching your AEM instance to navigating through the interface, understanding the structure, and creating your own custom templates and components, this guide covers all the essentials.

## Getting Started

### 1. Setting Up Your Development Environment

To begin, ensure you have a well-prepared development environment. Follow these steps:

1. Create a designated folder for your AEM project.
2. Download the **[aem-guides-wknd.all-2.1.4 and wknd](../files/)** zip file.
3. Extract the contents of the **[wknd](../files/)** zip file into your designated folder, resulting in this file structure:

```
wknd
  + aem-guides-wknd
    + (... all the files required for development)
  . .DS_Store
```

4. Move the **aem-guides-wknd** folder out of the **wknd** folder, then delete any unnecessary files or folder. Your setup is now ready.

### 2. Installing Packages

1. Launch your AEM instance (**aem-author-p4502**), which will direct you to the AEM login page.
2. Enter your admin credentials: `Username: admin, Password: admin`.
3. Navigate to **`Tools`** > **`General`** > **`CRXDE Lite`**. For now, focus on CRXDE Lite as you will learn the other items later on.
   ![Navigation to CRXDE Lite](../files/image.png)
4. Head to the **Package** section and select **Upload Package**.
   ![Package Section](../files/package.jpeg)
   ![Upload Package](../files/uploadpackage.jpeg)
5. Browse your files and upload the **`aem-guides-wknd.all-2.1.4.zip`** package.
   ![Upload Package](../files/browse.png)

### 3. Building the Project

1. Post installation, navigate to the **`aem-guides-wknd`** folder. Locate the **pom.xml** file.
2. Identify **nodeVersion** and **npmVersion**, modifying the values to reflect the versions installed on your local system.
3. Open your Command Prompt (CMD) or Git Bash, directing the terminal to your **`aem-guides-wknd`** folder.
4. Execute the following command to build your project:

```
mvn clean install -PautoInstallPackage
```

It takes some time for the build to finish and should end like this:

```
...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for WKND Sites Project 0.0.1-SNAPSHOT:
[INFO]
[INFO] WKND Sites Project ................................. SUCCESS [  0.113 s]
[INFO] WKND Sites Project - Core .......................... SUCCESS [  3.136 s]
[INFO] WKND Sites Project - UI Frontend ................... SUCCESS [  4.461 s]
[INFO] WKND Sites Project - Repository Structure Package .. SUCCESS [  0.359 s]
[INFO] WKND Sites Project - UI apps ....................... SUCCESS [  1.732 s]
[INFO] WKND Sites Project - UI content .................... SUCCESS [  0.956 s]
[INFO] WKND Sites Project - UI config ..................... SUCCESS [  0.064 s]
[INFO] WKND Sites Project - All ........................... SUCCESS [  8.229 s]
[INFO] WKND Sites Project - Integration Tests ............. SUCCESS [  3.329 s]
[INFO] WKND Sites Project - Dispatcher .................... SUCCESS [  0.027 s]
[INFO] WKND Sites Project - UI Tests ...................... SUCCESS [  0.032 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  23.189 s
[INFO] Finished at: 2023-01-10T11:12:23-05:00
[INFO] ------------------------------------------------------------------------
```

6. Finally, go to **`Navigation`** > **`Sites`** to find the **`WKND`** site, which you can use for practice.
   ![Navigation to Sites](../files/navigation.jpeg)
   ![Sites](../files/sites.jpeg)
   ![WKND Site](../files/WKND.png)

Congratulations! You've successfully set up your AEM localhost for authoring. Familiarize yourself with the environment before delving into the basics.

## Next Steps

Ready for the next stage? Move on to [The Basics](./basics.md), where we'll explore foundational concepts to help you become proficient in AEM authoring.
