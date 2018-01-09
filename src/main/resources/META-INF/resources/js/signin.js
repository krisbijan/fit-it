
function login (username, password){

    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
     } else {
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
         document.getElementById("messages").innerHTML = this.responseText;
        }
      };

      xhttp.open("GET", "http://localhost:8080/users/"+username, true);
      xhttp.send();

    }

document.getElementById("submitButton").addEventListener("click",function(e){
    document.getElementById("messages").innerHTML = "";

    e.preventDefault();

    const username = document.getElementById("inputUsername").value;
    const password = document.getElementById("inputPassword").value;

    if (username != "" && username!=null && password != "" && password!=null)
        login (username, password);

    return false;
});