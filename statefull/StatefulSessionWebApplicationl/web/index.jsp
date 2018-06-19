<%-- 
    Document   : index
    Created on : Apr 23, 2018, 2:22:49 AM
    Author     : Sachini
--%>

<%@page import="java.util.List"%>
<%@page import="ejb.ListElementsImpl"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="ejb.ListElementsRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private static ListElementsRemote values;

    public void jspInit()
    {
    try
    {
        InitialContext ic = new InitialContext();
        values = (ListElementsImpl)ic.lookup("java:global/StatefullSessionWebApplication/ListElementsImpl");
    }
    catch(Exception e)
    {
        System.out.println("error issss "+e);
    }
}
%>

<%
    if(request.getParameter("addNum")!=null)
    {
        int e = Integer.parseInt(request.getParameter("t1"));
        values.addElement(e);
    }
    if(request.getParameter("remNum")!=null)
    {
        int e = Integer.parseInt(request.getParameter("t1"));
        values.removeElement(e);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <form name="abc" method="post">
            <input type="text" name="t1"><br>
            <input type="submit" value="Add" name="addNum"><br>
            <input type="submit" value="Remove" name="remNum"><br>
            <%
                if(values!=null)
                {
                    List<Integer> nums = values.getElements();
                    for(int value:nums)
                    {
                        out.println("<br>" + value);
                    }
                    out.println("<br> size =" + nums.size());
                }
            %>
        </form>
    </body>
</html>
