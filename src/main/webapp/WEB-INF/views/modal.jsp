<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>
<body>

<div id="myModal" class="modal">
  <form action="#">
      <div class="form-group">
        <label for="username">아이디</label>
        <input type="text" class="form-control" id="username" value="${principal.username}" readonly>
      </div>
      <div class="form-group">
        <label for="content">내용</label>
        <input type="text" class="form-control" id="content" placeholder="내용을 입력해주세요.">
      </div>
  </form>
      <button id="btn-map-write" class="btn btn-primary" >작성</button>
</div>

<script src="/javascript/map.js"></script>

</body>
</html>