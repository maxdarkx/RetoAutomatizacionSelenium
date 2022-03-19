Feature: Registro de usuario
  Yo como usuario de la pagina
  Deseo registrar mis datos personales en la pagina
  Para hacer uso de todos sus servicios

  @Regresion
  Scenario: El usuario ingresa en el sistema todos sus datos personales validos
    Given que el usuario desea ingresar a la plataforma
    When el usuario ingresa en la plataforma su nombre, su apellido, su direccion, su ciudad de residencia, su Departamento su codigo zip, su numero de telefono, su identificacion y un nombre de usuario y contraseña
    Then se creara un nombre de usuario valido para que el usuario utilice la plataforma

