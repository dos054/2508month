<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
</head>
<body>

        <form action="member_update.jsp" method="post">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id" readonly
                               value="${sessionScope.member.id }"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="pw" 
                               value="${sessionScope.member.pw }"></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" 
                               value="${sessionScope.member.name }"></td>
                </tr>
            </table>    
            <input type="submit" value="저장"> 
        </form>
<p>사용자 이름: ${sessionScope.member}</p>
  <p>세션 ID: ${pageContext.session.id}</p>
</body>
</html>