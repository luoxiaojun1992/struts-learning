<jsp:include page="./layout/head.jsp" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:actionerror />
<s:form action="login-submit.action" method="post">
    <s:textfield name="username" key="label.username" size="20" />
    <s:password name="password" key="label.password" size="20" />
    <s:token name="login-submit.token" />
    <s:submit method="submit" key="label.login" align="center" />
</s:form>
<jsp:include page="./layout/foot.jsp" />