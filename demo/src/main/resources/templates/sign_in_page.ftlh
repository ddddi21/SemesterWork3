
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- All the files that are required -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

<!doctype html>
<html lang="en" >
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Bootstrap CSS -->
</head>
<style>
    /*=== 1. General Structure ===*/
    html,
    body {
        background: #efefef;
        padding: 10px;
        font-family: 'Varela Round';
    }
    /*=== 2. Anchor Link ===*/
    a {
        color: #aaaaaa;
        transition: all ease-in-out 200ms;
    }
    a:hover {
        color: #333333;
        text-decoration: none;
    }
    /*=== 3. Text Outside the Box ===*/
    .etc-login-form {
        color: #919191;
        padding: 10px 20px;
    }
    .etc-login-form p {
        margin-bottom: 5px;
    }
    /*=== 4. Main Form ===*/
    .login-form-1 {
        max-width: 300px;
        border-radius: 5px;
        display: inline-block;
    }
    .main-login-form {
        position: relative;
    }
    .login-form-1 .form-control {
        border: 0;
        box-shadow: 0 0 0;
        border-radius: 0;
        background: transparent;
        color: #555555;
        padding: 7px 0;
        font-weight: bold;
        height:auto;
    }
    .login-form-1 .form-control::-webkit-input-placeholder {
        color: #999999;
    }
    .login-form-1 .form-control:-moz-placeholder,
    .login-form-1 .form-control::-moz-placeholder,
    .login-form-1 .form-control:-ms-input-placeholder {
        color: #999999;
    }
    .login-form-1 .form-group {
        margin-bottom: 0;
        border-bottom: 2px solid #efefef;
        padding-right: 20px;
        position: relative;
    }
    .login-form-1 .form-group:last-child {
        border-bottom: 0;
    }
    .login-group {
        background: #ffffff;
        color: #999999;
        border-radius: 8px;
        padding: 10px 20px;
    }
    .login-group-checkbox {
        padding: 5px 0;
    }
    /*=== 5. Login Button ===*/
    .login-form-1 .login-button {
        position: absolute;
        right: -25px;
        top: 50%;
        background: #ffffff;
        color: #999999;
        padding: 11px 0;
        width: 50px;
        height: 50px;
        margin-top: -25px;
        border: 5px solid #efefef;
        border-radius: 50%;
        transition: all ease-in-out 500ms;
    }
    .login-form-1 .login-button:hover {
        color: #555555;
        transform: rotate(450deg);
    }
    .login-form-1 .login-button.clicked {
        color: #555555;
    }
    .login-form-1 .login-button.clicked:hover {
        transform: none;
    }
    .login-form-1 .login-button.clicked.success {
        color: #2ecc71;
    }
    .login-form-1 .login-button.clicked.error {
        color: #e74c3c;
    }
    /*=== 6. Form Invalid ===*/
    label.form-invalid {
        position: absolute;
        top: 0;
        right: 0;
        z-index: 5;
        display: block;
        margin-top: -25px;
        padding: 7px 9px;
        background: #777777;
        color: #ffffff;
        border-radius: 5px;
        font-weight: bold;
        font-size: 11px;
    }
    label.form-invalid:after {
        top: 100%;
        right: 10px;
        border: solid transparent;
        content: " ";
        height: 0;
        width: 0;
        position: absolute;
        pointer-events: none;
        border-color: transparent;
        border-top-color: #777777;
        border-width: 6px;
    }
    /*=== 7. Form - Main Message ===*/
    .login-form-main-message {
        background: #ffffff;
        color: #999999;
        border-left: 3px solid transparent;
        border-radius: 3px;
        margin-bottom: 8px;
        font-weight: bold;
        height: 0;
        padding: 0 20px 0 17px;
        opacity: 0;
        transition: all ease-in-out 200ms;
    }
    .login-form-main-message.show {
        height: auto;
        opacity: 1;
        padding: 10px 20px 10px 17px;
    }
    .login-form-main-message.success {
        border-left-color: #2ecc71;
    }
    .login-form-main-message.error {
        border-left-color: #e74c3c;
    }
    /*=== 8. Custom Checkbox & Radio ===*/
    /* Base for label styling */
    [type="checkbox"]:not(:checked),
    [type="checkbox"]:checked,
    [type="radio"]:not(:checked),
    [type="radio"]:checked {
        position: absolute;
        left: -9999px;
    }
    [type="checkbox"]:not(:checked) + label,
    [type="checkbox"]:checked + label,
    [type="radio"]:not(:checked) + label,
    [type="radio"]:checked + label {
        position: relative;
        padding-left: 25px;
        padding-top: 1px;
        cursor: pointer;
    }
    /* checkbox aspect */
    [type="checkbox"]:not(:checked) + label:before,
    [type="checkbox"]:checked + label:before,
    [type="radio"]:not(:checked) + label:before,
    [type="radio"]:checked + label:before {
        content: '';
        position: absolute;
        left: 0;
        top: 2px;
        width: 17px;
        height: 17px;
        border: 0px solid #aaa;
        background: #f0f0f0;
        border-radius: 3px;
        box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3);
    }
    /* checked mark aspect */
    [type="checkbox"]:not(:checked) + label:after,
    [type="checkbox"]:checked + label:after,
    [type="radio"]:not(:checked) + label:after,
    [type="radio"]:checked + label:after {
        position: absolute;
        color: #555555;
        transition: all .2s;
    }
    /* checked mark aspect changes */
    [type="checkbox"]:not(:checked) + label:after,
    [type="radio"]:not(:checked) + label:after {
        opacity: 0;
        transform: scale(0);
    }
    [type="checkbox"]:checked + label:after,
    [type="radio"]:checked + label:after {
        opacity: 1;
        transform: scale(1);
    }
    /* disabled checkbox */
    [type="checkbox"]:disabled:not(:checked) + label:before,
    [type="checkbox"]:disabled:checked + label:before,
    [type="radio"]:disabled:not(:checked) + label:before,
    [type="radio"]:disabled:checked + label:before {
        box-shadow: none;
        border-color: #8c8c8c;
        background-color: #878787;
    }
    [type="checkbox"]:disabled:checked + label:after,
    [type="radio"]:disabled:checked + label:after {
        color: #555555;
    }
    [type="checkbox"]:disabled + label,
    [type="radio"]:disabled + label {
        color: #8c8c8c;
    }
    /* accessibility */
    [type="checkbox"]:checked:focus + label:before,
    [type="checkbox"]:not(:checked):focus + label:before,
    [type="checkbox"]:checked:focus + label:before,
    [type="checkbox"]:not(:checked):focus + label:before {
        border: 1px dotted #f6f6f6;
    }
    /* hover style just for information */
    label:hover:before {
        border: 1px solid #f6f6f6 !important;
    }
    /*=== Customization ===*/
    /* radio aspect */
    [type="checkbox"]:not(:checked) + label:before,
    [type="checkbox"]:checked + label:before {
        border-radius: 3px;
    }
    [type="radio"]:not(:checked) + label:before,
    [type="radio"]:checked + label:before {
        border-radius: 35px;
    }
    /* selected mark aspect */
    [type="checkbox"]:not(:checked) + label:after,
    [type="checkbox"]:checked + label:after {
        content: '✔';
        top: 0;
        left: 2px;
        font-size: 14px;
    }
    [type="radio"]:not(:checked) + label:after,
    [type="radio"]:checked + label:after {
        content: '\2022';
        top: 0;
        left: 3px;
        font-size: 30px;
        line-height: 25px;
    }
    /*=== 9. Misc ===*/
    .logo {
        padding: 15px 0;
        font-size: 25px;
        color: #aaaaaa;
        font-weight: bold;
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
<#--<h2><a href="?lang=ru">RU</a> </h2>-->
<#--<h2><a href="?lang=en">EN</a> </h2>-->
<#--<h1><@spring.message 'sign_in_page.title'/></h1>-->

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
                    <li><a href="/home"><@spring.message 'navbar.home'/></a></li>
                    <li><a href="#"><@spring.message 'navbar.about'/></a></li>
                    <li><a href="/signIn"><@spring.message 'navbar.sign_in'/></a></li>
                    <li><a href="/signUp"><@spring.message 'navbar.sign_up'/></a></li>
                    <li><a href="?lang=ru"><@spring.message 'navbar.ru'/></a></li>
                    <li><a href="?lang=en"><@spring.message 'navbar.en'/></a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
    </nav><!-- /.navbar -->

</div><!-- /.container-fluid -->

<div class="text-center" style="padding:50px 0">
    <#if error?has_content>
        <div class="etc-login-form">
            <p>${error}</p>
        </div>
    <#else>
    </#if>
    <#if message?has_content>
        <div class="etc-login-form">
            <p> ${message} </p>
        </div>
    </#if>
    <#if info?has_content>
        <div class="reg-container">
            <p>${info}</p>
        </div>
<#--    <#else>-->
    </#if>
    <div class="logo"><@spring.message 'sign_in_page.title'/></div>
    <!-- Main Form -->
    <div class="login-form-1">
        <form action="/signIn" method="post">
        <form id="login-form" class="text-left">
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
                <div class="login-group">
                        <div class="form-group">
                            <label for="lg_username" class="sr-only">Username</label>
                            <input type="email" class="form-control" id="lg_username" name="email" placeholder="<@spring.message 'input_form.email'></@spring.message>">
                        </div>
                        <div class="form-group">
                            <label for="lg_password" class="sr-only">Password</label>
                            <input type="password" class="form-control" id="lg_password" name="password" placeholder="<@spring.message 'input_form.password'></@spring.message>">
                        </div>
                        <div class = "form-group">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        </div>
                        <div class="form-group login-group-checkbox">
                            <input type="checkbox" id="lg_remember" name="rememberMe">
                            <label for="lg_remember"> <@spring.message 'sign_in_page.rememberMe'></@spring.message></label>
                        </div>
                </div>
                <button type="submit" class="login-button"  value="<@spring.message 'input_form.enter'></@spring.message>"><i class="fa fa-chevron-right"></i></button>
            </div>
            </form>
            <div class="etc-login-form">
                <p><@spring.message 'sign_in_page.forgot'/><a href="#"><@spring.message 'sign_in_page.code_send_click'/></a></p>
                <p><@spring.message 'sign_in_page.new_user'/><a href="/signUp"><@spring.message 'sign_in_page.to_sign_up'/></a></p>
                <br>
            </div>
        </form>
    </div>
    <!-- end:Main Form -->
</div>

<#--<form action="/signIn" method="post">-->
<#--    <input name="email" type="email" placeholder="<@spring.message 'input_form.email'></@spring.message>">-->
<#--    <input name="password" type="password" placeholder="<@spring.message 'input_form.password'></@spring.message>">-->
<#--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
<#--    <input type="checkbox" name = "rememberMe"> <@spring.message 'sign_in_page.rememberMe'></@spring.message><br>-->
<#--    <input type="submit" value="<@spring.message 'input_form.enter'></@spring.message>">-->
<#--</form>-->
</body>
</html>


