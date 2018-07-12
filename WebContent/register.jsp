<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta charset="UTF-8">
  <title>银行注册界面</title>
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="css/index.css" rel="stylesheet" type="text/css">
  <link href="css/reset.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="js/jquery.min.js "></script>
  <script type="text/javascript" src="js/register.js "></script>
</head>
<body>
   <div class="wra container">
     <h1>注册</h1>
     <form>
		  <div class="form-group">
		    <div class="row"><div class="col-md-12"><label>用户名:</label></div></div>
		     <div class="row"><div class="col-md-12"><input class="form-control" id="name" placeholder="请输入用户名"></div></div>
		  </div>
		   <div class="form-group">
		      <div class="row"><div class="col-md-12"><label >密码:</label></div></div>
		      <div class="row"><div class="col-md-12"><input type="password1" class="form-control" id="password1" placeholder="请输入密码"></div></div>
		  </div>
		  <div class="form-group">
		      <div class="row"><div class="col-md-12"><label >确认密码:</label></div></div>
		      <div class="row"><div class="col-md-12"><input type="password" class="form-control" id="password2" placeholder="请再次输入密码"></div></div>
		  </div>
		 <div class="row text-right">
		       <div id="ts" class="col-md-12"></div>
            </div>
		    <div class="form-group text-center">
		       <div class="col-md-6"><button id="login" type="button" class="btn btn-primary">登陆</button></div>
		       <div class="col-md-6"><button id="register" type="button" class="btn btn-success">注册</button></div>
            </div>
         
    </form>
   </div>
</body>
</html>