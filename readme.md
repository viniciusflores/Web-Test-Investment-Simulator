
# Web-Test-Investment-Simulator
This project is to demonstrate the integration test in Banco Sicredi in the investment simulation web application.

This project includes several Selenium examples in both TestNG and Appium. 
Including sharing the BrowserStack testing tool.
I will also use it to build my own DSL
You can compile this source code with Maven.

### Description

To run browser tests, Selenium will need to be able to conduct a browser
installed on your system. By default, this repository is set to start Chrome as well as Firefox.
If you do not have any available, it should be removed from the suite test.

To change the browser Selenium will launch, edit the file
`src/main/java/suite/testNG.xml` changing the value of the name parameter 'browser'.


To run mobile tests, Selenium will need to connect to xx, the following credentials will be used. 
In this suite, it was configured to run on a Samnsung xx and an iphone xxx. 
Where they can be changed in the directory xxxx

In addition the BrowserStack tool allows a complete monitoring of the application on the device.
To have access to this data is necessary to access the site https://automate.browserstack.com/, 
with the credentials mentioned to accompany the various logs and test execution.

### Project

Here's a look at what the project contains:

```
.
└── src
   └── main
       └── java
           ├── core
           │   └── DriverFactory.java
           │   └── BasePage.java
           │   └── BaseTest.java
           │   └── ScreenshotUtility.java
           ├── page
           │   └── InvestmentPage.java
           ├── project_constants
           │   ├── AutomationTypeEnum.java
           │   ├── Constants.java
           │   ├── InvestmentProfileEnum.java
           │   └── InvestmentProfileEnum.java
           │── suite
           │   └── TestNG.xml
           │── test
           │   ├── InvestmentFieldsTest.java
           │   └── InvestmentTest.java
           └── util
               ├── ExtentManager.java
               ├── ExtentTestManager.java
               └── TestListener.java
```

We'll break it down below.

#### core.*

**DriverFactory** it is the heart of the project, where the Selenium Driver for the browser defined in the test suite is instantiated.
The other classes extend the base page and test page, which in turn extend the driverfactory, giving access to the entire driver project instantiated here.

**BasePage** is the project DSL, all key methods are placed here and distributed by the project.

**BaseTest** indicates all common actions in the test classes. It is in this class that it receives the browser/device parameters for the selenium driver creation.

**ScreenshotUtility** is the class used for test screenshots.

#### page.*

The **page**` package is the where the logical methods of all pages are indicated.

#### project_constants.*

All static and fixed project data are in this package.

#### suite.TestNG

From the project directory, **maven** performs the tests indicated in this suite.

#### test.*

This package is the key, where all the tests to be performed are described.

#### util.*

The classes in this package are dedicated to test report generation.
