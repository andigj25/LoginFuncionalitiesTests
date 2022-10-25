# Test Automation Engineer Task

This is a project to run three simple tests on the login functionalities of the webpage:  
https://the-internet.herokuapp.com/login

This is a Maven project written in Java with the use of Selenium and JUnit.

Creator: Andi Gjetani

## The task

Create simple automated test script for a login form that includes the following test cases:

TC_1: I as a user want to successfully login with correct username and password  
TC_2: I as a user should be denied when I enter a wrong username and password  
TC_3: I as a user should be denied login with wrong username and shown the following error message ‘Your username is invalid!’  

## Running the tests

By default the project supports running tests on Google Chrome version 106, as the project uses ChromeDriver version 106.0.5249.61.

To change the current version of the drivers inside the project you may visit the following page and download the version of ChromeDriver that matches the version of Google Chrome installed on your operating system.

- [ ] [ChromeDriver for Google Chrome](https://chromedriver.chromium.org/downloads)

Then replace the file found in the following directory:  
src > main > resources > chromedriver.exe

The tests are written in a single class and can be found at the following directory:

src > test > java > LoginFunctionalityTests

The class makes use of JUnit to run the tests in sequence one after the other.
