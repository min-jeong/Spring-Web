<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/board/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="/board/js/sockjs-1.0.3.min.js"></script>
<script type="text/javascript">
	
	var chatSock = null;
	var message = {};
	
	$(document).ready(function() {
		// 페이지가 열림과 동시에 소켓으로 연결한다.
		chatSock = new SockJS("/board/echo-ws");
		chatSock.onopen = function() {
			message = {};
			message.message = "내가 왔다";
			message.type = "all";
			message.to = "all";
			chatSock.send(JSON.stringify(message));
		};
		
		chatSock.onclose = function() { //close 된 이후라 뜨지 않는다.
			//sock.send("10.225.152.179 퇴장");
		};
		
		chatSock.onmessage = function(evt) {
			//alert(evt.data);
			$("#chatMessage").append(evt.data + "<br/>");
			$("#chatMessage").scrollTop(99999999);
		};
		
		$("#sendMessage").click(function() {
			if ( $("#message").val() != "" ){
				message = {};
				message.message = $("#message").val();
				message.type = "all";
				message.to = "all";
				
				var to = $("#to").val();
				if( to != "" ){
					message.type="one";
					message.to = to;
				} 
				
				chatSock.send(JSON.stringify(message));
				$("#chatMessage").append( "^&^ -> " + $("#message").val() + "<br/>");
				$("#chatMessage").scrollTop(99999999);
				$("#message").val("");
			}
		});
	});
	
</script>
</head>
<body>
MIN JUNG CHAT
	<br/>
	<input type="text" id="to" />
	<input type="text" id="message" />
	<input type="button" id="sendMessage" value="메시지 보내기" />
	
	<div  id="chatMessage" style="overflow: auto; max-height: 500px; background-color:#f8f8f8;">
	
	</div>
</body>
</html>