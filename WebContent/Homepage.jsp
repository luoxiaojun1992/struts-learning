<jsp:include page="./layout/head.jsp" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul>
	<s:iterator var="article" value="articles" status="statu">
		<li>
			<a href="<s:url action="article-detail.action">
				<s:param name="id" value="#article.id"></s:param>
			</s:url>" target="_blank"><s:property value="#article.title" /></a>
		</li>
	</s:iterator>
</ul>
<jsp:include page="./layout/foot.jsp" />