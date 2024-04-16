<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

<div class="container">
    <h1>Login to your account</h1>
    <pre>${errorMessage}</pre>
    <form method="post">
        <label for="usernameLabel">Username:</label>
        <input type="text" id="username" name="username" value=${username} required><br>
        <label for="passwordLabel">Password:</label>
        <input type="password" id="password" name="password" value=${password} required><br>
        <input type="submit" value="Submit">
    </form>
</div>

<%@ include file="../common/footer.jspf" %>