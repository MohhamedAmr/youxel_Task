Project Components
1. Selenium WebDriver
Selenium WebDriver is used to automate browser interactions, allowing tests to perform actions like clicking buttons, entering text, and verifying element properties.

2. Page Object Model (POM)
The POM design pattern organizes the project to separate test logic from page interaction logic. Each page has a corresponding class in the pages package that contains methods to interact with page elements. This improves code reusability and makes tests easier to maintain.

3. TestNG
TestNG is used for managing test executionand handling assertions.

4. Allure Report
Allure provides a clear and interactive test report that includes test execution history results and screenshots. After running tests, an Allure report can be generated and opened in a browser for review.

to generate Allure Report execute allTests.xml File then navigate to terminal and execute command 'allure serve'
