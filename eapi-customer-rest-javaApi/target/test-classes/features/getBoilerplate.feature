Feature: Validate if boilerplate API is providing expected information

@shakedown @smoke @sit
Scenario: Response code checks for boilerplate service
    Given I am a JSON API consumer
    When I request GET "/api/v1/walgreens/java/boilerplate/1"
    Then I should get a status code of 200

@shakedown @smoke @sit
Scenario: Status of ping service
   When I request GET "/api/v1/walgreens/java/boilerplate/ping"
   Then the response value of "apiname" should equal "waglobsbujavaboilerplt"
   Then the response value of "version" should equal "v1_0_0"
   Then the response value of "status" should equal "ok"
