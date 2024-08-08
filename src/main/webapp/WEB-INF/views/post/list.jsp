<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/lib.jsp" %>
<%
    int total = jTemplate.queryForObject("SELECT COUNT(1) FROM `post` ", Integer.class);
    pageContext.setAttribute("total", total);
%>
<html>
<head>
	<title>Home</title>

</head>
<body>

    <div class="container">
        <div class="row">
            <h1>
                List! - 게시글 ${pageVO.total} 조회
            </h1>
        </div>


<p>&nbsp;<p>

<button data-page=1 class="nextgo" ${pageVO.firstGroupPage == false ? 'enabled': 'disabled'}>첫페이지</button>


            <button data-page=${pageVO.page - 1} class="nextgo"
            ${pageVO.firstGroupPage == false ? 'enabled': 'disabled'}>이전페이지</button>

<c:forEach var="num" begin="${pageVO.begin}" end="${pageVO.end}">
            <button data-page=${num} class="nextgo">${num}</button>
</c:forEach>
<c:if test="${!pageVO.lastGroupPage}">
            <button data-page=${pageVO.page + 1} class="nextgo">다음페이지</button>
</c:if>

<button data-page=${pageVO.lastPage} class="nextgo" ${pageVO.lastGroupPage == false ? 'enabled': 'disabled'}>마지막페이지</button>


        <div class="row">
            <input type="button" name="btnWrite" value="글작성"/>
            <input type="button" name="btnLogout" value="logout" class="btn btn-parimary"/>
            <ul id='post'>
                <c:forEach var="post" items="${posts}">
                    <li data-id="${post.id}">
                        <c:out value="${post.no}"/>
                        <c:out value="${post.title}"/> :: ${post.regDate}
                    </li>
                </c:forEach>

            </ul>
        </div>
    </div>

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
        location.href = '/post/view.do?postId=' + postId + '&page=${pageVO.page}';
    });

    $('[name="btnWrite"]').on('click', function() {
        location.href = '/post/write.do';
    });
    $('[name="btnLogout"]').on('click', function() {
        location.href = '/user/logout.do';
    });

    $('.nextgo').on('click', function() {
        var page = this.dataset.page;
        location.href = 'http://localhost:8080/post/list.do?page='+page;
    });
});
</script>
</body>
</html>