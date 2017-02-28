<jsp:include page="./head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
<h2><s:property value="article.title" /></h2>
<pre><s:property value="article.content" /></pre>
</body>
</html>