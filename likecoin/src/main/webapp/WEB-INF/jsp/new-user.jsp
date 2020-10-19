<jsp:include page="header.jsp"/>
<h1>Create new user:</h1>
<form action="/likecoin/new-user" method="post">
    <div class="form-group">
        <label for="formGroupExampleInput2">User name</label>
        <input type="text" class="form-control" name="userName" id="formGroupExampleInput1" placeholder="User name">
    </div>
    <div class="form-group">
        <label for="formGroupExampleInput2">passs</label>
        <input type="text" class="form-control" name="userPassword" id="formGroupExampleInput2" placeholder="User password">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
<%--    <select class="form-control" name="roles[0].roleName" id="role">--%>
<%--        <option>USER</option>--%>
<%--        <option>ADMIN</option>--%>
<%--    </select>--%>
    <div class="form-group">
        <label for="formGroupExampleInput2">Mobile phone</label>
        <input type="text" class="form-control" name="phoneNumber" id="formGroupExampleInput4" placeholder="Mobile phone">
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
</form>