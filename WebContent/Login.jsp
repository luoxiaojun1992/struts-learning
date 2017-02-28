<jsp:include page="./head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
<h2>Struts 2 - Login Application</h2>
<s:actionerror />
<s:form action="login.action" method="post">
    <s:textfield name="username" key="label.username" size="20" />
    <s:password name="password" key="label.password" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form>
</body>
</html>