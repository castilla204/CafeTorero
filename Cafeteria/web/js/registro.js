$(document).ready(function() {     // Capturar el evento de clic en el botón

    $('#botonregistro').click(function(event) {
      event.preventDefault(); // Prevenir el envío del formulario por defecto
      // Obtener los valores de los campos del formulario
      var usuario = $('#usuario').val();
      var email= $('#email').val();
      var contrasena = $('#contrasena').val();
      var ciudad = $('#ciudad').val();
      var direccion = $('#direccion').val();
  
      // Crear un objeto con los datos a enviar al backend Java
      var data = {
        usuario: usuario,
        email:email,
        contrasena:contrasena,
        ciudad:ciudad,
        direccion:direccion 
      };
  
      // Enviar los datos al backend Java utilizando AJAX
      $.ajax({
        url: 'registro', // Especifica la URL del backend Java
        type: 'POST', // Utiliza el método HTTP POST para enviar los datos
        data: JSON.stringify(data), // Convierte el objeto JavaScript a JSON
        contentType: 'application/json', // Especifica el tipo de contenido como JSON
        success: function(response) {
          // Maneja la respuesta del backend Java aquí
          console.log(response);
        },
        error: function(error) {
          // Maneja los errores de la solicitud aquí
          console.log(error);
        }
      });
    });
  });
  