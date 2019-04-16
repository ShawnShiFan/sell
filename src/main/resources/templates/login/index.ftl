<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <style>
        .carousel-inner img {
            width:100%;
            height:100%;
        }
        .jumbotron {
            margin-top: 10px;
            margin-bottom: 0px;
            padding-top: 10px;
        }
        #demo {
            width:100%;
            height: 370px;
        }
        .row {
            height: 370px;
        }
        .left {
            float: left;
            width: 70%;
        }
        .right {
            float: left;
            width: 30%;
        }
        .card {
            height: 370px;
        }
        .carousel-inner {
            height: 370px;
        }
        .footer {
            position: absolute;
            bottom: 0;
            height: 60px;
        }
        .jumheight1 {
            height: 140px;
        }
        .jumheight2 {
            height: 260px;
        }
        .end_name {
            margin-bottom: 5px;
        }
        .footer2 {
            padding-top: 210px;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function Toregister() {
            window.open("register.ftl")
        }
    </script>
</head>
<body>
<div>
    <div class="jumbotron text-info bg-light jumheight1">
        <h1>Shawn卖家后端管理系统</h1>
    </div>
    <!-- 轮播图 -->
    <!-- 指示符 -->
    <div class="row">
        <div class="left">
            <div id="demo" class="carousel slide " data-ride="carousel">
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>
                <!-- 轮播图片 -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="imgs/foods1.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="imgs/foods5.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="imgs/foods3.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="imgs/foods4.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="imgs/foods6.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="imgs/foods7.jpg">
                    </div>
                    <div class="carousel-item">
                        <img src="imgs/foods8.jpg">
                    </div>
                </div>
                <!-- 左右切换按钮 -->
                <a href="#demo" class="carousel-control-prev" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a href="#demo" class="carousel-control-next" data-slide=next>
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </div>
        <div class="right">
            <!-- 登陆窗口 -->
            <div class="card">
                <div class="card-header">
                    用户登陆
                </div>
                <div class="card-body">
                    <form role="form" method="post" action="/sell/seller/login/index">
                        <table style="border-collapse: separate;border-spacing: 20px 30px;">
                            <tr>
                                <td class="margin-top:10">
                                    <label>用户名：</label>
                                </td>
                                <td>
                                    <input type="text" name="userName" class="" value="${(sellInfo.username)!''}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="pwd">密码:</label>
                                </td>
                                <td>
                                    <input  name="passWord" type="password"  value="${(sellInfo.password)!''}"/>
                                </td>
                            </tr>
                        </table>
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="checkbox" name="" class="form-check-input">记住密码
                            </label>
                        </div>
                        <div class="footer">
                            <button type="submit" class="btn btn-primary">登陆</button>
                            <button type="" class="btn btn-secondary" onclick="Toregister()">注册</button>
                            <button type="button" class="btn btn-link"><small>忘记密码？</small></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="jumbotron bg-light jumheight2">
        <p class="footer2">   Designed by Shawn     ©2019Shawn  如有疑问请联系邮箱shawn_shifan@163.com  |  手机13405608660  </p>
    </div>
</div>
</body>
</html>
