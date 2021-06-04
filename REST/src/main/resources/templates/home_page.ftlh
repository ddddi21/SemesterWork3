<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<style>
    .carousel-item {
        height: 100vh;
        min-height: 350px;
        background: no-repeat center center scroll;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
    }
    section {
        padding-top: 5rem;
        padding-bottom: 5rem;
    }

    .lnr {
        display: inline-block;
        fill: currentColor;
        width: 1em;
        height: 1em;
        vertical-align: -0.05em;
        stroke-width: 1;
    }

    .services-icon {
        margin-bottom: 20px;
        font-size: 30px;
    }
    bgc2, .vLine, .hLine {
        background-color: #0F52BA;
    }

    .quote-icon {
        font-size: 40px;
        margin-bottom: 20px;
    }
    .services-icon {
        font-size: 60px;
        margin-left: 2rem;
    }
</style>
<body>
<h1>Hello, world!</h1>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
        <a class="navbar-brand"><@spring.message 'home_page.welcome'></@spring.message></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/home"><@spring.message 'navbar.home'/>
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link" href="#"><@spring.message 'navbar.about'/></a>-->
<#--                </li>-->
                <li class="nav-item">
                    <a class="nav-link" href="/signIn"><@spring.message 'navbar.sign_in'/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/signUp"><@spring.message 'navbar.sign_up'/></a>
                </li>
                <li>
                    <a class="nav-link" href="?lang=ru"><@spring.message 'navbar.ru'/></a>
                </li>
                <li>
                    <a class="nav-link" href="?lang=en"><@spring.message 'navbar.en'/></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active" style="background-image: url('https://i.pinimg.com/564x/97/bb/85/97bb855de4e0928da17b0de044f0b650.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h2 class="display-4"><@spring.message 'home_page.title1'/></h2>
                    <p class="lead"><@spring.message 'home_page.desc1'/></p>
                </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('https://i.pinimg.com/564x/c1/27/5d/c1275da283fa80b72f3045e48fd0c09d.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h2 class="display-4"><@spring.message 'home_page.title2'/></h2>
                    <p class="lead"><@spring.message 'home_page.desc2'/></p>
                </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('https://i.pinimg.com/564x/34/57/11/3457118f63057837a62f6ddd4f2063e8.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h2 class="display-4"><@spring.message 'home_page.title3'/></h2>
                    <p class="lead"><@spring.message 'home_page.desc3'/></p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</header>

<!-- Page Content -->
<section class="py-5 text-center">
    <div class="container">
        <h2 class="text-center"><@spring.message 'home_page.title4'/></h2>
        <p class="text-muted mb-5 text-center"><@spring.message 'home_page.desc4'/></p>
<#--        <div class="row">-->
<#--            <div class="col-sm-6 col-lg-4 mb-3">-->
<#--                <svg class="lnr text-primary services-icon">-->
<#--                    <use xlink:href="#lnr-magic-wand"></use>-->
<#--                </svg>-->
<#--                <h6>Ex cupidatat eu</h6>-->
<#--                <p class="text-muted">Ex cupidatat eu officia consequat incididunt labore occaecat ut veniam labore et cillum id et.</p>-->
<#--            </div>-->
<#--            <div class="col-sm-6 col-lg-4 mb-3">-->
<#--                <svg class="lnr text-primary services-icon">-->
<#--                    <use xlink:href="#lnr-heart"></use>-->
<#--                </svg>-->
<#--                <h6>Tempor aute occaecat</h6>-->
<#--                <p class="text-muted">Tempor aute occaecat pariatur esse aute amet.</p>-->
<#--            </div>-->
<#--            <div class="col-sm-6 col-lg-4 mb-3">-->
<#--                <svg class="lnr text-primary services-icon">-->
<#--                    <use xlink:href="#lnr-rocket"></use>-->
<#--                </svg>-->
<#--                <h6>Voluptate ex irure</h6>-->
<#--                <p class="text-muted">Voluptate ex irure ipsum ipsum ullamco ipsum reprehenderit non ut mollit commodo.</p>-->
<#--            </div>-->
<#--            <div class="col-sm-6 col-lg-4 mb-3">-->
<#--                <svg class="lnr text-primary services-icon">-->
<#--                    <use xlink:href="#lnr-paperclip"></use>-->
<#--                </svg>-->
<#--                <h6>Tempor commodo</h6>-->
<#--                <p class="text-muted">Tempor commodo nostrud ex Lorem occaecat duis occaecat minim.</p>-->
<#--            </div>-->
<#--            <div class="col-sm-6 col-lg-4 mb-3">-->
<#--                <svg class="lnr text-primary services-icon">-->
<#--                    <use xlink:href="#lnr-screen"></use>-->
<#--                </svg>-->
<#--                <h6>Et fugiat sint occaecat</h6>-->
<#--                <p class="text-muted">Et fugiat sint occaecat voluptate incididunt anim nostrud ea cillum cillum consequat.</p>-->
<#--            </div>-->
<#--            <div class="col-sm-6 col-lg-4 mb-3">-->
<#--                <svg class="lnr text-primary services-icon">-->
<#--                    <use xlink:href="#lnr-inbox"></use>-->
<#--                </svg>-->
<#--                <h6>Et labore tempor et</h6>-->
<#--                <p class="text-muted">Et labore tempor et adipisicing dolor.</p>-->
<#--            </div>-->
<#--        </div>-->
    </div>
</section>
<#--<section class="main">-->
<#--    <div class="container mt-4">-->
<#--        <h1 class="text-center mb-4 p-4 text-secondary">From The Blog</h1>-->
<#--        <div class="row">-->

<#--            <div class="card-columns">-->
<#--                <div class="card shadow border-0">-->
<#--                    <img class="card-img-top" src="https://4.bp.blogspot.com/-InDD3Hm_bhU/XB4_TK3TT7I/AAAAAAAAAJ4/r5tUeCOqq1MTchFh7D7pWdf582A4qYIIwCEwYBhgL/s1600/Businesswoman-working-at-a-computer-1280x720.jpg" alt="Card image cap">-->
<#--                    <div class="card-body">-->
<#--                        <h5 class="card-title">Card title that wraps to a new line</h5>-->
<#--                        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>-->
<#--                    </div>-->
<#--                </div>-->
<#--                <div class="card shadow border-0  p-3">-->
<#--                    <blockquote class="blockquote mb-0 card-body">-->
<#--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>-->
<#--                        <footer class="blockquote-footer">-->
<#--                            <small class="text-muted">-->
<#--                                Someone famous in <cite title="Source Title">Source Title</cite>-->
<#--                            </small>-->
<#--                        </footer>-->
<#--                    </blockquote>-->
<#--                </div>-->
<#--                <div class="card shadow border-0">-->
<#--                    <img class="card-img-top" src="https://4.bp.blogspot.com/-InDD3Hm_bhU/XB4_TK3TT7I/AAAAAAAAAJ4/r5tUeCOqq1MTchFh7D7pWdf582A4qYIIwCEwYBhgL/s1600/Businesswoman-working-at-a-computer-1280x720.jpg" alt="Card image cap">-->
<#--                    <div class="card-body">-->
<#--                        <h5 class="card-title">Card title</h5>-->
<#--                        <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>-->
<#--                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>-->
<#--                    </div>-->
<#--                </div>-->
<#--                <div class="card shadow border-0 bg-primary text-white text-center p-3">-->
<#--                    <blockquote class="blockquote mb-0">-->
<#--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat.</p>-->
<#--                        <footer class="blockquote-footer">-->
<#--                            <small>-->
<#--                                Someone famous in <cite title="Source Title">Source Title</cite>-->
<#--                            </small>-->
<#--                        </footer>-->
<#--                    </blockquote>-->
<#--                </div>-->
<#--                <div class="card shadow border-0 text-center">-->
<#--                    <div class="card-body">-->
<#--                        <h5 class="card-title">Card title</h5>-->
<#--                        <p class="card-text">This card has a regular title and short paragraphy of text below it.</p>-->
<#--                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>-->
<#--                    </div>-->
<#--                </div>-->
<#--                <div class="card shadow border-0">-->
<#--                    <img class="card-img" src="https://4.bp.blogspot.com/-InDD3Hm_bhU/XB4_TK3TT7I/AAAAAAAAAJ4/r5tUeCOqq1MTchFh7D7pWdf582A4qYIIwCEwYBhgL/s1600/Businesswoman-working-at-a-computer-1280x720.jpg" alt="Card image">-->
<#--                </div>-->
<#--                <div class="card shadow border-0 p-3 text-right">-->
<#--                    <blockquote class="blockquote mb-0">-->
<#--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>-->
<#--                        <footer class="blockquote-footer">-->
<#--                            <small class="text-muted">-->
<#--                                Someone famous in <cite title="Source Title">Source Title</cite>-->
<#--                            </small>-->
<#--                        </footer>-->
<#--                    </blockquote>-->
<#--                </div>-->
<#--                <div class="card shadow border-0">-->
<#--                    <div class="card-body">-->
<#--                        <h5 class="card-title">Card title</h5>-->
<#--                        <p class="card-text">This is another card with title and supporting text below. This card has some additional content to make it slightly taller overall.</p>-->
<#--                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->
<#--    </div>-->
<#--</section>-->

<!-- Header -->
<header class="bg-primary text-center py-5 mb-4">
    <div class="container">
        <h1 class="font-weight-light text-white"><@spring.message 'home_page.team_meeting'/></h1>
    </div>
</header>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <!-- Team Member 1 -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-0 shadow">
                <img src="https://i.pinimg.com/564x/cc/6f/40/cc6f4061126743ef0b6ee47d5ae775b2.jpg" class="card-img-top" alt="...">
                <div class="card-body text-center">
                    <h5 class="card-title mb-0"><@spring.message 'home_page.team_member1'/></h5>
                    <div class="card-text text-black-50"><@spring.message 'home_page.team_desc1'/></div>
                </div>
            </div>
        </div>
        <!-- Team Member 2 -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-0 shadow">
                <img src="https://i.pinimg.com/564x/92/3e/6b/923e6b33c127e6309bd016e6ec855988.jpg" class="card-img-top" alt="...">
                <div class="card-body text-center">
                    <h5 class="card-title mb-0"><@spring.message 'home_page.team_member2'/></h5>
                    <div class="card-text text-black-50"><@spring.message 'home_page.team_desc2'/></div>
                </div>
            </div>
        </div>
        <!-- Team Member 3 -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-0 shadow">
                <img src="https://i.pinimg.com/564x/8c/b9/87/8cb987b1a582b5ec4451fdbb701f762e.jpg" class="card-img-top" alt="...">
                <div class="card-body text-center">
                    <h5 class="card-title mb-0"><@spring.message 'home_page.team_member3'/></h5>
                    <div class="card-text text-black-50"><@spring.message 'home_page.team_desc3'/></div>
                </div>
            </div>
        </div>
        <!-- Team Member 4 -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-0 shadow">
                <img src="https://i.ytimg.com/vi/edwLjpKd2Kk/hqdefault.jpg" class="card-img-top" alt="...">
                <div class="card-body text-center">
                    <h5 class="card-title mb-0"><@spring.message 'home_page.team_member4'/></h5>
                    <div class="card-text text-black-50"><@spring.message 'home_page.team_desc4'/></div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->

</div>

<div class="container">
    <div class="row">
        <div class="col-md-8">
            <blockquote class="blockquote text-center mb-0">
                <svg class="lnr text-muted quote-icon pull-left">
                    <use xlink:href="#lnr-heart">
                    </use></svg>
                <p class="mb-0"><@spring.message 'home_page.motivation'/></p>
                <footer class="blockquote-footer"><@spring.message 'home_page.author'/>
<#--                    <cite title="Source Title">Webublog @</cite>-->
                </footer>
            </blockquote>
        </div>
    </div>

</div>
<!-- /.container -->
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://cdn.linearicons.com/free/1.0.0/svgembedder.min.js"></script>

</body>
</html>