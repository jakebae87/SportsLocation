<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Enter title" id="title">
        </div>

       <div class="form-group">
            <textarea class="form-control summernote" rows="5" id="content"></textarea>
       </div>

    </form>
    <button id="btn-board-write" class="btn btn-primary">작성</button>
</div>

<script>
    $('.summernote').summernote({
        tabsize: 2,
        height: 200
    });
</script>

<script src="/javascript/board.js"></script>
<%@ include file="../layout/footer.jsp" %>

