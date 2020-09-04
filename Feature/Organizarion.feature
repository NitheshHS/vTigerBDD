@UAT
Feature: Create Organization

Scenario: user create an organization
Given user in HomePage and click on organization 
When organization page is opened and click on create organization link
And user enter organization name "JIO"
Then organization information page is open
And user logout from application

Scenario: user search for a oranization
Given user in HomePage and click on organization
When User search for Orgaization "NitheshHS"
Then organization name should be there