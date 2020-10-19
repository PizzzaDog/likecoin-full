<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Wallet ${myWallet.id}</th>
        <th scope="col">${myWallet.currency}</th>
        <th scope="col">Amount: ${myWallet.blocks.size()}</th>
        <th scope="col"></th>
<%--        <th><form class="form-inline " method="get" action="/likecoin/wallet/delete/${myWallet.id}">--%>
<%--            <button class="btn btn-outline-success" type="submit">Delete wallet</button>--%>
<%--        </form>--%>
<%--        </th>--%>
        <th><form class="form-inline " method="get" action="/likecoin/wallet/${myWallet.id}/mining">
            <button class="btn btn-outline-success" type="submit">Start mining</button>
        </form>
        </th>
    </tr>
    </thead>
    <thead>
    <tr>
        <th scope="col">Transaction</th>
        <th scope="col">Amount</th>
        <th scope="col">Status</th>
        <th/>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allTransactions}" var="transaction">
        <tr>
            <td scope="row">${transaction.id}</td>
            <td scope="row">${transaction.amount}</td>
            <td scope="row">${transaction.status}</td>
            <td scope="row">
            <th><form class="form-inline " method="get" action="/likecoin/wallet/${myWallet.id}/transaction/${transaction.id}">
                <button class="btn btn-outline-success" type="submit">Details</button>
            </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>