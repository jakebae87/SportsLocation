<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <table class="table table-hover w-auto text-center">
        <thead>
            <tr>
                <th nowrap>번호</th>
                <th nowrap>현황</th>
                <th nowrap>구분</th>
                <th nowrap>대회명</th>
                <th nowrap>대회기간/참가신청 기간</th>
                <th nowrap>보기</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="game" items="${gameList}">
            <tr>
                <td>${game.number}</td>
                <td>${game.status}</td>
                <td nowrap>${game.type}</td>
                <td>${game.title}</td>
                <td width="250px">${game.period}</td>
                <td nowrap><a href="${game.detail}">자세히보기</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../layout/footer.jsp" %>

