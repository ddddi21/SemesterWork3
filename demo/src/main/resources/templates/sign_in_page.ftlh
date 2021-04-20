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
<h1><@spring.message 'sign_in_page.title'/></h1>
<#if error?has_content>
    <div class="reg-container">
        <p>Error: ${error}</p>
    </div>
<#else>
</#if>
<#if message??>
    <h5> ${message} </h5>
</#if>
<#if info?has_content>
    <div class="reg-container">
        <p>${info}</p>
    </div>
<#else>
</#if>
<form action="/signIn" method="post">
    <input name="email" type="email" placeholder="<@spring.message 'input_form.email'></@spring.message>">
    <input name="password" type="password" placeholder="<@spring.message 'input_form.password'></@spring.message>">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="checkbox" name = "rememberMe"> <@spring.message 'sign_in_page.rememberMe'></@spring.message><br>
    <input type="submit" value="<@spring.message 'input_form.enter'></@spring.message>">
</form>
</body>
</html>


