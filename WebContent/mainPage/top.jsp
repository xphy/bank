<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="../css/top.css" rel="stylesheet" type="text/css">
  <link href="../css/reset.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="../js/jquery.min.js "></script>
  <script type="text/javascript" src="../js/bootstrap.min.js "></script>
  <script type="text/javascript" src="../js/top.js ">  </script>
  <title>管理界面</title>
</head>
<body>
  <div class="wra container">
     <div class="row">
           <div class="col-md-4" >
               <input type="hidden"name="uid" id = "uid">          
           </div>
     </div>
     <div class="row one">
        <div class="col-md-4"><img class="logo"src="../imgs/logo.png"></div>
        <div class="col-md-8"><img class="people"src="../imgs/top.png"></div>
     </div>
     <div class="row">
        <div class="col-md-4">
           <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			  <div class="panel panel-default">
			    <div class="panel-heading" role="tab" id="headingOne">
			      <h4 class="panel-title">
			        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
			                  银行卡管理
			        </a>
			      </h4>
			    </div>
			    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
			      <div class="panel-body">
			           <a >银行卡注册</a>
			           <a >银行卡销毁</a>			                   
			       </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading" role="tab" id="headingTwo">
			      <h4 class="panel-title">
			        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
			                    交易管理
			        </a>
			      </h4>
			    </div>
			    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
			      <div class="panel-body">
			           <a>存入/支出管理</a>	                   
			       </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading" role="tab" id="headingThree">
			      <h4 class="panel-title">
			        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
			                     汇总查询
			        </a>
			      </h4>
			    </div>
			    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
			      <div class="panel-body">
			           <a>交易记录查询</a>
			           <a>账户余额查询</a>
			           <a>计算器</a>			                   
			       </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading" role="tab" id="headingThree">
			      <h4 class="panel-title">
			        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
			                     友情链接
			        </a>
			      </h4>
			    </div>
			    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
			      <div class="panel-body">
			           <a href="http://www.baidu.com">百度</a>
			           <a>东方罗尔</a>			           		                   
			       </div>
			    </div>
			  </div>
			  
			</div>
        </div>
        <div class="col-md-8">
        
       