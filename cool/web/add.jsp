<%--
  Created by IntelliJ IDEA.
  User: zzv
  Date: 2020/6/14
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        function checkName(){
            //1.获取用户名的值
            var name = $("#name").val();
            //2.定义正则
            var reg_param=/^[\u4e00-\u9fa5]{2,4}$/;
            //3.判断，给出提示信息
            var flag = reg_param.test(name);
            if(flag){
                $("#name").css("border","");
            }else{
                //用户名非法，加一个红色的边框
                $("#name").css("border","red solid 2px");
            }
            return flag;
        }
        function checkAge(){
            //1.获取用户名的值
            var age = $("#age").val();
            //2.定义正则
            var reg_param=/^\d{1,3}$/;
            //3.判断，给出提示信息
            var flag = reg_param.test(age);
            if(flag){
                $("#age").css("border","");
            }else{
                //用户名非法，加一个红色的边框
                $("#age").css("border","red solid 2px");
            }
            return flag;
        }
        function checkQq(){
            //1.获取用户名的值
            var qq = $("#qq").val();
            //2.定义正则
            var reg_param=/^\d{5,15}$/;
            //3.判断，给出提示信息
            var flag = reg_param.test(qq);
            if(flag){
                $("#qq").css("border","");
            }else{
                //用户名非法，加一个红色的边框
                $("#qq").css("border","red solid 2px");
            }
            return flag;
        }
        function checkEmail(){
            //1.获取用户名的值
            var email = $("#email").val();
            //2.定义正则
            var reg_param=/^\w{3,12}@\w{1,5}\.[a-z]{2,3}$/;
            //3.判断，给出提示信息
            var flag = reg_param.test(email);
            if(flag){
                $("#email").css("border","");
            }else{
                //用户名非法，加一个红色的边框
                $("#email").css("border","red solid 2px");
            }
            return flag;
        }
        $(function () {
            //2.当某个组件失去焦点，调用校验方法
            $("#name").blur(checkName);
            $("#age").blur(checkAge);
            $("#qq").blur(checkQq);
            $("#email").blur(checkEmail);

        });
    </script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form id="addForm" action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label >性别：</label>
            <input type="radio" name="gender" value="男"  checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input  id=qq type="text" class="form-control" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input id="email" type="text" class="form-control" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>