<%@ page pageEncoding="UTF-8"%>
<link href="../css/icrgt.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/icdel.js"></script>
<%@ include file="top.jsp"%>
   <h2>银行销毁</h2>
   <div class="container" style="width:780">
     <div class="row" style="margin-top:15px">
			<div class="col-md-12">
				<div class="table-resposive">
					<table id="tab" class="table table-bordered">
						<tr>
							<th class="text-center">序号</th>
							<th>开户行</th>
							<th>卡号</th>
							<th>余额</th>
							<th class="text-center del">注销</th>						
						</tr>
					</table>
				</div>
			</div>
		</div>
     <div class="row">
         <div id="ts"class="col-md-12">
         </div>
     </div> 
   </div>

<%@ include file="bottom.jsp"%>