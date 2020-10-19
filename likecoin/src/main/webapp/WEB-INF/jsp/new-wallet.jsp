<jsp:include page="header.jsp"/>
<div class="container">
    <form class="form-signin" action="/likecoin/wallet/createWallet" method="post">
        <h2 class="form-signin-heading" align="center">Please create wallet</h2>
        <p>
            <label for="currency" class="sr-only">Please select currency</label>
            <select class="form-control" name="currency" id="currency">
                <option >USD</option>
                <option>LIKECOIN</option>
            </select>
        </p>
        <p>
            <label for="secretKey" class="sr-only">Secret key for wallet</label>
            <input type="password" id="secretKey" name="secretKey" class="form-control" placeholder="Secret key" required autofocus>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
    </form>
</div>