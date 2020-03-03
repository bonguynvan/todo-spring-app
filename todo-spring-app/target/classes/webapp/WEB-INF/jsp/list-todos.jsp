<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <div><a href="/add-todo" class="btn btn-primary btn-md"></a></div>
</div>
<br>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3>List of Todo</h3>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
            <tr>
                <th width="40%">Description</th>
                <th width="40%">Target Date</th>
                <th width="20%"></th>
            </tr>
            </thead>
            <tbody>
            <c:foreach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/mm/yyyy"/></td>
                    <td><a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a>
                        <a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
                    </td>

                </tr>
            </c:foreach>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="common/footer.jspf"%>