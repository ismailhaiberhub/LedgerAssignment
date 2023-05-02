Feature: Posts use case cases : Add - Delete - Update Posts

  Scenario Outline: Posts use case 1 : Add new Post
    Given the user is on the main page of conduit
    When the user clicks on the button
    Then the user is redirected to the login page
    When the user fill his "<email>"
    And the user fill his password "<password>"
    And the user clicks on Sign in Button
    Then the user can log to his account
    When the user clicks on the button New Post
    Then the user is on the page of adding new post
    When the user fill all the fields
      |title      |Lorem ipsum|
      |subject    |dolor sit amet|
      |content    |Maecenas sagittis massa orci, sagittis ornare nisl gravida sed. Vivamus maximus purus et sapien condimentum, vitae scelerisque risus iaculis|
      |tags       |#Cras #vulputate #euismod #mollis|
    Then the user pusblishes the articles by clicking on the button
    And the user verifies that the post published
    Examples:
      | email                |password |
      | haibeismail@gmail.com |Rmq8JEkUPPt6eES|


  Scenario Outline: Posts use case 2 : Add new Post and Delete it
    Given the user is on the main page of conduit
    When the user clicks on the button
    Then the user is redirected to the login page
    When the user fill his "<email>"
    And the user fill his password "<password>"
    And the user clicks on Sign in Button
    Then the user can log to his account
    When the user clicks on the button New Post
    Then the user is on the page of adding new post
    When the user fill all the fields
      |title      |Aenean a mi at lectus|
      |subject    |congue posuere mollis|
      |content    |Vestibulum id porttitor orci. Nullam ultrices est ex, non euismod nisl commodo ut. Donec ut ipsum enim. Phasellus nec sollicitudin augue|
      |tags       |#Suspendisse #potenti|
    Then the user pusblishes the articles by clicking on the button
    And the user verifies that the post published
    When the user deletes the post
    Then the user is on his feed page
    Examples:
      | email                |password |
      | haibeismail@gmail.com |Rmq8JEkUPPt6eES|

  Scenario Outline: Posts use case 3 : Create a new Post and Add it to favorites
    Given the user is on the main page of conduit
    When the user clicks on the button
    Then the user is redirected to the login page
    When the user fill his "<email>"
    And the user fill his password "<password>"
    And the user clicks on Sign in Button
    Then the user can log to his account
    When the user clicks on the button New Post
    Then the user is on the page of adding new post
    When the user fill all the fields
      |title      |Sed in molestie nunc|
      |subject    |Suspendisse lacinia nunc|
      |content    |Donec consequat suscipit diam, a scelerisque magna commodo vitae. Phasellus ultrices rhoncus urna, vitae pulvinar libero tincidunt non|
      |tags       |#Praesent #ipsum #ipsum|
    Then the user pusblishes the articles by clicking on the button
    And the user verifies that the post published
    When The user goes to his profile page
    And The user add his new post to his favorites "Sed in molestie nunc"
    And the user access to widget of favorited articles
    Then the user finds his new articles in the section of favorited articles
    Examples:
      | email                |password |
      | haibeismail@gmail.com |Rmq8JEkUPPt6eES|