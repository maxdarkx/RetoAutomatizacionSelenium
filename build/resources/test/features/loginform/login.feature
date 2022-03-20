Feature:  Login de usuario
  Yo como usuario de la pagina
  Deseo ingresar a mi cuenta
  Para ver el resumen de mi cuenta

  @Regresion
  Scenario: El usuario ingresa en el sistema un nombre de usuario y contrasena validos
    Given que el usuario desea ingresar a su cuenta
    When el usuario ingresa en la plataforma un nombre de usuario y contrasena validos
    Then se muestra el resumen de la cuenta