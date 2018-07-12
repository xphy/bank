<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta charset="UTF-8">
  <title>银行登陆界面</title>
  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="css/index.css" rel="stylesheet" type="text/css">
  <link href="css/reset.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="js/jquery.min.js "></script>
  <script type="text/javascript" src="js/index.js "></script>
  
  </head>
<body>
   <div class="wra container">
   <div class="row">
           <div class="col-md-4" >
               <input type="hidden" name="uid" id = "uid">          
           </div>
     </div>
     <h1>登陆</h1>
     <form>
		  <div class="form-group">
		    <div class="row"><div class="col-md-12"><label >用户名:</label></div></div>
		     <div class="row"><div class="col-md-12"><input  class="form-control" id="name" placeholder="请输入用户名"></div></div>
		  </div>
		   <div class="form-group">
		      <div class="row"><div class="col-md-12"><label >密码:</label></div></div>
		      <div class="row"><div class="col-md-12"><input type="password" class="form-control" id="password" placeholder="请输入密码"></div></div>
		  </div>
		  <div class="form-group pass">
		     <div class="row"><div class="col-md-12"><label >验证码:</label></div></div>
		     <div class="row">
		       <div class="col-md-5"><input type="password" class="form-control" id="yz" placeholder="请输入验证码"></div>
		       <div class="col-md-3"><img src="image.jsp"></div>
		       <div class="col-md-4"><span>看不清</span></div>
		    </div>
		  </div>
		  <div class="row text-right">
		       <div id="ts" class="col-md-12"></div>
            </div>
		    <div class="row text-center">
		       <div class="col-md-6"><button  type="button" id="login"  class="btn">登陆</button></div>
		       <div class="col-md-6"><button  type="button" id="register"   class="btn ">注册</button></div>
            </div>
        </form>
   </div>
  
</body>
</html>