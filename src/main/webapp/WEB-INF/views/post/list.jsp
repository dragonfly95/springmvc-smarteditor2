<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>

</head>
<body>
<h1>
	List!
</h1>

    <input type="button" name="btnWrite" value="글작성"/>
    <ul id='post'>
        <c:forEach var="post" items="${posts}">
            <li data-id="${post.id}">
                <c:out value="${post.title}"/> :: ${post.regDate}
            </li>
        </c:forEach>

    </ul>


<link href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/blog/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script>
$(document).ready(function () {
    $('#post li').on('click', function() {
        var postId = $(event.currentTarget).data('id');
        location.href = '/post/view.do?postId=' + postId;
    });

    $('[name="btnWrite"]').on('click', function() {
        location.href = '/post/write.do';
    });
});
</script>
</body>
</html>