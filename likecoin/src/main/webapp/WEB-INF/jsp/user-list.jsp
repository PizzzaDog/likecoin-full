<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Username</th>
        <th scope="col">Email</th>
        <th scope="col">Mobile Phone</th>
        <th scope="col"/>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td scope="row">${user.id}</td>
                <td scope="row">${user.userName}</td>
                <td scope="row">${user.email}</td>
                <td scope="row">${user.phoneNumber}</td>
                <td scope="row">
                    <form class="form-inline my-2 " method="get" action="/likecoin/send_to/${user.userName}">
                        <button class="btn btn-outline-success" type="submit">Send coins</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>