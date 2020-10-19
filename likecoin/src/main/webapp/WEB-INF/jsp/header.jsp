<!doctype html>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Likecoin</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/likecoin/home">Likecoin</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <sec:authorize access="isAuthenticated()">
            <li class="nav-item">
                <a class="nav-link" href="/likecoin/users/all">Send coins</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/likecoin/wallets_list">My wallets</a>
            </li>
<%--            <li class="nav-item dropdown">--%>
<%--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                    Recipients--%>
<%--                </a>--%>
<%--                <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                    <a class="dropdown-item" href="#">New Recipient</a>--%>
<%--                    <a class="dropdown-item" href="#">Edit Recipient</a>--%>
<%--                    <div class="dropdown-divider"></div>--%>
<%--                    <a class="dropdown-item" href="#">Delete Recipient</a>--%>
<%--                </div>--%>
<%--            </li>--%>

<%--            <li class="nav-item">--%>
<%--                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
<%--            </li>--%>
                <li class="nav-item">
                    <a class="nav-link" href="/likecoin/start_mining">Start mining</a>
                </li>
            </sec:authorize>
        </ul>
        <sec:authorize access="isAuthenticated()">
        <form class="form-inline my-2 mr-2" action="/likecoin/users/search">
            <input class="form-control mr-sm-2" type="search" name="searchQuery" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
        <ul class="navbar-nav">
            <form class="form-inline my-2 mx-1" method="get" action="/likecoin/register" >
            <button class="btn btn-outline-success "  type="submit">Sign up</button>
            </form>
            <form class="form-inline my-2 " method="get" action="/likecoin/login">
                <button class="btn btn-outline-success" type="submit">Sign in</button>
            </form>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <form class="form-inline my-2 " method="get" action="/likecoin/logout" >
                        <button class="btn btn-outline-success my-2 my-sm-0"  type="submit">Logout</button>
                </form>
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"><sec:authentication property="principal.username"/></a>
            </sec:authorize>
        </ul>
    </div>
</nav>