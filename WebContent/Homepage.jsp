<jsp:include page="./head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
	<h2><s:property value="siteName" /></h2>
    <pre>Building...</pre>
	<ul>
		<li>
			<a href="<s:url action="article-detail.action">
						<s:param name="id" value="1"></s:param>
					</s:url>">test article</a>
		</li>
	</ul>
</body>
</html>