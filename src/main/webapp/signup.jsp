<%-- 
    Document   : signUp
    Created on : Oct 18, 2024, 10:13:41 PM
    Author     : Macbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="css/mystyle.css">
        <script>
            function redirectToPage() {
                window.location.href = 'index.jsp';
            }
        </script>
    </head>
    <body class="login">
        <form class="form_signup">
            <h3>Sign up Here</h3>
            <label for="fullname">Full name</label>
            <input type="text" placeholder="fullname" id="fullname">

            <label for="email">Email</label>
            <input type="text" placeholder="Email" id="email">

            <label for="phone">Number phone</label>
            <input type="text" placeholder="phone" id="phone">

            <label for="username">Username</label>
            <input type="text" placeholder="Email or Phone" id="username">

            <label for="password">Password</label>
            <input type="password" placeholder="Password" id="password">

            <button>Sign up</button>
            <p style="margin-top: 15px">Do you have an account?<a href="login.jsp" class="nav-item nav-link">Login</a></p>
            <!--
                        <div class="social">
                            <div class="go"><i class="fab fa-google"></i>  Google</div>
                            <div class="fb"><i class="fab fa-facebook"></i>  Facebook</div>
                        </div>-->
            
            <div class="back">
            <button type="button"onclick="redirectToPage()" >Back</button>
</div>
        </form>
    </body>
</html>
