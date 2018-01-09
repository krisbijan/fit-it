
function login (username, password){

    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
        console.log("code for modern browsers");
     } else {
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        console.log("code for old IE browsers");
    }
    
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
         document.getElementById("messages").innerHTML = this.responseText;
        }
      };

      xhttp.open("GET", "http://127.0.0.1:8080/users/"+username, true);
      xhttp.send();

    }



document.getElementById("submitButton").addEventListener("click",function(e){

    e.preventDefault();

    const username = document.getElementById("inputUsername").value;
    const password = document.getElementById("inputPassword").value;

    if (username != "" && username!=null && password != "" && password!=null)
        login (username, password);
});