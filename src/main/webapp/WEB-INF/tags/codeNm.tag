<%-- --%>
<%-- // 출처: https://hsol.tistory.com/894 [한솔닷컴] --%>
<%-- // java 백엔드 단에서 ${maxpage}와 ${currentpage}  --%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="codes"         required="true" type="java.lang.String" rtexprvalue="true" %>
<%@ attribute name="key"          required="true" type="java.lang.String" rtexprvalue="true" %>
<%
    String[] arr1 = codes.split("\\|");
    
    String[] code = arr1[0].split(",");
    String[] codenm = arr1[1].split(",");
    
    int cnt = code.length;

	int index = 0;
	for (int i = 0; i < cnt; i++) {
		if (key.equals(code[i])) {
			index = i;
			break;
		}
	}
%>
<%= codenm[index] %>
	
	