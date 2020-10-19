<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<h1>Error:</h1>
<h1>${errorMessage}</h1>
<form class="form-inline my-2 " method="get" action="${redirectLink}">
    <button type="submit">Redirect</button>
</form>