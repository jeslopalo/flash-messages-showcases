<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="flash" uri="http://sandbox.es/tags/flash-messages" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Demo site</title>
    <link rel='stylesheet' id='all-css-0' href="resources/styles/application.css" type='text/css' media='all'/>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

</head>
<body>
<section class="container">
    <header class="page-header">
        <h1>Flash Messages Showcase
            <small>for spring mvc</small>
        </h1>
    </header>
    <div class="row">
        <div class="col-md-6">
            <p><a href="/demo/a">Controller A!</a> /a -R(m)-&gt; /b -R(m)-&gt; /d -F(m,m)-&gt; /home </p>

            <p><a href="/demo/b">Controller B!</a> /b -R(m)-&gt; /d -F(m,m)-&gt; /home </p>

            <p><a href="/demo/c">Controller C!</a> /c -R-&gt; /d -F(m,m)-&gt; /home </p>

            <p><a href="/demo/d">Controller D!</a> /d -F(m,m)-&gt; /home </p>

            <p><a href="/demo/e">Controller E!</a> /e -R(m,m,m,m)-&gt; /d -F(m,m)-&gt; /home </p>

            <p><a href="/demo/f">Controller F!</a> /f -R{m}-&gt; /c -R-&gt; /d -F(m,m)-&gt; /home </p>

            <p><a href="/demo/exception">Controller exception!</a> /exception -E(m)-&gt; @ExceptionHandler
                -F(m,m)-&gt; /home</p>

            <p><a href="/demo/global-exception">Global controller exception!</a> /global-exception -E(m)-&gt;
                @ExceptionHandler -F(m,m)-&gt; /home</p>
        </div>
        <div class="col-md-6">
            <flash:messages/>
        </div>
    </div>
</section>
</body>
</html>
