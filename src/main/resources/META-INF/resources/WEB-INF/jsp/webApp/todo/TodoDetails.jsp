<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" />
        <title>Add list</title>
    </head>
    
    <body>
        <div class="container">
            <h1>Enter Todo details</h1>
            <form:form method="post" modelAttribute="todo">
                <form:input type="hidden" path="id" />
                <form:input type="hidden" path="username" />
                Description: <form:input type="text" path="description" required="true" /><form:errors path="description" cssClass="text-warning"/>
                <form:input type="hidden" path="targetDate" />
                <form:input type="hidden" path="done" />
                <br>
                <input class="btn btn-success" type="submit" />
            </form:form>
        </div>

        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>