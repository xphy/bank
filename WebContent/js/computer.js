
	var clearmsg = false;
	var ispoint = true;
	//文本框中显示
	function show(obj){
		var data =	obj.value;
		var text = document.getElementById("text");
		if(clearmsg){
			text.value = "";
			clearmsg=false;
		}
		if(data == "+" || data == "-" || data == "*" || data == "/"){
			ispoint = true;
		}
		if(data == "0" && text.value == "0"){
			text.value = parseInt(text.value) + 0;	
		}else if(text.value == "0" && data != "+" && data != "-" && data != "*" && data != "/"){
			text.value = parseInt(text.value) + parseInt(data);
		}else{
			text.value += data;
		}
	}
	//计算结果
	function getResult(){
		var data = document.getElementById("text");
		try{
			ispoint = true;
			data.value = eval(data.value);
			clearmsg = true;
			//alert(ispoint);
		}catch(err){
			alert("这怎么算!");
			data.value = "0";
		}
	}
	//点
	function point(){
		var p = document.getElementById(".");
		var text = document.getElementById("text");
		
		if(ispoint){
			text.value += p.value;
			ispoint = false;
		}
		//if(text.value.indexOf(".") == true ){
		//}else{
		//	text.value += p.value;
		//}			
	}
	//清空
	function funclear(){
		var a = document.getElementById("text").value = "0";
		clearmsg = false;
		ispoint = true;
		//if(a==null || a==""){
		//	alert("null");
		//}else{
		//	alert(a);
		//}
	}
	//退格键
	function funback(){
		var text = document.getElementById("text");
		if(text.value == "0" || text.value == ""){
			text.value = "0";
		}else{
			document.getElementById("text").value=document.getElementById("text").value.slice(0,-1);
		}
	}
