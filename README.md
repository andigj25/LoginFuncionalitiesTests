# Test Automation Engineer Task

This is a project to run three simple tests on the login functionalities of the webpage:
https://the-internet.herokuapp.com/login

This is a maven project written in Java with the use of Selenium and JUnit.

Creator: Andi Gjetani

## The task

Create simple automated test script for a login form that includes the following test cases:
TC_1: I as a user want to successfully login with correct username and password
TC_2: I as a user should be denied when I enter a wrong username and password
TC_3: I as a user should be denied login with wrong username and shown the following error
message ‘Your username is invalid!’

## Running the tests

The tests are written in a single class and can be found at the following directory:

src > test > java > LoginFunctionalityTests

The class makes use of JUnit to run the tests in sequence one after the other.
