<%@ tag language="java" pageEncoding="UTF-8"%>

<table class="table table-striped" id="admintable">
  	
</table>
<script>
	$.post({
		"data":{"user_id": getCookie("userID")},
		"url":"SearchUserServlet",// TODO
		"success": function(response, status, xhr) {
			var obj = document.getElementById("admintable");
			//response为一个json
			for (var key in response) {
				var target_str = "<tr><th>" + key + "</th><th>" + response[key]  + "</th></tr>";
				obj.innerHTML += target_str;
			}
		},
		"dataType":"json"
	})
</script>