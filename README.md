## Project Overview and structure
This project is an UI automation framework built using Java and Selenium WebDriver,designed for a clean automation, maintainable test design and thread-safe execution.
The framework follows the Page Object Model (POM) pattern to ensure clear separation between test logic and page interactions. 
It supports scalable test design, parallel execution, and consistent reporting.

<img width="636" height="874" alt="image" src="https://github.com/user-attachments/assets/e29274f2-6fbf-462c-a34b-4f9bb9374967" />
<img width="479" height="715" alt="image" src="https://github.com/user-attachments/assets/6f7c538c-0190-419d-ba32-b1b47a8d1c2f" />

## Tech Stack
- Language: Java 17  
- UI Automation: Selenium WebDriver 4.x  
- Test Framework: TestNG  
- Build Tool: Maven  
- Design Pattern: Page Object Model (POM)  
- Reporting: ExtentReports  
- Version Control: Git & GitHub  

## Framework Architecture
- Test Layer:  
  Contains TestNG test classes that define test scenarios and assertions. Tests interact
  only with page-level methods and do not contain direct Selenium code.

- Page Layer:  
  Implements the Page Object Model. Each page class represents a specific application
  feature and contains locators and page-level actions. Page classes extend a common
  BasePage to reuse the shared methods.

- BasePage:  
  Acts as the foundation for all page classes. It manages the WebDriver instance through
  constructor-based dependency injection and provides reusable methods such as
  click, text entry, waits, and common interactions.

- Driver Management:  
  WebDriver creation and lifecycle management are handled by a dedicated DriverFactory.
  A ThreadLocal WebDriver is used to ensure thread-safe execution during parallel runs.

- Test Initialization:  
  A BaseTest class manages browser setup and teardown.This ensures consistent environment setup for each test execution.

- Configuration Management:  
  Environment-specific values such as browser type, URLs, and timeouts are managed
  using a properties-based configuration approach. Also sensitive informations like credentials are managed through a separate template file and credentials can also
  be read from environment variables.

## Reporting
The framework uses ExtentReports to generate detailed and readable execution reports
for each test run.
- Each test execution is logged with clear pass/fail status.
- Failure scenarios automatically capture screenshots.
- Screenshots are embedded directly into the HTML report using Base64 encoding, eliminating dependency on external image files.
Reporting is implemented using TestNG listeners. A thread-safe reporting mechanism is used to support parallel execution.
<img width="1914" height="983" alt="image" src="https://github.com/user-attachments/assets/a34880fe-fb0b-416d-bd93-4c9af07dee37" />
<img width="1913" height="976" alt="image" src="https://github.com/user-attachments/assets/fc5079a5-14bf-4e30-b707-940eaabf0644" />

## How to Run Tests
- Clone the repository
- Configure required properties(config.properties and refer sensitive.properties.example)
- Run tests using TestNG or via Maven commands

