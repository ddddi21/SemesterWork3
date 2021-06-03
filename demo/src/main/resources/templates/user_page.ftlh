<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- All the files that are required -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<!------ Include the above in your HEAD tag ---------->

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
<style>

    .navbar-brand { position: relative; z-index: 2; }

    .navbar-nav.navbar-right .btn { position: relative; z-index: 2; padding: 4px 20px; margin: 10px auto; }

    .navbar .navbar-collapse { position: relative; }
    .navbar .navbar-collapse .navbar-right > li:last-child { padding-left: 22px; }

    .navbar .nav-collapse { position: absolute; z-index: 1; top: 0; left: 0; right: 0; bottom: 0; margin: 0; padding-right: 120px; padding-left: 80px; width: 100%; }
    .navbar.navbar-default .nav-collapse { background-color: #f8f8f8; }
    .navbar.navbar-inverse .nav-collapse { background-color: #222; }
    .navbar .nav-collapse .navbar-form { border-width: 0; box-shadow: none; }
    .nav-collapse>li { float: right; }

    .btn.btn-circle { border-radius: 50px; }
    .btn.btn-outline { background-color: transparent; }

    @media screen and (max-width: 767px) {
        .navbar .navbar-collapse .navbar-right > li:last-child { padding-left: 15px; padding-right: 15px; }

        .navbar .nav-collapse { margin: 7.5px auto; padding: 0; }
        .navbar .nav-collapse .navbar-form { margin: 0; }
        .nav-collapse>li { float: none; }
    }
</style>
<body>
<#--<h2><a href="?lang=ru">RU</a> </h2>-->
<#--<h2><a href="?lang=en">EN</a> </h2>-->
<br>
<div class="container-fluid">
<!-- Second navbar for sign in -->
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">My Site</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
            <ul class="nav navbar-nav navbar-right">
<#--                <li><a href="/home"><@spring.message 'navbar.home'/></a></li>-->
                <li><a href="#"><@spring.message 'navbar.about'/></a></li>
                <li><a href="/profile"><@spring.message 'navbar.profile'/></a></li>
                <li><a href="/tasks"><@spring.message 'navbar.tasks'/></a></li>
                <li><a href="/createTask"><@spring.message 'navbar.create_task'/></a></li>
                <li><a href="?lang=ru"><@spring.message 'navbar.ru'/></a></li>
                <li><a href="?lang=en"><@spring.message 'navbar.en'/></a></li>
                <li><a href="/logout"><@spring.message 'navbar.logout'/></a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->
    <h3><@spring.message 'user_page.title'></@spring.message> ${userEmail}</h3>

</div><!-- /.container-fluid -->
    <#if imagepath?has_content>
        <img src="${imagepath}" class="m-x-auto img-fluid img-circle" alt="avatar" height="300" width="300">
    <#else>
        <img src="//placehold.it/150" class="m-x-auto img-fluid img-circle" alt="avatar" height="300" width="300">
    </#if>

    <#if message??>
        <h5> ${message} </h5>
    </#if>

    <div>
        <form method="POST" enctype="multipart/form-data" action="/upload">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <table>
                <tr><td><@spring.message 'user_page.fileToUpload'></@spring.message></td><td><input type="file" name="file" /></td></tr>
                <tr><td></td><td><input type="submit" value="<@spring.message 'user_page.upload'></@spring.message>" /></td></tr>
            </table>
        </form>
    </div>

<p>
    <a href="/editProfile"><@spring.message 'user_page.edit'></@spring.message></a>
<#--    <a href="/createTask"><@spring.message 'user_page.create_task'></@spring.message></a>-->
<#--    <a href="/tasks"><@spring.message 'user_page.all_tasks'></@spring.message></a>-->

</p>
<br><br><br>
<#--<div>-->
<#--    <form method="post" action="/room/${message.id}" class="form-inline">-->
<#--        <label>-->
<#--            <input type="text" class="form-control" value="${code!}" placeholder="Search by tag" />-->
<#--        </label>-->
<#--        <button type="submit" class="btn btn-primary ml-2">Search</button>-->
<#--    </form>-->
<#--</div>-->
<#--    <button type="button" class="btn"><a href="/editUser">Редактировать</a></button>-->
<#--    <div>-->
<#--        <h4>Your files:</h4>-->
<#--        <#list files as file>-->
<#--            <ul>-->
<#--                <li>-->
<#--                    <a href="${file}"> ${file}-->
<#--                </li>-->
<#--            </ul>-->
<#--        </#list>-->
<#--            <ul>-->
<#--                <li #each="file : ${files}">-->
<#--                    <a th:href="${file}" th:text="${file}" />-->
<#--                </li>-->
<#--            </ul>-->
<#--    </div>-->

<#--    <h1><@spring.message 'users.page.welcome'></@spring.message></h1>-->
<#--    <table>-->
<#--        <tr>-->
<#--            <th>id</th>-->
<#--            <th>email</th>-->
<#--        </tr>-->
<#--        <#list usersList as user>-->
<#--            <tr>-->
<#--                <td>${user.id}</td>-->
<#--                <td>${user.email}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--    </table>-->
</body>
</html>

