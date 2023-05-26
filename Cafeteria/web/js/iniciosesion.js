var jq = jQuery.noConflict();

jq(document).ready(function() {
    // Capturar el evento de clic en el botón
    jq('#botonlogin').click(function(event) {
      event.preventDefault(); // Prevenir el envío del formulario por defecto
  
      // Obtener los valores de los campos del formulario
      var usuario = jq('#usuario').val();
      var contrasena = jq('#contrasena').val();
  
      // Crear un objeto con los datos de inicio de sesión a enviar al backend Java
      var data = {
        usuario: usuario,
        contrasena: contrasena
      };
  
      // Enviar los datos al backend Java utilizando AJAX
      jq.ajax({
        url: 'login', // Especifica la URL del backend Java
        type: 'POST', // Utiliza el método HTTP POST para enviar los datos
        data: JSON.stringify(data), // Convierte el objeto JavaScript a JSON
        contentType: 'application/json', // Especifica el tipo de contenido como JSON
        success: function(response) {
          if(response.loginSuccessful){
              window.location.href = "/Cafeteria/";
          }
          else{
              jq('#errorMessage').text(response.loginMessage);
              jq("#errorMessage").show();
          }
        },
        error: function(error) {
          // Maneja los errores de la solicitud aquí
          console.log(error);
        }
      });
    });
  });