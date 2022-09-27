# API Automation Framework

![N|Solid](https://rest-assured.io/img/logo-transparent.png)

**These are sample tests who demonstrate API automation using Rest assured.**


- Designed and written in **JAVA**
- Implemented using **TestNG**
- Build Tools - **Maven**
- Test data - **Java Files**
- Implemented with **Builder Pattern**
- Test Reports - **Allure Report**
- Continuous Integration - **Circle CI**
- Data provide (post-ids) by another API '/posts' and feeding to test with testng **Data Provider**

---
### Platform Support
- Windows
- Linux
- Macintosh

---
### Usage
```sh
$ mvn clean test
```
### Usage with specific Test-Suite
```sh
mvn clean test -Dsurefire.suiteXmlFiles=API-Tests.xml
```

After test execution, Allure results will appear in 'allure-results' folder. To generate html report and automatically open it in a web browser, run the following command:

---
### Generate Report

```sh
$ allure serve allure-results
```

After execute above command it will open Allure report in browser itself.
