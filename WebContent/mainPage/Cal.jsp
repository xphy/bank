<%@ page pageEncoding="UTF-8"%>
<link href="../css/computer.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/computer.js"></script>
<%@ include file="top.jsp"%>
  <div class="row" style="margin-top:15px">
       <h2 class="col-md-5 col-xs-5">计算器</h2>
  </div>
  <div class="container" style="width:780">
     <div class="row" style="margin-top:15px">
        <form name="computer" class="computer col-md-5 col-xs-5">
           <input type="text" id="text" name="text" class="text" disabled="disabled" value="0">
			<div class="buttons">
			    <input type="button" value="←" class="button id="dele" onClick="funback()">
				<input type="button" value="CE" class="button" id="ce" onClick="funclear()">
				<input type="button" value="C" class="button" id="c" onClick="funclear()">
				<input type="button" value="/" class="button" id="/" onClick="show(this)">
				<input type="button" value="7" class="button" id="7" onClick="show(this)">
				<input type="button" value="8" class="button" id="8" onClick="show(this)">
				<input type="button" value="9" class="button" id="9" onClick="show(this)">
				<input type="button" value="*" class="button" id="*" onClick="show(this)">
				<input type="button" value="4" class="button" id="4" onClick="show(this)">
				<input type="button" value="5" class="button" id="5" onClick="show(this)">
				<input type="button" value="6" class="button" id="6" onClick="show(this)">
				<input type="button" value="-" class="button" id="-" onClick="show(this)">
				<input type="button" value="1" class="button" id="1" onClick="show(this)">
				<input type="button" value="2" class="button" id="2" onClick="show(this)">
				<input type="button" value="3" class="button" id="3" onClick="show(this)">
				<input type="button" value="+" class="button" id="+" onClick="show(this)">
				<input type="button" value="0" class="button ling" id="0" onClick="show(this)">
				<input type="button" value="." class="button" id="." onClick="point()"> 
				<input type="button" value="=" class="button" id="=" onClick="getResult()">
			</div>
        </form>
     </div>
   </div>
<%@ include file="bottom.jsp"%>