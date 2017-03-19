<jsp:include page="./layout/head.jsp" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Article List Component -->
<ul id="article-list">
  <li v-for="article in articles">
    <a v-bind:href="article.url" target="_blank">{{ article.title }}</a>
  </li>
</ul>

<a href="<s:url action="article-list.action">
				<s:param name="page" value="1"></s:param>
			</s:url>" target="_blank">更多...</a>

<jsp:include page="./components/ArticleListComponent.jsp" />			
<jsp:include page="./layout/foot.jsp" />