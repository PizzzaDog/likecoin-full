<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<table class="table">
<%--<thead class="thead-dark">--%>
<%--<tr>--%>
<%--    <th scope="col">Wallet ${myWallet.id}</th>--%>
<%--    <th scope="col">${myWallet.currency}</th>--%>
<%--    <th scope="col">Amount: ${myWallet.blocks.size()}</th>--%>
<%--    <th scope="col"></th>--%>
<%--</tr>--%>
<%--</thead>--%>
        <form class="form-check" action="/likecoin/wallet/${myWallet.id}/mining" method="post">
            <p>
                <label for="duration" class="sr-only">Please set duration of mining (seconds)</label>
                <input type="text" id="duration" name="duration" class="form-control" placeholder="Duration" required autofocus>
            </p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Start mining</button>
        </form>
</table>