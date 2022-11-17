# Sales-Taxes

> Sales Taxes application is developed using Java. Here, the application takes receipt file for various types of products and then print out the receipt details
by including tax as per condition on certain goods. Types of taxes applicable to goods are **Basic Sales Tax** and **Additional Sales Tax**. Basic sales 
tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Additional sales tax is applicable on all 
imported goods at a rate of 5%, with no exemptions.
 
**Tools and Technologies used:**
  - Java
  - Maven
  - Docker
  - Log4j2
  - Lombok
  - Junit

## Steps to Run Application
1) Install Java 8 and Maven.
2) Clone the repo or download the code as zip file using the [link](https://github.com/AjayDhami/Sales-Taxes).
3) Run the command: `mvn clean package` to install all the required dependencies.
4) Once the build is successful, executable JAR file is created under `/target` folder with name `sales-taxes-jar-with-dependencies.jar`.
5) You can run the application either by running the JAR file created in **Step 4** or by running the application directly from IDE.
6) By default, one particular receipt file is selected as input file, but this file can be overridden by passing your desired file. For this you have
to pass your desired **filepath** as program arguments while running application from IDE or while executing JAR file.
7) In order to get idea about format of input file as receipt file, refer to
[shoppingbaskets](https://github.com/AjayDhami/Sales-Taxes/tree/main/src/main/resources/shoppingbaskets) directory under `/src/main/resources` section.

**Executing JAR File:**
```java -jar sales-taxes-jar-with-dependencies.jar <FILE_PATH>```
- **Note:** Here, `<FILE_PATH>` is optional. 
- **Example:** `java -jar target/sales-taxes-jar-with-dependencies.jar shoppingbaskets/inputThird.txt`

**Executing Docker Image:**
1) Navigate to directory where `Dockerfile` is located.
2) Build the Docker image using Dockerfile: `docker build -t sales-taxes-calculator .`
3) Run the Docker image: `docker run sales-taxes-calculator <FILE_PATH>`. Here *<FILE_PATH>* is optional.
Example: `docker run sales-taxes-calculator shoppingbaskets/inputThird.txt`
