<jsp:include page="./layout/head.jsp" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container-fluid">
	<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
		<div class="page-header">
	  		<h1><s:property value="article.title" /></h1>
		</div>
		<div><s:property value="article.content" escapeHtml="false" /></div>
	</div>
</div>
<jsp:include page="./layout/foot.jsp" />