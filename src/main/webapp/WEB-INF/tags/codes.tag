<%-- --%>
<%-- // 출처: https://hsol.tistory.com/894 [한솔닷컴] --%>
<%-- // java 백엔드 단에서 ${maxpage}와 ${currentpage}  --%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="codes"         required="true" type="java.lang.String" rtexprvalue="true" %>
<%@ attribute name="val"           required="false" type="java.lang.String" rtexprvalue="true" %>
<%@ attribute name="type"          required="false" type="java.lang.String" rtexprvalue="true" %>
<%@ attribute name="formId"            required="false" type="java.lang.String" rtexprvalue="true" %>
<%
    String[] arr1 = codes.split("\\|");
    
    String[] codes = arr1[0].split(",");
    String[] codenm = arr1[1].split(",");
    
    int cnt = codes.length;

    String selectVal = (val == null ? "" : val);

	switch (type) {
    	case "radio" :
%>
<%		for (int i = 0; i < cnt; i++) {  %>
	<label name="<%= formId %><%= i %>"><input type="radio" name="<%= formId %>" value="<%= codes[i] %>"><%= codenm[i] %></label>
<%		} %>
<%    	
    		break;
    	
    	default:
%>

<%		for (int i = 0; i < cnt; i++) {
            if (codes[i].equals(selectVal)) {
%>
	<option value="<%= codes[i] %>" selected><%= codenm[i] %></option>
<%		    } else { %>
	<option value="<%= codes[i] %>"><%= codenm[i] %></option>
<%		    }
        }
 %>

<%
    		break;
	}
%>



