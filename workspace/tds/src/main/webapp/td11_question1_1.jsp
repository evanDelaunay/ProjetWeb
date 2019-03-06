<%@ page contentType="text/html; charset=UTF-8"%><%@ page pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <body>
        <h1 id="demo">C'est une démonstration</h1>
        <script>
            window.addEventListener("load", myFunction, false);
                function myFunction() {
                var d = new Date();
                document.getElementById("demo").innerHTML=d.toLocaleTimeString();
            }
        </script>
    </body>
</html>