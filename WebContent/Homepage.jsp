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
<a href="<s:url action="article-list.action">
				<s:param name="page" value="1"></s:param>
			</s:url>" target="_blank">更多...</a>

<ul id="example-1">
  <li v-for="item in items">
    {{ item.message }}
  </li>
</ul>

<script>
var example1 = new Vue({
	  el: '#example-1',
	  data: {
	    items: [
	      { message: 'Foo' },
	      { message: 'Bar' }
	    ]
	  }
	});
</script>
			
<jsp:include page="./layout/foot.jsp" />