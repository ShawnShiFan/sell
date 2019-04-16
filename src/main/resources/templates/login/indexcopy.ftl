<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->


    <#--主要内容content-->
    <div id="page-content-wrapper">

        <div class="row clearfix">
            <div class="col-md-2 column">
                <form role="form" method="post" action="/sell/seller/login/index">

                    <div class="form-group">
                        <label>卖家账户</label>
                        <input name="userName" type="text" class="form-control" value="${(sellInfo.username)!''}"/>
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input name="passWord" type="password" class="form-control" value="${(sellInfo.password)!''}"/>
                    </div>

                    <button type="submit" class="btn btn-default">登陆</button>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>