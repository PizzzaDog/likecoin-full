<jsp:include page="header.jsp"/>
<div class="container">
<form class="form-signin" action="/likecoin/register" method="post">
        <h2 class="form-signin-heading" align="center">Please sign up</h2>
        <p>
            <label for="email" class="sr-only">Email</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>
        </p>
        <p>
            <label for="phone" class="sr-only">Phone number</label>
            <input type="tel" id="phone" name="phoneNumber" class="form-control" placeholder="Phone number" required autofocus>
        </p>
        <p>
            <label for="username" class="sr-only">Username</label>
            <input type="text" id="username" name="userName" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="userPassword" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
</div>