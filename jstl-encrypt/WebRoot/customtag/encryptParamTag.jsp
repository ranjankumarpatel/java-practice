<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="encparam" uri="encryptParamTag" %>
<%@ taglib uri="encryptTag" prefix="enc" %>
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
<h2 align="center">Decrypted: <enc:decrypt value="${param.enparam}"></enc:decrypt></h2>
</body>
</html>