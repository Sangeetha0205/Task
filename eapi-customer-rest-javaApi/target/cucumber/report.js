$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/getBoilerplate.feature");
formatter.feature({
  "name": "Validate if boilerplate API is providing expected information",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Response code checks for boilerplate service",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@shakedown"
    },
    {
      "name": "@smoke"
    },
    {
      "name": "@sit"
    }
  ]
});
formatter.step({
  "name": "I am a JSON API consumer",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I request GET \"/api/v1/walgreens/java/boilerplate/1\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I should get a status code of 200",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Status of ping service",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@shakedown"
    },
    {
      "name": "@smoke"
    },
    {
      "name": "@sit"
    }
  ]
});
formatter.step({
  "name": "I request GET \"/api/v1/walgreens/java/boilerplate/ping\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the response value of \"apiname\" should equal \"waglobsbujavaboilerplt\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the response value of \"version\" should equal \"v1_0_0\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the response value of \"status\" should equal \"ok\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});