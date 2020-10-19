<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>

<h1>Your wallets:</h1>

<table class="table">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Wallet ID</th>
            <th scope="col">Currency</th>
            <th scope="col">Amount</th>
            <th scope="col">
                <form class="form-inline" method="get" action="/likecoin/wallet/createWallet">
                    <button class="btn btn-outline-success" type="submit">Create wallet</button>
                </form>
            </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${myWalletList}" var="user">
        <tr>
            <td scope="row">${user.id}</td>
            <td scope="row">${user.currency}</td>
            <td scope="row">${user.blocks.size()}</td>
            <td scope="row">
                <form class="form-inline my-2 " method="get" action="/likecoin/wallet/${user.id}">
                    <button class="btn btn-outline-success" type="submit">Details</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>