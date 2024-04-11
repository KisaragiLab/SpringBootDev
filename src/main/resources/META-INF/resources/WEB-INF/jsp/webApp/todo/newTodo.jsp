<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" />
        <title>Add list</title>
    </head>
    
    <body>
        <div class="container">
            <h1>Enter Todo details</h1>
            <form method="post">
                Description: <input type="text" name="description" />
                <input class="btn btn-success" type="submit" />
            </form>
        </div>

        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>