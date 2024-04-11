<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <title>Todo list</title>
    </head>
    
    <body>
        <h1>Welcome, ${username}</h1>
        Your todos are ${todos}
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Target date</th>
                    <th>Completed</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>