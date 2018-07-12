<%@ page pageEncoding="UTF-8"%>
<link href="../css/icrgt.css" rel="stylesheet" type="text/css">
<link href="../css/Record.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/record.js"></script>
<%@ include file="top.jsp"%>
  <h2>银行卡交易记录查询</h2>
  <div class="container" style="width:780">
     <div class="row" style="margin-top:15px">
        <div class="col-md-2">
           <span>查询卡号:</span>
        </div>
        <div class="col-md-5">
            <input class="form-control" id="icnum" placeholder="请输入卡号">
        </div>
        <div class="col-md-2">
           <button  type="button" id="login"  class="btn">查询</button>
        </div>
     </div>
     <div class="row text-right " style="margin-bottom:15px">
			<div id="ts" class="col-md-12"></div>
	  </div>
     <div class="row" style="margin-top:15px">
			<div class="col-md-12">
				<div class="table-resposive">
					<table id="tab" class="table table-bordered">
						<tr>
							<th class="text-center">序号</th>
							<th class="text-center">卡号</th>
							<th class="text-center">交易时间</th>
							<th class="text-center">交易类型</th>
							<th class="text-center">交易金额</th>						
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
<%@ include file="bottom.jsp"%>