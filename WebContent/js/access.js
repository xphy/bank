     var parma=null;
     var prompt="";
     var bool=true;
     
   //添加提示
     function prom(str){
    	 $("#ts").empty();
    	 var $p=$("<p>"+str+"</P>");
    	 $p.appendTo($("#ts"));
     }
   //获得js对象
     function getparma(){    	 
    	 prompt="";
    	 var uid1 =window.location.search;
    	 var uid = uid1.split("=")[1];
    	 var icnum=$(".bank select").find("option:selected").text();;
    	 var type=$(".type select").val();
    	 var date =$("#date").val();
    	 var money = $("#money").val();
    	 if(icnum == "0"){
    		 prompt="卡号不能为空! ";
    		 bool=false;
    	 }
    	 if(type ==0){
    		 prompt+=" 交易类型不能为空! ";
    		 bool=false;
    	 }
    	 if(date==""){
    		 prompt+=" 交易日期不能为空! ";
    		 bool=false;
    	 }
    	 if(money==""){
    		 prompt+=" 存入金额不能为空!";
    		 bool=false;
    	 }
    	 prom(prompt);
    	 parma={uid:uid,icnum:icnum,type:type,date:date,money:money};
    	
     }
     //注册银行卡
     function icnum(){
    	 $("#sub").click(function(){    		 
    		 getparma();
    		 if(bool){
    			 
    			 $.post("../deposit.do",parma,function(data){
    				 var type=$(".type select").val();
    				 if(data=="success"){
    					 if(type==1){
    						 prompt ="银行卡存入成功!";
    					 }else{
    						 prompt ="银行卡支取成功!";
    					 }
    					 prom(prompt);    		
    				 }else if(data=="yew"){
    					 prompt ="银行卡余额为0!";
    				 }else if(data=="yebz"){
    					 prompt ="银行卡余额不足!";
    				 }else{
    					 if(type==1){
    						 prompt ="银行卡存入失败!";
    					 }else{
    						 prompt ="银行卡支取失败!";
    					 }
    				 }
    				 prom(prompt);    
    			 })
    			 
    		 }
    		 })
     }
     
     //重置
     function res(){
    	 $("#reserve").click(function(){
    		 var icnum=$(".bank select").val(0);
        	 var type=$(".type select").val(0);
        	 var date =$("#date").val("请输入日期");
        	 var money = $("#money").val("请输入交易金额");
    	 })
     }
//主要的

$(function(){
	icnum();
	
	$.getJSON("../deposit.do",function(data){
		var $sel=$(".bank select");
		
		$.each(data,function(i,k){
			var $op=$("<option>"+k.cnum+"</option>");
			$op.attr("value",k.cid);
			$op.appendTo($sel);
		})
	})
	res();
})