@Demo @UI @Contacts
Feature: Contacts

  Background:
    Given the Demo Application is opened

  @UI @Product @TC-UI-CON-001
  Scenario Outline: Tests the valid addition of a Contact
    When the user navigates to "Add New Contact" page
    And the user adds a new contact with "valid" data
      | Name   | Address   | City   | Phone   | Email   | Status   | Gender   |
      | <Name> | <Address> | <City> | <Phone> | <Email> | <Status> | <Gender> |
    Then a new Contact "<Email>" is created successfully

    Examples:
      | Name        | Address     | City         | Phone      | Email                       | Status  | Gender |
      | Contact 001 | Address 001 | Athens       | 2101111111 | email001@intrasoft-intl.com | enabled | male   |
      | Contact 002 |             | Thessaloniki |            | email002@intrasoft-intl.com |         |        |

  @UI @Product @TC-UI-CON-002
  Scenario Outline: Tests the invalid addition of a Contact
    When the user navigates to "Add New Contact" page
    And the user adds a new contact with "invalid" data
      | Name   | Address   | City   | Phone   | Email   | Status   | Gender   |
      | <Name> | <Address> | <City> | <Phone> | <Email> | <Status> | <Gender> |
    Then the Contact "invalidContact" is not created successfully

    Examples:
      | Name           | Address | City         | Phone | Email                             | Status | Gender |
      |                |         | Thessaloniki |       | invalidContact@intrasoft-intl.com |        |        |
      | invalidContact |         |              |       | invalidContact@intrasoft-intl.com |        |        |
      | invalidContact |         | Thessaloniki |       |                                   |        |        |

  @UI @Product @TC-UI-CON-003
  Scenario: Tests the Contact view
    When the user navigates to "Contact List" page
    And the user selects the contact "Contact 001" to "view"
    Then the selected contact contains appropriate data
      | Name        | Address     | City   | Phone      | Email                       | Status  | Gender |
      | Contact 001 | Address 001 | Athens | 2101111111 | email001@intrasoft-intl.com | enabled | male   |

  @UI @Product @TC-UI-CON-004
  Scenario Outline: Tests the Contact update
    When the user navigates to "Contact List" page
    And the user selects the contact "Contact 002" to "edit"
    And the user updates the data of the selected contact
      | Name   | Address   | City   | Phone   | Email   | Status   | Gender   |
      | <Name> | <Address> | <City> | <Phone> | <Email> | <Status> | <Gender> |
    Then the data of the selected contact are updated appropriately
      | Name   | Address   | City   | Phone   | Email   | Status   | Gender   |
      | <Name> | <Address> | <City> | <Phone> | <Email> | <Status> | <Gender> |

    Examples:
      | Name         | Address      | City         | Phone      | Email                        | Status   | Gender |
      | Contact 002a | Address 002a | Thessaloniki | 2102222222 | email002a@intrasoft-intl.com | disabled | female |

  @UI @Product @TC-UI-CON-005
  Scenario: Tests the Contact delete
    When the user navigates to "Contact List" page
    And the user selects the contact "Contact 001" to "delete"
    Then the contact "Contact 001" is deleted successfully
