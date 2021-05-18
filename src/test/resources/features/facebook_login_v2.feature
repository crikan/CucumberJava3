Feature: User's first contact with his Facebook profile
  As a lonely User
  In order to find new friends
  I want to login into Facebook

  """
  También me gustaría mostrarte cómo hubiera redactado este test si no hubiera contado con tus indicaciones.
  Yo habitualmente suelo utilizar el Given para situar la página de partida del test y así no tengo que indicarlo a cada paso
  La contra es que siempre debe haber un step que situe antes de que se usen los demás
  El Background realmente no era necesario pero suelo ponerlo por si hay que añadir más escenarios
  """

  Background:
    Given I navigate to the page "https://www.facebook.com/"
    And   I close the modal by pressing the "//button[@data-cookiebanner=\"accept_button\"]" element

  Scenario: Successful login in Facebook
    Given The login page has loaded
    When  I fill in "email" with "pepinillosolitario123@gmail.com"
    And   I fill in "pass" with "p3p1n1ll0"
    And   I click on "login" button
    Then  the element "//div[@aria-label=\"Cuenta\"]" is visible
    And   the page contains the text "Pepinillo, te damos la bienvenida a Facebook."

