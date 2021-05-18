
Feature: User's first contact with his Facebook profile
  As a lonely User
  In order to find new friends
  I want to login into Facebook

  """

  Este test no funciona
  He querido recrear de la manera más fiel posible el escenario de tu ejemplo aunque no he logrado hacerlo rodar
  Es posible que no acabe de entender este forma de definir del todo
  También creo que la carga de la url a cada paso es algo innecesaria.
  Implica que se recargue la página, haya que volver a
  aceptar las cookies y borra lo introducido en el paso anterior
  """

  Background:
    Given I navigate to the page "https://www.facebook.com/"
    And   I close the modal by pressing the "//button[@data-cookiebanner=\"accept_button\"]" element


  @Logintest
  Scenario: Successful login in Facebook
    Given a registered user
    When  at endpoint "https://www.facebook.com/", into input field "mail", insert the value "pepinillosolitario123@gmail.com"
    And   at endpoint "https://www.facebook.com/", into input field "pass", insert the value "p3p1n1ll0"
    And   at endpoint "https://www.facebook.com/", click on "login" button
    Then  at endpoint "https://www.facebook.com/", the element "//div[@aria-label=\"Cuenta\"]" is visible
    And  the page contains the text "Pepinillo, te damos la bienvenida a Facebook."
