@smoke
Feature: user could select home page sliders
  Scenario:  first slider is clickable on home page
    When        user clicks on first slider
    And         user select product of first slider
    Then        user go to first product page

  Scenario:  second slider is clickable on home page
    When        user clicks on second slider
    And         user select product of Second slider
    Then        user go to second product page