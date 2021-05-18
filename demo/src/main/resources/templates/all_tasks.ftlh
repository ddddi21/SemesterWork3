<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- All the files that are required -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<#import "pager.ftl" as p>

<!DOCTYPE html>
<html lang="ru">
<#import "spring.ftl" as spring/>

<head>
    <meta charset="UTF-8">
<#--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />-->
<#--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
<#--    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>-->
<#--    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
<#--    <meta name="_csrf" content="${_csrf.token}"/>-->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        @media only screen and (min-width: 768px) {
            .dropdown:hover .dropdown-menu {
                display: block;
                margin-top: 0;
            }
        }

    </style>
    <title>Tasks page</title>

<#--    <script>-->
<#--        $('.dropdown-toggle').click(function(e) {-->
<#--            if ($(document).width() > 768) {-->
<#--                e.preventDefault();-->
<#--                var url = $(this).attr('href');-->
<#--                if (url !== '#') {-->
<#--                    window.location.href = url;-->
<#--                }-->
<#--            }-->
<#--        });-->
<#--    </script>-->
<#--    <script>-->
<#--        $(document).ready(function(){-->
<#--            $.ajax({-->
<#--                url : "/tasks",-->
<#--                type : "GET",-->
<#--                async : false,-->
<#--                success : function(data) {-->
<#--                    let rootEl = document.getElementById("list");-->
<#--                    let postList = data.split('!')-->
<#--                    postList.forEach(function(item, i, arr) {-->
<#--                        let postItem = item.split('#')-->
<#--                        if(postItem.length > 1) {-->
<#--                            let el = document.createElement("div");-->
<#--                            el.innerHTML =  '<div class ="container">'+'<div class="card w-25">' +-->
<#--                                ' <div class="card-header"> ' +-->
<#--                                '<h5 class="card-title">'+ postItem[0] +'</h5> ' + '<hr>' + '</div>'+-->
<#--                                '<div class="card-body">'+-->
<#--                                '<p class="card-text">'+ postItem[1] +'</p> ' +'<hr>'+-->
<#--                                '<div class="card-footer text-muted">' +-->
<#--                                '<p class="card-text"> Deadline: '+ postItem[2] + '</p> </div> </div> </div>';-->
<#--                            rootEl.appendChild(el);-->
<#--                        }-->
<#--                    });-->
<#--                }-->
<#--            });-->
<#--        })-->
<#--    </script>-->
<#--    <script>-->
<#--        $(document).ready(function () {-->
<#--            let $result = $("search_box-result")-->
<#--            let rootEl = document.getElementById("search_box-result");-->
<#--            $('#search').on('keyup', function () {-->
<#--                rootEl.innerHTML = ""-->
<#--                var search = $(this).val();-->
<#--                if ((search !== '') && (search.length > 1)) {-->
<#--                    $.ajax({-->
<#--                        type: "POST",-->
<#--                        url: "/ajax_search",-->
<#--                        data: {'search': search},-->
<#--                        success: function (msg) {-->
<#--                            if (msg !== " ") {-->
<#--                                msg = msg.replace(/\n/ig, '');-->
<#--                                $result.fadeIn();-->
<#--                                let msgList = msg.split('!');-->
<#--                                msgList.forEach(function (item, i, arr) {-->
<#--                                    let itemMas = item.split('#')-->
<#--                                    if (itemMas.length > 1) {-->
<#--                                        let el = document.createElement("div");-->
<#--                                        el.innerHTML =-->
<#--                                            "<div class=\"search_result\"><table><tr><td class=\"search_result-name\"><a href=\"/user?user_id="+ itemMas[3] + "\">" + itemMas[0] + ' ' + itemMas[1] + '<p>' + itemMas[2]+'</p>'+ "</a></td><td class=\"search_result-btn\"></td> </tr> </table> </div>"-->
<#--                                        rootEl.appendChild(el);-->
<#--                                    }-->
<#--                                });-->
<#--                            } else {-->
<#--                                rootEl.innerHTML = ""-->
<#--                                $result.fadeOut(100);-->
<#--                            }-->
<#--                        }-->
<#--                    })-->
<#--                } else {-->
<#--                    $result.html('');-->
<#--                    rootEl.innerHTML = ""-->
<#--                    $result.fadeOut(100);-->
<#--                }-->
<#--            });-->
<#--        })-->

<#--    </script>-->
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

    {
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }

    body {
        background-color: antiquewhite;
    }

</style>
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
<body>
<@p.pager url page />
<#--<div>-->
<#--    <ul id="list" class="list-group listSize">-->

<#--    </ul>-->
<#--</div>-->
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/tasks" class="form-inline">
            <label>
                <input type="text" name="filter" class="form-control" value="${filter!}" placeholder="Search by tag" />
            </label>
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>
<div class="card-columns" id="message-list">
    <#list page.content as message>
        <div class="card my-3" data-id="${message.id}">
            <div class="m-2">
                <span>${message.text}</span><br/>
                <i>#${message.title}</i>
            </div>
            <div class="card-footer text-muted">
                <a>Due to:${message.deadline}</a>
<#--                <a href="/user-messages/${message.author.id}">${message.authorName}</a>-->
<#--                <#if message.author.id == currentUserId>-->
<#--                    <a class="btn btn-primary" href="/user-messages/${message.author.id}?message=${message.id}">-->
<#--                        Edit-->
<#--                    </a>-->
<#--                </#if>-->
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>
</body>

