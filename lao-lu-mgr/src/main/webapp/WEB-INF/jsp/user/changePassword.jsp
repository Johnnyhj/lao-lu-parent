<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>修改密码</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/taglib.jsp" %>

</head>
<body>

<div class="con-box">
    <div class="container-fluid">
        <form id="pwdForm" method="post">
        <div class="row">
            <div class="col-md-12" style="margin-top: 5px;">
                <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
            </div>

            <div class="col-md-12">
                <h3>修改密码</h3>
            </div>

            <input type="hidden" value="${user.password}" name="password" />
            <input type="hidden" value="${user.salt}" name="salt" />
            <input type="hidden" value="${user.username}" name="username" />

            <div class="col-md-12">
                <h5>新密码：</h5>
                <div class="con-area">
                    <div class="form-group col-md-6 ">
                        <input type="password" class="form-control" id="newPassword" name="newPassword" />
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>

            <div class="col-md-12">
                <h5>再次输入：</h5>
                <div class="con-area">
                    <div class="form-group col-md-6 ">
                        <input type="password" class="form-control" id="newPassword2" name="newPassword2" />
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>

            <div style="padding:24px 0;margin: 20px;">
                <input type="submit" class="btn btn-sub" value="${op}">
            </div>

        </div>
        </form>
    </div>
</div>

<script>
    $(document).ready(function () {
        jQuery.validator.addMethod("isStrongPwd", function(value, element){
            var modes = 0;
            //正则表达式验证符合要求的
            if (/\d/.test(value)) modes++; //数字
            if (/[a-z]/.test(value)) modes++; //小写
            if (/[A-Z]/.test(value)) modes++; //大写
            if (/\W/.test(value)) modes++; //特殊字符

            if (modes < 3) {
                return false;
            }
            return true;
        },"密码需要包括数字、小写字母、大写字母、特殊字符中的3种字符的组合。");


        setValidate();
    });



    function setValidate() {
        $("#pwdForm").validate({
            submitHandler: function(form){
                form.submit();
            },
            rules: {
                newPassword : {
                    required:true,
                    /*minlength:8,*/
                    isStrongPwd: false
                },
                newPassword2 : {
                    required:true,
                    /*minlength:8,*/
                    equalTo:"#newPassword"
                }
            }
        });
    }
</script>

</body>
</html>