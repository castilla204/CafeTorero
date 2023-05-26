var jq = jQuery.noConflict();

jq(document).ready(function() {
  jq.ajax({
    url: "login",
    method: "GET",
    dataType: "text",
    success: function(response) {
      if (response === "") {
        document.getElementById("btnLogin").style.display = "block";
        document.getElementById("btnUser").style.display = "none";
      } else {
        document.getElementById("btnLogin").style.display = "none";
        document.getElementById("btnUser").style.display = "block";
      }
    },
    error: function(xhr, status, error) {
      console.error("Error al realizar la petición AJAX:", error);
    }
  });
});

