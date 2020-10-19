<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Wallet ID</th>
        <th scope="col">Currency</th>
        <th scope="col">Amount</th>
        <th scope="col">
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${wallets}" var="wallet">
        <tr>
            <td scope="row">${wallet.id}</td>
            <td scope="row">${wallet.currency}</td>
            <td scope="row">${wallet.blocks.size()}</td>
            <td scope="row">
                <form class="form-inline my-2 " method="get" action="/likecoin/send_to/${recipientUserName}/from/${wallet.id}">
                    <button class="btn btn-outline-success" type="submit">Select</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>