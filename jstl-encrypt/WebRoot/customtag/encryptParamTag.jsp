<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="encparam" uri="encryptParamTag" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<c:url value="./encryptParamTag.jsp" var="test">
<encparam:encryptparam name="enparam">ranjan</encparam:encryptparam>
</c:url>
<a href="${test}">hghgh</a>
<h2 align="center"><c:out value="${param.enparam}"/></h2>
</body>
</html>