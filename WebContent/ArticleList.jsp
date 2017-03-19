<jsp:include page="./layout/head.jsp" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Article List Component -->
<ul id="article-list">
  <li v-for="article in articles">
    <a v-bind:href="article.url" target="_blank">{{ article.title }}</a>
  </li>
</ul>

<!-- Pagination -->
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

<jsp:include page="./components/ArticleListComponent.jsp" />
<jsp:include page="./layout/foot.jsp" />