<%--
  Created by IntelliJ IDEA.
  User: luhan
  Date: 2019/12/4
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<s:iterator value="cats">
    <s:property value="c_id"></s:property>
    <s:property value="c_name"></s:property>
</s:iterator>
</body>
</html>
