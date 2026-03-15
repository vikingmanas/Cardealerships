<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Premium Auto Dealer</title>
    <!-- Use Bootstrap and Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Load custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">🚗 Premium Auto</a>
            <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarNav">
                <ul class="navbar-nav ms-auto float-end">
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            <li class="nav-item">
                                <span class="nav-link">Welcome, <strong>${sessionScope.user.username}</strong> <span class="badge bg-secondary ms-1 text-uppercase">${sessionScope.user.role}</span></span>
                            </li>
                            <li class="nav-item ms-3">
                                <a class="nav-link btn btn-sm btn-outline-light text-white" href="${pageContext.request.contextPath}/logout">Logout</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                            </li>
                            <li class="nav-item ms-2">
                                <a class="nav-link btn btn-sm btn-light text-primary fw-bold" href="${pageContext.request.contextPath}/jsp/index.jsp">Register</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <div class="hero">
        <div class="container">
            <h1>Find Your Dream Car Today</h1>
            <p>Explore thousands of cars with competitive pricing and verified dealers.</p>
        </div>
    </div>

    <!-- Main Content -->
    <div class="container pb-5">
        
        <!-- Dealer Panel -->
        <c:if test="${sessionScope.user.role == 'dealer'}">
            <div class="dealer-panel shadow-sm">
                <h4 class="mb-3">Add New Inventory</h4>
                <form action="${pageContext.request.contextPath}/car" method="post" class="row g-3">
                    <div class="col-md-3">
                        <input type="text" class="form-control" name="make" placeholder="Make (e.g., Toyota)" required>
                    </div>
                    <div class="col-md-3">
                        <input type="text" class="form-control" name="model" placeholder="Model (e.g., Camry)" required>
                    </div>
                    <div class="col-md-2">
                        <input type="number" class="form-control" name="year" placeholder="Year" required min="1900" max="2100">
                    </div>
                    <div class="col-md-2">
                        <input type="number" step="0.01" class="form-control" name="price" placeholder="Price ($)" required min="0">
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-success w-100 text-white shadow-sm fw-bold">+ Add Car</button>
                    </div>
                </form>
            </div>
        </c:if>

        <h2 class="mb-4">Available Cars <span class="badge bg-primary rounded-pill fs-5">${cars.size()}</span></h2>
        <div class="row">
            <c:forEach var="car" items="${cars}">
                <div class="col-md-4">
                    <div class="car-card">
                        <div class="car-header d-flex justify-content-between">
                            <span>${car.make}</span>
                            <span>${car.year}</span>
                        </div>
                        <div class="car-body">
                            <h4 class="fw-bold">${car.model}</h4>
                            <div class="car-price mt-3">$${car.price}</div>
                            <c:if test="${sessionScope.user.role == 'buyer'}">
                                <button class="btn btn-success w-100 mt-2 shadow-sm text-white fw-bold">Contact Dealer</button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <c:if test="${empty cars}">
                <div class="col-12 text-center text-muted py-5">
                    <p class="fs-4">No cars available at the moment. Check back later!</p>
                </div>
            </c:if>
        </div>
    </div>
</body>
</html>
