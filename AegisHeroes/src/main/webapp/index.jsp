<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>

<h2>User Display Exercise:</h2>

<c:choose>
    <c:when test="${empty userName}">
        <a href = "Login">Log In</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
    </c:otherwise>
</c:choose>

<form action="searchUsers" class="form-inline">
    <div class="form-group">
        <label for="searchTerm"></label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</button>
</form>

</body>
</html>
