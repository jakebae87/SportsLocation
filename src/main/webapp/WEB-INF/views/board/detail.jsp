<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <div>
        글번호: <span id="id"><i>${board.id} </i></span>
        작성자: <span><i>${board.user.username} </i></span>
    </div>

    <br/><br/>

    <div>
        <h3>${board.title}</h3>
    </div>
    <hr/>
    <div>
        <div>${board.content}</div>
    </div>
    <hr/>

    <br/><br/>

    <div>
        <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
        <c:if test="${board.user.id == principal.user.id}">
            <a href="/board/${board.id}/update" class="btn btn-warning">수정</a>
        </c:if>
        <c:if test="${board.user.id == principal.user.id}">
            <button class="btn btn-danger" id="btn-delete">삭제</button>
        </c:if>
    </div>
</div>

<script src="/javascript/board.js"></script>
<%@ include file="../layout/footer.jsp" %>

