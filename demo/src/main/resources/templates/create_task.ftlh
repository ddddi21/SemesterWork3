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

    body {
        display: inline-block;
        padding-left: 200px;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form {
        width: 300px;
        padding: 32px;
        border-radius: 10px;
        box-shadow: 0 4px 16px #ccc;
        font-family: sans-serif;
        letter-spacing: 1px;
    }


    .form__input,
    .form__button {
        font-family: sans-serif;
        letter-spacing: 1px;
        font-size: 16px;
    }

    .form__title {
        text-align: center;
        margin: 0 0 32px 0;
        font-weight: normal;
    }

    .form__group {
        position: relative;
        margin-bottom: 32px;
    }
    .form__label {
        position: absolute;
        top: 0;
        left: 0;
        z-index: -1;
        color: #9e9e9e;
        transition: 0.3s;
    }

    .form__input {
        width: 100%;
        padding: 0 0 10px 0;
        border: none;
        border-bottom: 1px solid #e0e0e0;
        background-color: transparent;
        outline: none;
        transition: 0.3s;
    }

    .form__input:focus {
        border-bottom: 1px solid #1a73a8;
    }

    .from__button {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        color: #fff;
        background-color: #0071f0;
        outline: none;
        cursor: pointer;
        transition: 0.3s;
    }

    .form__button:focus,
    .form__button:hover {
        background-color: rgba(0, 113, 240, 0.7);
    }

    .form__input:focus ~ .form__label,
    .form__input:not(:placeholder-shown) ~ .form__label {
        top: -18px;
        font-size: 12px;
        color: #e0e0e0;
    }


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

</div><!-- /.container-fluid -->

<#if message??>
    <h5> ${message} </h5>
</#if>
<#if error??>
    <h5> ${error} </h5>
</#if>
<#--<div>-->
<#--    <form method="POST"  action="/createTask">-->
<#--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
<#--        <input name="text" type="text" placeholder="text" required>-->
<#--        &lt;#&ndash;            <input name="password" type="password" placeholder="<@spring.message 'input_form.password'></@spring.message>">&ndash;&gt;-->
<#--        &lt;#&ndash;            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">&ndash;&gt;-->
<#--        &lt;#&ndash;            <input type="checkbox" name = "rememberMe"> <@spring.message 'sign_in_page.rememberMe'></@spring.message><br>&ndash;&gt;-->
<#--        <input type="submit" value="<@spring.message 'input_form.enter'></@spring.message>">-->
<#--    </form>-->
<#--</div>-->
<br>
<div class="form_base">
    <form class="form" action="/createTask" method="POST">
        <h4 class="from__title">Task creating</h4> <br>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Tag:</label>
            <textarea name="title" class="form-control" id="exampleFormControlTextarea1" rows="1" required></textarea>
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Description:</label>
            <textarea name="text" class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
        </div>
        <br>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Deadline:</label>
            <input name="deadline" type="date" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default" required>  </div><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <#--        <div class="form-group">-->
        <#--            <label for="exampleFormControlTextarea1">Группа:</label>-->
        <#--            <input name="group" type="number" class="form-control" aria-label="Default"-->
        <#--                   aria-describedby="inputGroup-sizing-default">    </div><br>-->
        <button type="submit" class="from__button">Create</button>
        <p>
            <br><br>
                        <a href="/profile">
                            <button type="button" class="from__button">Back</button>
                        </a>
        </p>
    </form>
</div>

<p>
</p>
</body>
</html>

