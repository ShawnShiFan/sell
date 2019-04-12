<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="get" action="/sell/seller/login/index">
                        <div class="form-group">
                            <label>卖家账户</label>
                            <input name="userName" type="text" class="form-control" value="${(sellInfo.username)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="passWord" type="text" class="form-control" value="${(sellInfo.password)!''}"/>
                        </div>

                        <button type="submit" class="btn btn-default">登陆</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>