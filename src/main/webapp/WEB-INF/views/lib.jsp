
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>

<%

	// spring bean 가져오는 방법
	WebApplicationContext ctx1 = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());

	JdbcTemplate jTemplate = (JdbcTemplate) ctx1.getBean("jdbcTemplate");

%>