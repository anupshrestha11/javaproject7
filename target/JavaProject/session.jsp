<%
    HttpSession httpSession = request.getSession();
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate,no-reload");

    if (httpSession.getAttribute("Name") == null) {
        response.sendRedirect("/login.jsp");
    }
%>