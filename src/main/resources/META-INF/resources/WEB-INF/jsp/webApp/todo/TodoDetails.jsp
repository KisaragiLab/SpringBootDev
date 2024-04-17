<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

<div class="container">
    <h1>Enter Todo details</h1>
    <form:form method="post" modelAttribute="todo">
        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="username" />

        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="true" />
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" />
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" path="completed" />
        <br>
        <input class="btn btn-success" type="submit" />
    </form:form>
</div>

<%@ include file="../common/footer.jspf" %>
     
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>