<!doctype html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<#if message??>
    <h5> ${message} </h5>
</#if>

<div>
    <form method="POST" enctype="multipart/form-data" action="/upload">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <table>
            <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
            <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
        </table>
    </form>
</div>

<div>
    <h4>Your files:</h4>
    <#list files as file>
        <ul>
        <li>
            <a href="${file}"> ${file}
        </li>
        </ul>
    </#list>
<#--    <ul>-->
<#--        <li #each="file : ${files}">-->
<#--            <a th:href="${file}" th:text="${file}" />-->
<#--        </li>-->
<#--    </ul>-->
</div>

</body>
</html>