<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="enc" uri="encryptTag" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<c:url value="./encryptTag.jsp" var="test">
<enc:encryptparam name="enparam">ranjan</enc:encryptparam>
</c:url>
<a href="${test}">hghgh</a>
<h2 align="center"><c:out value="${param.enparam}"/></h2>
</body>
</html>