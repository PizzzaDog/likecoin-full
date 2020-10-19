<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">From wallet</th>
        <th scope="col">To user</th>
        <th scope="col">Amount</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td scope="row">${senderWalletId}</td>
            <td scope="row">${recipientUserName}</td>
            <td scope="row">
                <form class="form-inline" method="post" action="/likecoin/send_to/${recipientUserName}/from_${senderWalletId}">
                    <input type="text" id="amount" name="amount" class="form-control" placeholder="Amount" required autofocus>
                    <input type="text" id="secretKey" name="secretKey" class="form-control" placeholder="Secret key" required autofocus>
                    <button class="btn btn-outline-success" type="submit">Send</button>
                </form>
            </td>
        </tr>
    </tbody>
</table>