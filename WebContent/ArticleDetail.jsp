<jsp:include page="./head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
<h2><s:property value="title" /></h2>
<p><s:property value="user.name" /></p>
<pre><s:property value="content" /></pre>
</body>
</html>