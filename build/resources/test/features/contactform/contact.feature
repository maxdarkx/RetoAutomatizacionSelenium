Feature: Contacto de Usuario
  Yo como usuario de la pagina
  Deseo enviar un mensaje a soporte
  para poner una queja

  @Regresion
  Scenario: El usuario ingresa en el sistema un nombre, telefono, email y mensaje validos
    Given que el usuario desea enviar un mensaje
    When el usuario ingresa en la plataforma un nombre, telefono, email y mensaje validos
    Then se muestra el mensaje de contacto

  @Regresion
  Scenario: El usuario ingresa en el sistema un email invalidos
    Given que el usuario desea enviar un mensaje pero no desea ingresar su email
    When el usuario ingresa en la plataforma un nombre, telefono y mensaje validos, y un email invalido
    Then se muestra un mensaje de error

  @Regresion
  Scenario: El usuario ingresa en el sistema un telefono invalido
    Given que el usuario desea enviar un mensaje pero no desea ingresar su telefono
    When el usuario ingresa en la plataforma un nombre, email y mensaje validos, y un telefono invalido
    Then se muestra un mensaje indicando telefono erroneo

  @Regresion
  Scenario: El usuario ingresa en el sistema un nombre invalido
    Given que el usuario desea enviar un mensaje pero no desea ingresar su nombre
    When el usuario ingresa en la plataforma un telefono, email y mensaje validos, y un nombre invalido
    Then se muestra un mensaje indicando nombre erroneo