<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="format-detection" content="telephone=no" />
<title>首页</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/emojione/1.5.2/assets/sprites/emojione.sprites.css"
	media="screen">
<link rel="stylesheet" type="text/css" href="css/stylesheet.css"
	media="screen">
<link rel="stylesheet" type="text/css" href="css/emojionearea.min.css"
	media="screen">
<link href="css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="js/emojione.min.js"></script>
<script type="text/javascript" src="js/emojionearea.js"></script>

<script type="text/javascript">
	$(function() {
		$("#fbContent").emojioneArea();
	});
</script>
<script type="text/javascript">
	//给文本域绑定事件
	$("input[name='img']").live('change', function() {
		var file = $(this).val();
		//预览图片
		setImagePreview(file);
	});
	function setImagePreview(avalue) {
		//文本域
		var docObj = document.getElementById("doc");
		//img
		var imgObjPreview = document.getElementById("preview");
		//div
		var divs = document.getElementById("localImag");
		if (docObj.files && docObj.files[0]) {
			//火狐下，直接设img属性
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '80px';
			imgObjPreview.style.height = '80px';
			//imgObjPreview.src = docObj.files[0].getAsDataURL();
			//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
			imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		} else {
			//IE下，使用滤镜
			docObj.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImag");
			//必须设置初始大小
			localImagId.style.width = "80px";
			localImagId.style.height = "80px";
			//图片异常的捕捉，防止用户修改后缀来伪造图片
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)"
				localImagId.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}
		return true;
	}
	</script>
<script type="text/javascript">
		//获取系统时间
		//Date d=new Date； java
		function mytime(){
		var d =new Date();
		var y=d.getFullYear();
		var mo=d.getMonth()+1;
		var da=d.getDate();
		var h=d.getHours();
		var m=d.getMinutes();
		var s=d.getSeconds();
		
		//****年**月**日**时**分**秒
		var time =y+"-"+mo+"-"+da+"  "+h+":"+m+":"+s+"";
		/*alert(time);*/
		document.getElementById("sp").innerHTML=time;
		}
		window.setInterval(mytime,1000);//一秒调用一次mytime函数
		</script>
<script type="text/javascript">
		function chkName(){
			var uPattern =/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
			var un=document.getElementById("username").value;
			if(uPattern.test(un)){
				//用正则表达式匹配字符串，如果匹配上则返回true
				document.getElementById("sp").innerHTML="√";
				document.getElementById("sp").style.color="green";
			}else{			
				alert("只能输入5-20个以字母开头、可带数字、“_”、“.”的字串 ");
			}
			}
		</script>

<script type="text/javascript">
$(document).ready(function(){
  $("button").click(function(){
    $("p").slideToggle();
  });
  $("p").dblclick(function(){
    $("button").click();
  });
});

</script>

<!-- 模糊查询 -->
<script type="text/javascript">
$(document).ready(function(){
$('input[name="btn_submit"]').click(function (){
	
	document.getElementById("formid").submit();
    
  });
  
});
</script>


<!-- 点赞 -->
<script type="text/javascript">
   function dz(name,id){	       
    		      $.ajax({
    		    	     type:'post',
    		    	     url:'dzservlet',
    		    	     data:'id='+id,
    		    	     dataType:'text',
    		    	     async:'ture',
    		    	     success:function(){
    		    	    	/*  alert(res); */
    		    	    	 },
    			         error:function(){alert("请联系管理员");}
    		    /*   }
    		    		  )
  	   */
    }
 )
 }
   function gz(followid,userid){
	  /*  alert(userid);
	   alert(followid); */
	       $.ajax({
	    	     type:'post',
	    	     url:'gzservlet',
	    	     data:{"userid":userid,"followid":followid},
	    	     dataType:'text',
	    	     async:'ture',
	    	     success:function(){
	    	   
	    	    	 },
		         error:function(){alert("请联系管理员");}

}
) 
   }
   
   function ZF(wbid){
	 	       
		      $.ajax({
		    	     type:'post',
		    	     url:'zfservlet',
		    	     data:'wbid='+wbid,
		    	     dataType:'text',
		    	     async:'ture',
		    	     success:function(){
		    	    	  
		    	    	 },
			         error:function(){alert("请联系管理员");}
		     		    /*   }
   		    		  )
 	   */
}
)
	   
   }
 </script>




