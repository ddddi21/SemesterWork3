<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2><a href="?lang=ru">RU</a> </h2>
<h2><a href="?lang=en">EN</a> </h2>
<div>
    <#--    <h1><@spring.message 'users.page.welcome'></@spring.message></h1>-->
        <table>
            <tr>
                <th>id</th>
                <th>email</th>
            </tr>
            <#list usersList as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                </tr>
            </#list>
        </table>
</div>
<form method="post" action="/banAll">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="<@spring.message 'all_user_page.banAll'></@spring.message>">
</form>
</body>
</html>



