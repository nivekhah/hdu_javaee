<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>购物页面</title>
</head>
<body>
	<form action="" method="post" name="form">
	这里是调料柜台，请选择要购买的调料：<br />
	<input type="checkbox" name="sec" value="猪肉" />猪肉<br />
	<input type="checkbox" name="sec" value="牛肉" />牛肉<br />
	<input type="checkbox" name="sec" value="羊肉" />羊肉<br />
	<input type="submit" name="gouwu" value="提交">
	<br />
	<br />
	<a href="shocart.jsp">买点别的</a>
	<a href="lookShopCart.jsp">查看购物车！</a>
	<%
	request.setCharacterEncoding("GB2312");
	String sec[] = request.getParameterValues("sec");
	if (sec!=null && sec.length!= 0) {
	for (int i=0;i<sec.length;i++) {
		session.setAttribute(sec[i],sec[i]);
	}
	}	
			%>
</body>
</html>