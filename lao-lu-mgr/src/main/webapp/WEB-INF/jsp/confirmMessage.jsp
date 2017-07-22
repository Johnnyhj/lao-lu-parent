<%--
  Created by IntelliJ IDEA.
  User: jinlu
  Date: 2016/5/13
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>确认消息</title>
</head>
<body>
  <c:if test="${not empty msg}">

    <c:choose>
      <c:when test="${not empty code}">
          <c:if test="${0 eq code}">
             <div class="alert alert-success alert-dismissible" role="alert">
          </c:if>

          <c:if test="${0 ne code}">
            <div class="alert alert-success alert-dismissible" role="alert" style="background-color: palevioletred;">
          </c:if>
      </c:when>
      <c:otherwise>
              <div class="alert alert-success alert-dismissible" role="alert">
      </c:otherwise>
  </c:choose>


      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
      <strong>${msg}</strong>
    </div>
  </c:if>
</body>
</html>
