<html>
    <head>
        <title>Login</title>
    </head>
    
    <body>
        <h1>Login to your account</h1>
        <pre>${errorMessage}</pre>
        <form method="post">
            <label for="usernameLabel">Username:</label>
            <input type="text" id="username" name="username" value=${username}><br>
            <label for="passwordLabel">Password:</label>
            <input type="password" id="password" name="password" value=${password}><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>