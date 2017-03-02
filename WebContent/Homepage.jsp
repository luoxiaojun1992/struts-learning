<jsp:include page="./head.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
	<h2><s:property value="siteName" /></h2>
    <pre>Building...</pre>
	<ul>
	    <s:iterator var="article" value="articles" status="statu">
	        <li>
		        <a href="<s:url action="article-detail.action">
					<s:param name="id" value="#article.id"></s:param>
				</s:url>" target="_blank"><s:property value="#article.title" /></a>
			</li>
		</s:iterator>
	</ul>
	<footer>Powered by Xiaojun Luo</footer>
</body>
</html>