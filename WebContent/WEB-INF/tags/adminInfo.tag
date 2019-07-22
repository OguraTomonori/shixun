<%@ tag language="java" pageEncoding="UTF-8"%>

<table class="table table-striped" id="admintable">
	<tbody>
	  	<tr>
			<th class="text-center">左边</th><th class="text-center">みぎ</th>
		</tr>
		<tr>
			<th class="text-center">ひだり</th><th class="text-center">右边</th>
		</tr>
		<tr >
			<th>left</th><th>right</th>
		</tr>
		<tr class="text-center">
			<th>right</th><th>left</th>
		</tr>
	</tbody>

</table>
<script>
	alert("du");
	$.post({
		"data":{"user_id": getCookie("userID")},
		"url":"Temp",// TODO
		"success": function(response, status, xhr) {
			alert("dasssss");
			var obj = document.getElementById("admintable");
			//response为一个json
			for (var key in response) {
				var target_str = "<tr><th class=\"text-center\">" + key + "</th><th class=\"text-center\">" + response[key]  + "</th></tr>";
				obj.innerHTML += target_str;
			}
		}
	})
</script>