</head>
<body>
	<nav class="navbar  navbar-fixed-top" role="navigation"
		style="background: rgba(255,255,255,0.5) ;padding-top: 3px;height:50px;">
	<div class="container-fluid"
		style="background: rgba(255, 255, 255, 0.5)">
		<div class="navbar-header ">
			<span class="navbar-brand ">FangHao WEIBO</span>

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#my-navbar-collapse">
				<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>
		<form   action="queryservlet" method="post" class="navbar-form navbar-left" role="search" id="formid">
		        <div class="form-group">
		            <input name="topic" type="text" class="form-control" placeholder="#热门话题#" >
		            <i class="glyphicon glyphicon-search btn_search" ></i>
		             <button type="submit" class="btn btn-default" id="btn_submit" style="width: 50px;height: 20px ;color: black">提交</button> 
		        </div>
		        
		    </form>

		<div class="collapse navbar-collapse" id="my-navbar-collapse">

			<ul class="nav navbar-nav navbar-right">
				<li style="margin-top: 11px"><span id="sp"></span></li>
				<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;${ub.username}</a></li>

				<li class="dropdown"><a href="index.jsp"
					class="dropdown-toggle"> 注销 </a> <!--	
					<ul class="dropdown-menu">
						 <li><a href="index.jsp">注销</a></li> 

					</ul>--></li>
			</ul>

		</div>


	</div>
	<hr style="margin: 0; padding: 0; color: #222; width: 100%">
	</nav>

	<div class="container container_bg">
		<div class="row">
			<div class="col-sm-2"></div>

			<div class="col-sm-6 col-xs-12 my_edit">
				<div class="row" id="edit_form">
					<span class="pull-left" style="margin: 15px;">编写新鲜事</span> <span
						class="tips pull-right" style="margin: 15px;"></span>
					<form role="form" style="margin-top: 50px;" action="fbwb.do"
						method="post" enctype="multipart/form-data">
						<div class="form-group">
							<div class="col-sm-12">

								<input id="fbContent" name="fbContent" />

								<!-- <div contentEditable="true" id="content" class="form-control "
									style="background: rgba(255, 255, 255, 0.5)"></div>  -->
							</div>
							<div class="col-sm-12" style="margin-top: 12px;">
								<span class="pic">图片 </span>
								<div style="width: 50px; height: 50px; margin: -20px 80px;"
									id="localImag">
									<img src="" id="preview" alt="">
								</div>
								<span> <input type="file" id="doc" name="img"
									class="select_Img" style="display: none"> <img
									class="preview" src="">
								</span>


								<div class="myEmoji">
									<ul id="myTab" class="nav nav-tabs">
										<li class="active"><a href="#set" data-toggle="tab">
												预设 </a></li>
										<li><a href="#hot" data-toggle="tab">热门</a></li>

									</ul>
									<div id="myTabContent" class="tab-content">
										<div class="tab-pane fade in active" id="set">
											<div class="emoji_1"></div>

										</div>
										<div class="tab-pane fade" id="hot">
											<div class="emoji_2"></div>
										</div>

									</div>
								</div>
								<!-- <span> <input type="file" id="selectImg" value=""></input> </span> -->
								<input type="submit" id="send"
									class="btn btn-default pull-right " value="发布">
							</div>
						</div>
					</form>
				</div>


				<div class="row item_msg">
					<c:forEach items="${wbs }" var="wb">
						<div class="col-sm-12 col-xs-12 message">
						<input value="关注" type="button" style="margin-left: 10px;color: black;"onclick="gz(${ub.userid},${wb.userid})"/>
							<img src="${wb.role }" class="col-sm-2 col-xs-2"
								style="border-radius: 50%">
							<div class="col-sm-10 col-xs-10">
								<span style="font-weight: bold;">${wb.username }</span> <br>
								<small class="date" style="color: #999"></small>
								<div class="msg_content">${wb.content }
									<c:if test="${wb.img!='' }">
										<img class="mypic" src="${wb.img }">
									</c:if>
								</div>
								<div class="col-sm-12 col-xs-12 message">
									<ul style="list-style: none">
										<li style="margin-left: 20px; float: left;"><input
											type="button" id="${wb.wbid }btn2"
											value="点赞(${wb.dzsum })"
											onclick="dz(this.id,${wb.wbid})" /></li>
										<li style="float: left;margin-left: 20px;list-style:none">
  		   			                  <input type = "button" id = "btn3" name="${wb.wbid }" onclick="show(this.name)" value = "评论(${wb.pinglun})" />
  		   			                 <br/>
  		   			             </li>	
										<li style="float: left; margin-left: 50px">
											<input type="button" id="${wb.wbid}btn1" value="转发"
											onclick="ZF(${wb.wbid})" />

										</li>
									</ul>
									<div style="margin-top:20px ;" id="${wb.wbid}" hidden="hidden" >
		   			        
		   			          <c:forEach items="${wb.coms}" var="c1">
		   			             <c:if test="${wb.coms.size()!=0}">
		   			             <p>${c1.time}</p>
		   			             <span>${c1.username}:${c1.content}</span>
		   			             	
  		   			             </c:if>	   
		   			          
		   			              
		   			          
		   			          </c:forEach>
		   			        
		   			        </div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>


			<div class="col-sm-3 col-xs-12 part_right">
				<div class="row text-center inform">
					<a href="Indual.do"><img src="${ub.role }"></a>
					<h4 style="font-weight: bold;">${ub.username }</h4>
					<div class="col-sm-12 my_inform">
						<div class="col-sm-4 col-xs-4">
							<div>${fo}</div>
							<div class="sort">
								<a href="#">关注</a>
							</div>

						</div>
						<div class="col-sm-4 col-xs-4">
							<div>${fz }</div>
							<div class="sort">
								<a href="#">粉丝</a>
							</div>
						</div>
						<div class="col-sm-4 col-xs-4">
							<div>${wbsum}</div>
							<div class="sort">
								<a href="Indual.do">微博</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row part_hot">
					<div class="col-sm-12">
						<span class="pull-left"
							style="padding: 10px; font-size: 16px; font-weight: bold;">热门话题</span>
						<span class="pull-right" style="padding: 10px;">换话题</span>
					</div>
					<hr style="margin: 0; padding: 0; width: 100%">
					<div class="hot-add">
					<c:forEach items="${topic}" var="t">
						<div class="col-sm-12 item_hot">
							<span class="pull-left"><a href="topic_check.jsp">#${t.topic }#</a></span>
							<span class="pull-right item_num">34.6亿</span>
	  					</div>
	               </c:forEach>
						<div class="col-sm-12 item_hot">
							<span class="pull-left"><a
								href="http://wenjing.ytu.edu.cn/">#烟台大学文经学院#</a></span> <span
								class="pull-right item_num">2.6亿</span>
						</div>
	
						<div class="col-sm-12 item_hot">
							<span class="pull-left"><a href="http://pop.weibo.com/">#亚洲新歌榜#</a></span>
							<span class="pull-right item_num">10.4亿</span>
						</div>
	
						<div class="col-sm-12 item_hot">
							<span class="pull-left"><a
								href="https://wenda.so.com/q/1375843984067396?src=150">#健身的方法#</a></span>
							<span class="pull-right item_num">1.5亿</span>
						</div>
	
		
					</div>
					<hr style="margin: 0; padding: 0; width: 100%">

					<div class="col-sm-12 text-center" style="padding: 10px">
						<a href="#">查看更多</a>
					</div>

				</div>

			</div>
		</div>
	

	</div>
	<!-- <script src="js/jquery-3.1.0.js"></script> -->
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {

			$("#content").keyup(
					function() {

						//判断输入的字符串长度
						var content_len = $("#content").text().replace(/\s/g,
								"").length;

						$(".tips").text("已经输入" + content_len + "个字");

						if (content_len == 0) {
							// alert(content);
							$(".tips").text("");
							$("#send").addClass("disabled");
							return false;
						} else {
							$("#send").removeClass("disabled");
						}
					});

			$(".pic").click(function() {

				$(".select_Img").click();

			})

			// 	function confirm(){

			// 		var r= new FileReader();
			// f=$(".select_Img").files[0];
			// r.readAsDataURL(f);
			// r.onload=function(e) {
			// 	$(".preview").src=this.result;

			// };
			// 	}

			//点击按钮发送内容
			$("#send")
					.click(
							function() {

								// var myDate = new Date();

								//   var min = myDate.getMinutes();

								//   var time = min-(min-1);

								//   //alert(time);

								var content = $("#content").html();

								//判断选择的是否是图片格式		 
								var imgPath = $(".imgPath").text();
								var start = imgPath.lastIndexOf(".");
								var postfix = imgPath.substring(start,
										imgPath.length).toUpperCase();

								if (imgPath != "") {

									if (postfix != ".PNG" && postfix != ".JPG"
											&& postfix != ".GIF"
											&& postfix != ".JPEG") {
										alert("图片格式需为png,gif,jpeg,jpg格式");
									} else {
										$(".item_msg")
												.append(
														"<div class='col-sm-12 col-xs-12 message' > <img src='img/icon.png' class='col-sm-2 col-xs-2' style='border-radius: 50%'><div class='col-sm-10 col-xs-10'><span style='font-weight: bold;''>Jack.C</span> <br><small class='date' style='color:#999'>刚刚</small><div class='msg_content'>"
																+ content
																+ "<img class='mypic' onerror='this.src='img/bg_1.jpg' src='file:///"+imgPath+"' ></div></div></div>");
									}
								} else {
									$(".item_msg")
											.append(
													"<div class='col-sm-12 col-xs-12 message' > <img src='img/icon.png' class='col-sm-2 col-xs-2' style='border-radius: 50%'><div class='col-sm-10 col-xs-10'><span style='font-weight: bold;''>Jack.C</span> <br><small class='date' style='color:#999'>刚刚</small><div class='msg_content'>"
															+ content
															+ "</div></div></div>");
								}

							});

			//添加表情包1
			for (var i = 1; i < 60; i++) {

				$(".emoji_1")
						.append(
								"<img src='img/f"+i+".png' style='width:35px;height:35px' >");
			}
			//添加表情包2
			for (var i = 1; i < 61; i++) {

				$(".emoji_2")
						.append(
								"<img src='img/h"+i+".png' style='width:35px;height:35px' >");
			}

			$(".emoji")
					.click(
							function() {

								$(".myEmoji").show();

								//点击空白处隐藏弹出层
								$(document)
										.click(
												function(e) {

													if (!$("#edit_form").is(
															e.target)
															&& $("#edit_form")
																	.has(
																			e.target).length === 0) {

														$(".myEmoji").hide();
													}
												});

							});

			//将表情添加到输入框
			$(".myEmoji img")
					.each(
							function() {
								$(this)
										.click(
												function() {
													var url = $(this)[0].src;

													$('#content')
															.append(
																	"<img src='"+url+"' style='width:25px;height:25px' >");

													$("#send").removeClass(
															"disabled");
												})
							})

			//放大或缩小预览图片
			$(".mypic").click(function() {
				var oWidth = $(this).width(); //取得图片的实际宽度  
				var oHeight = $(this).height(); //取得图片的实际高度  

				if ($(this).height() != 200) {
					$(this).height(200);
				} else {
					$(this).height(oHeight + 200 / oWidth * oHeight);

				}

			})

		})
		    	function show(name){
			var div=document.getElementById(name);
			var $div=$(div);
			$div.toggle();
			
		}
	</script>
</body>
</html>