<jsp:include page="header.jsp"/>
<form class="form-signin" action="/likecoin/init" method="post">
    <h2 class="form-signin-heading" align="center">Please sign up</h2>
    <p>
        <label for="initPassword" class="sr-only">Init password</label>
        <input type="password" id="initPassword" name="initPassword" class="form-control" placeholder="Root password" required>
    </p>
    <p>
        <label for="adminPassword" class="sr-only">Create admin password</label>
        <input type="password" id="adminPassword" name="adminPassword" class="form-control" placeholder="Password for admin" required>
    </p>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>