<%@ page pageEncoding="UTF-8"%>
<link href="../css/icrgt.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/icrgt.js"></script>
<%@ include file="top.jsp"%>
   <h2>银行卡注册</h2>
   <div class="icregis">
   <form action="icrgt.do"method="post" >
	    <div class="form-group bank" >
			    <div class="row"><div class="col-md-4"><label >开户行:</label></div>
			     <div class="col-md-7">
			          <select class="select">	
			          <option value="0">请选择银行</option>		            
			         </select>
			     </div>			     
			  </div>
	    </div>
		<div class="form-group">
			      <div class="row">
			      <div class="col-md-4"><label >卡号:</label></div>
			      <div class="col-md-7"><input class="form-control" id="icnum" placeholder="请输入卡号"></div>
			  </div>
		</div>
		<div class="form-group">
			 <div class="row">
			   <div class="col-md-4"><label >开户时间:</label></div>
			 
			   <div class="col-md-7"><input type="date" class="form-control" id="date" ></div>
			 </div>
		</div>
		<div class="form-group">
			      <div class="row">
			      <div class="col-md-4"><label >初始金额:</label></div>
			      <div class="col-md-7"><input class="form-control" id="money" placeholder="请输入初始金额"></div>
			  </div>
		</div>
	    <div class="row text-right">
			<div id="ts" class="col-md-12"></div>
	     </div>
		<div class="row text-center">
		   <div class="col-md-12"><button  type="button" id="login"  class="btn">提交</button></div>
        </div>
   </form>
   </div>
<%@ include file="bottom.jsp"%>