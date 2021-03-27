<!doctype html>
<html lang="en" >
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<h2><a href="?lang=ru">RU</a> </h2>
<h2><a href="?lang=en">EN</a> </h2>
<h1><@spring.message 'sign_up_page.title'></@spring.message></h1>
<form action="/signUp" method="post">
    <input name="email" type="email" placeholder="<@spring.message 'input_form.email'></@spring.message>">
    <input name="password" type="password" placeholder="<@spring.message 'input_form.password'></@spring.message>">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <input type="submit" value="<@spring.message 'input_form.enter'></@spring.message>">
</form>
</body>
</html>


