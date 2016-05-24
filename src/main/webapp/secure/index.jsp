<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Site A</title>
</head>
<body>
<%="Hello"%>
你登录了: site=<%= request.getContextPath() %> username=<%= request.getRemoteUser() %>
</body>
</body>
</html>