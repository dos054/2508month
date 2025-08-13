<%@page import="study.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
ArrayList<Student> list = new ArrayList<>();
list.add(new Student("홍","서울","1234"));
list.add(new Student("감","인천","2323"));
list.add(new Student("별","대구","3434"));
list.add(new Student("전","부산","4545"));

request.setAttribute("list", list);
%>
<jsp:forward page="to2.jsp"/>
