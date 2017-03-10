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
<nav aria-label="...">
  <ul class="pager">
    <li><a href="<s:url action="article-list.action">
				<s:param name="page" value="prevPageNum"></s:param>
			</s:url>">Previous</a></li>
	<li><s:property value="page" /></li>
    <li><a href="<s:url action="article-list.action">
				<s:param name="page" value="nextPageNum"></s:param>
			</s:url>">Next</a></li>
  </ul>
</nav>
<jsp:include page="./layout/foot.jsp" />