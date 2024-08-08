<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
	.reply { display:inline-block; }
	.depth0 { width: 0px; }
	.depth1 { width: 30px; }
	.depth2 { width: 60px; }
	</style>
</head>
<body>
<h1>
	Review !
</h1>

<div class="container">
    <div class="row">
        <ul>
            <c:forEach var="comment" items="${comments}">
            <li data-id="${comment.id }">
                <span class="reply depth${comment.depth}"></span>
                ${comment.commentText} = ${comment.user[0].name} - ${comment.regDate }
                <p>
                <span class="reply depth${comment.depth}"></span>
                <input type="button" name="btnReply" data-comment="${comment.id}" value="답변 "/>
                <input type="button" name="btnDeleeComment" value="삭제 "/>
                </p>
                <p style="display: none;" id="${comment.id}">
                <textarea name="replayInput${comment.id}"></textarea>
                <input type="button" name="btnReplyAddComment"
                       data-comment="${comment.id}"
                       data-depth="${comment.depth}"
                       value="저장 "/>
                </p>
            </li>

            </c:forEach>
        </ul>
    </div>
    <hr/>
    <div class="row">
    <!-- contents -->

        <input type="hidden" name="postId" value="${postId}"/>
        <table>
            <tr>
                <td>
                    <textarea name="commentText" cols="80" rows="3"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="button" name="btnComment" value="리뷰작성"/>
                </td>
            </tr>
        </table>

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

    function loadData1() {
        // location.href = '/post/view.do?postId=${postId}';
        $('#commentList').load('/comment/list/${postId}');
    }
    $('[name="btnComment"]').click(function() {
        
        var comment = {
            commentText: $('[name="commentText"]').val(),
            postId: '${postId}'
        };

        $.ajax({
            type: "post",
            url: "/comment/insertProcess/${postId}",
            beforeSend: function(xhr) {
                xhr.setRequestHeader('method1', 'api')
            },
            data: JSON.stringify(comment),
            contentType: "application/json",
            success: function (response) {

               if (response.msg === 'NOT_LOGIN') {
            	   alert('로그인 후 리뷰 가능합니다');
                   $('[name="commentText"]').val('');
               } else {
            	   loadData1();
               }
            },
            error: function (xhr) {
                alert(xhr);
            }
        });
    });


    $('[name="btnDeleeComment"]').on('click', function() {
        var commentId = $(event.currentTarget).closest('li').data('id');
        var postId = $('[name="postId"]').val();
        $.ajax({
            type: "delete",
            url: "/comment/deleteProcess/"+ postId +"/" + commentId,
            beforeSend: function(xhr) {
                xhr.setRequestHeader('method1', 'api')
            },
            success: function (response) {
            	
            	if (response.msg === 'NOT_LOGIN') {
             	   alert('로그인 후 리뷰 가능합니다');
                    $('[name="commentText"]').val('');
                } else {
             	   loadData1();
                }
            }
        });
    });


    $('[name="btnReply"]').on('click', function() {
        // 답변
        var commentId = $(event.currentTarget).data('comment');
        $('#' + commentId).show(function() {
            $('[name="replayInput"]').val('');
        });
        debugger
    });

    $('[name="btnReplyAddComment"]').on('click', function() {

        var commentId = $(event.currentTarget).data('comment');
        var depth = $(event.currentTarget).data('depth');
        var strReply = $('[name="replayInput'+ commentId +'"]').val();

        if (strReply === '') return;

        var comment = {
            commentText: $('[name="replayInput'+ commentId +'"]').val(),
            postId: '${postId}',
            idRef: commentId,
            depth: Number(depth + 1)
        };

console.log(comment);

        $.ajax({
            type: "post",
            url: "/comment/insertProcess/${postId}",
            beforeSend: function(xhr) {
                xhr.setRequestHeader('method1', 'api')
            },
            data: JSON.stringify(comment),
            contentType: "application/json",
            success: function (response) {

               if (response.msg === 'NOT_LOGIN') {
            	   alert('로그인 후 리뷰 가능합니다');
                   $('[name="commentText"]').val('');
               } else {
            	   loadData1();
               }
            },
            error: function (xhr) {
                alert(xhr);
            }
        });

    });
});


</script>
</body>
</html>