<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
//Article List Component
var articleList = new Vue({
	  el: '#article-list',
	  data: {
		articles: [
	    	<s:iterator var="article" value="articles" status="statu">
	    		{ 
	    			id: '<s:property value="#article.id" />', 
	    			title: '<s:property value="#article.title" />',
	    			url: '<s:url action="article-detail.action"><s:param name="id" value="#article.id"></s:param></s:url>'
	    		}
	    	</s:iterator>
	    ]
	  }
	});
</script>