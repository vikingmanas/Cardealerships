<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Premium Auto</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        body { background: linear-gradient(135deg, #f7f9fc 0%, #e2e8f0 100%); min-height: 100vh; display: flex; flex-direction: column; }
        .auth-container { flex-grow: 1; display: flex; align-items: center; justify-content: center; }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">🚗 Premium Auto</a>
            <div class="ms-auto"><a class="nav-link text-white d-inline" href="${pageContext.request.contextPath}/jsp/index.jsp">Register Here</a></div>
        </div>
    </nav>
    <div class="container auth-container">
        <div class="col-md-6 col-lg-4">
            <div class="auth-card shadow-lg">
                <h2 class="text-center mb-4 fw-bold">Sign In</h2>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger shadow-sm">${error}</div>
                </c:if>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div class="mb-3">
                        <label class="form-label text-muted fw-bold">Username</label>
                        <input type="text" class="form-control" name="username" required placeholder="Enter username">
                    </div>
                    <div class="mb-4">
                        <label class="form-label text-muted fw-bold">Password</label>
                        <input type="password" class="form-control" name="password" required placeholder="Enter password">
                    </div>
                    <button type="submit" class="btn btn-primary w-100 fw-bold text-white shadow-sm" style="font-size: 1.1rem;">Login</button>
                    <div class="text-center mt-4">
                        <small class="text-muted">Don't have an account? <a href="${pageContext.request.contextPath}/jsp/index.jsp" class="fw-bold">Register here</a></small>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
