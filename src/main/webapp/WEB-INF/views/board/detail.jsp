<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <label for="title">제목</label>
            <h3>${board.title}</h3>
        </div>

       <div class="form-group">
            <label for="content">내용</label>
            <div>
                ${board.content}
            </div>
       </div>

    </form>
    <button id="btn-board-write" class="btn btn-primary">작성</button>
</div>

<script src="/javascript/board.js"></script>
<%@ include file="../layout/footer.jsp" %>

