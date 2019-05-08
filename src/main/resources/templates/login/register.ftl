<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>
    </title>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
          rel="stylesheet">
    <style>

        .navbar-USF{
            left:0;
            top:0;
            position:fixed;
            height:100%;
            width:45px;
            background-color:#3C3C3C;
        }
        .navbar-USF a{
            display:block;
            padding:10px;
            line-height: 25px;
            height:45px;
            font-size:16px;
            text-align: center;
        }
        .navbar-USF a:hover{
            background:#E0E0E0;
        }
        .navbar-USF a span{
            height:25px;
            width: 25px;
        }

        .sign-page{
            margin-top:30px;
            padding:40px;
        }

        .alert{
            position:absolute;
            width:18%;
            left:40%;
            top:5%;
            display:none;
        }


        .alert p{
            text-align:center;
        }
        .signup-page{
            float:left;
            width:49%;
            display:inline-block;
            vertical-align:top;
            border-right: 1px solid #d9d9d9;
        }

        .signin-page{
            float:left;
            width:49%;
            display:inline-block;
            vertical-align:top;
        }

        form{
            width:301px;
            display:block;
            margin:20px;
            margin-left:100px;
        }
        .input-prepend span{
            width:42px;
            height:42px;
        }
        .input-prepend input{
            width:228px;
            height:42px;
            padding:4px 12px;
        }
        span#control-group{
            margin:0 0 100px 0;
        }

    </style>
</head>

<body>
<div class="navbar-USF">
    <div class="dropdown">
        <a href="/">
            <span class="glyphicon glyphicon-home"></span>
        </a>
        <a href="/">
            <span class="glyphicon glyphicon-th"></span>
        </a>
    </div>
</div>
<div class="container">
    <div class="sign-page">
        <div class="alert alert-info" role="alert">
            <p>
                注册成功，请登陆
            </p>
        </div>
        <div class="signup-page">
            <form>
                <h3>
                    Sign up with Email
                </h3>
                <p class="slogan">
                    Join us, start working
                </p>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-user"></span>
                    <input type="text" placeholder="用户名">
                </div>
                <br>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-envelope"></span>
                    <input type="text" placeholder="Email">
                </div>
                <br>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-lock"></span>
                    <input type="password" placeholder="******">
                </div>
                <br>
                <div class="input-prepend">
                    <span class="glyphicon glyphicon-lock"></span>
                    <input type="password" placeholder="******">
                </div>
                <br>
                <button class="btn btn-lg btn-primary btn-block">
                    <span>注册</span>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>