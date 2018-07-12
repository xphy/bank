<%@ page pageEncoding="UTF-8"%>
<link href="../css/icrgt.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/access.js"></script>
<%@ include file="top.jsp"%>
   <h2>存入管理</h2>
   <div class="icregis">
     <form action=""method="post" >
	    <div class="form-group bank" >
	        <div class="row"><div class="col-md-4"><label >选择卡号:</label></div>
			     <div class="col-md-7">
			          <select class="select">	
			          <option value="0">请选择卡号</option>		            
			         </select>
			     </div>			     
			  </div>
	    </div>
	    <div class="form-group type" >
	        <div class="row"><div class="col-md-4"><label >交易类型:</label></div>
			     <div class="col-md-7">
			          <select class="select">	
			          <option value="0">请选择类型</option>		            
			          <option value="1">存入</option>		            
			          <option value="2">支出</option>		            
			         </select>
			     </div>			     
			  </div>
	    </div>
	    <div class="form-group">
			 <div class="row">
			   <div class="col-md-4"><label >交易时间:</label></div>
			 
			   <div class="col-md-7"><input type="date" class="form-control" id="date" ></div>
			 </div>
		</div>
	    <div class="form-group">
			      <div class="row">
			      <div class="col-md-4"><label >交易金额:</label></div>
			      <div class="col-md-7"><input class="form-control" id="money" placeholder="交易金额"></div>
			  </div>
		</div>
		<div class="row ">
			<div id="ts" class="col-md-12"></div>
	     </div>
		<div class="row text-center">
		   <div class="col-md-6"><button  type="button" id="sub"  class="btn">提交</button></div>
		   <div class="col-md-6"><button  type="button" id="reserve"  class="btn">重置</button></div>
        </div>
	  </form>
   </div>
<%@ include file="bottom.jsp"%>