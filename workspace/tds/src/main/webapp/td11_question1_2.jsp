<%@ page contentType="text/html; charset=UTF-8"%><%@ page pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <body>
        <h1 id="demo">C'est une démonstration</h1>
        <script>
            window.addEventListener("load", myFunction, false);
            function myFunction() {
                var xmlhttp;
                if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                }
                else {// code for IE6, IE5
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function() {
                    if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                        document.getElementById("demo").innerHTML=xmlhttp.responseText;
                    }
                }
                xmlhttp.open("GET","date.jsp",true);
                xmlhttp.send();
            }
        </script>
    </body>
</html>