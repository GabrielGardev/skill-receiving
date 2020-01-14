<%@ page import="metube.domain.models.view.AllTubesViewModel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<div class="container">
    <header>
        <c:import url="templates/navbar.jsp"/>
    </header>
    <main>
        <% List<AllTubesViewModel> tubes = (List<AllTubesViewModel>) request.getSession().getAttribute("tubes"); %>
        <hr class="my-2"/>
        <div class="text-center mt-3">
            <h4 class="h4 text-info">Welcome, <%= request.getSession().getAttribute("username") %></h4>
        </div>
        <hr class="my-4">
        <div class="container">
            <div class="row">
                <% for (int i = 0; i < tubes.size(); i++) { %>
                   <div class="col-md-4">
                        <iframe class="embed-responsive-item" allowfullscreen width="100%"
                                src="https://www.youtube.com/embed/<%=tubes.get(i).getYoutubeId()%>"></iframe>
                        <br/>
                        <h3 class="h3 text-center"> <%=tubes.get(i).getTitle() %></h3>
                        <h4 class="h4 text-center"> <%=tubes.get(i).getAuthor() %></h4>
                    </div>
               <% } %>
            </div>
        </div>
        <hr class="my-3"/>
    </main>
    <footer>
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
</body>
</html>
