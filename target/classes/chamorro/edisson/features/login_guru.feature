Feature: Registrar nuevo custumer en guru99
  yo como aprendiz dd sophos academy
  Necesito iniciar sesión en la página guru
  Para validad que el mensaje de bienvenida sea correcto

  Scenario: Despues de logearme
    Given Dado que estoy en la url:"http://demo.guru99.com/V4/"
    When Ingreso datos de usuario
      | user     | mgr123 |
      | password | mgr!23 |
    Then Verifico el mensaje "Manajer Id: mgr123"
