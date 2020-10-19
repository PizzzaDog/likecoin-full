<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Transaction</th>
        <th scope="col">${transaction.id}</th>
        <th scope="col"></th>
        <th scope="col"></th>
<%--        <th><form class="form-inline " method="get" action="/likecoin/wallet/delete/${myWallet.id}">--%>
<%--            <button class="btn btn-outline-success" type="submit">Delete wallet</button>--%>
<%--        </form>--%>
<%--        </th>--%>
        <th/>

    </tr>
    </thead>
    <thead>
    <tr>
        <th scope="col">From</th>
        <th scope="col">To</th>
        <th scope="col">Amount</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td scope="row">${transaction.senderWalletId}</td>
            <td scope="row">${transaction.recipientWalletId}</td>
            <td scope="row">${transaction.amount}</td>
            <td scope="row">${transaction.status}</td>
        </tr>
    </tbody>
</table>