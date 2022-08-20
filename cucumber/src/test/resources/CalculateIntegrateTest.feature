Feature: Calculate Controller API Test

  Scenario: Testing check version
    When the client call request GET "/version"
    Then the client receive status code of 200
    And the client receive result are as follows
    """
    1.0.0
    """

  Scenario: Testing not found
    When the client call request GET "/versions"
    Then the client receive status code of 404

  Scenario Outline: Testing summation of number
    When the client call request GET "/sum?variable=<variable>&constant=<constant>"
    Then the client receive status code of 200
    And the client receive result are as follows
    """
    5.0
    """
    Examples:
      | variable | constant |
      | 3        | 2        |
      | 4        | 1        |
      | 5        | 0        |

  Scenario Outline: Testing subtract of number
    When the client call request GET "/sub?variable=<variable>&constant=<constant>"
    Then the client receive status code of 200
    And the client receive result are as follows
    """
    3.0
    """
    Examples:
      | variable | constant |
      | 7        | 4        |
      | 8        | 5        |
      | 6        | 3        |

  Scenario Outline: Testing multiply of number
    When the client call request GET "/mul?variable=<variable>&constant=<constant>"
    Then the client receive status code of 200
    And the client receive result are as follows
    """
    12.0
    """
    Examples:
      | variable | constant |
      | 6        | 2        |
      | 3        | 4        |
      | 12       | 1        |

  Scenario Outline: Testing divide of number
    When the client call request GET "/div?variable=<variable>&constant=<constant>"
    Then the client receive status code of 200
    And the client receive result are as follows
    """
    6.0
    """
    Examples:
      | variable | constant |
      | 42       | 7        |
      | 30       | 5        |
      | 18       | 3        |

  Scenario Outline: Testing modular of number
    When the client call request GET "/mod?variable=<variable>&constant=<constant>"
    Then the client receive status code of 200
    And the client receive result are as follows
    """
    0.0
    """
    Examples:
      | variable | constant |
      | 7        | 7        |
      | 4        | 2        |
      | 50       | 5        |

  Scenario Outline: Testing divide or modular of number but got error
    When the client call request GET "/<path>?variable=<variable>&constant=<constant>"
    Then the client receive status code of 400
    And the client receive result are as follows
    """
    ArithmeticException
    """
    Examples:
      | path | variable |  | constant |
      | div  | 42       |  | 0        |
      | mod  | 30       |  | 0        |

  Scenario: Testing Internal Server Error
    When the client call request GET "/div?variable=4&constant=Hello"
    Then the client receive status code of 500
    And the client receive result are as follows
    """
    InternalServerError
    """