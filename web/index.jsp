<%-- 
    Document   : index
    Created on : Jun 21, 2016, 6:40:28 PM
    Author     : srihari
--%>

<%@page import="com.app.test.NewMain"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>

        <%
            NewMain tree = new NewMain();
//            System.out.println(session.getServletContext().getRealPath("/"));
            tree.init(session.getServletContext().getRealPath("/"));
            if (tree.counter < 5 && request.getParameter("node") == null) {
                tree.randomize();
            }
            
        %>

        <br/>

        <table>
            <tr>
                <td>
                    <a href="<c:url value="index.jsp">
                           <c:param name="node" value="left"/>
                       </c:url>">
                        <img src="<%= tree.getPath(tree.left)%>"/>
                    </a>
                </td>
                <td>
                    <a href="<c:url value="index.jsp">
                           <c:param name="node" value="right"/>
                       </c:url>">
                        <img src="<%= tree.getPath(tree.right)%>"/>
                    </a>
                </td>
            </tr>
            <tr>
                <td><center><%= tree.left %></center></td>
                <td><center><%= tree.right %></center></td>
            </tr>
        </table>
        <%
            tree.randomize(request.getParameter("node")=="left"?tree.left:tree.right);
        %>
    </body>
</html>
