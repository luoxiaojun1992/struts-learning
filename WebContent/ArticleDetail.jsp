<jsp:include page="./layout/head.jsp" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2><s:property value="article.title" /></h2>
<pre><s:property value="article.content" /></pre>
<jsp:include page="./layout/foot.jsp" />