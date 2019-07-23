<%@ tag language="java" pageEncoding="UTF-8"%>

<table class="table table-striped" id="admintable">
	<tbody>
	  	
	</tbody>

</table>
<script>
	$.post({
		"data":{"user_id": getCookie("userID"), "asdd": "ASDsada", "你好":"suck"},
		"url":"SearchAdminServlet",// TODO
		"success": function(response, status, xhr) {
			var obj = document.getElementById("admintable");
			//response为一个json
			for (var key in response) {
				var target_str = "<tr onclick=\"alert(\'rua\');\"><th class=\"text-center\">" + key + "</th><th class=\"text-center\">" + response[key]  + "</th></tr>";
				obj.innerHTML += target_str;
			}
		},
		"dataType":"json"
	});
</script>