function insert() {
	var type = $("#type").val();
	var name = $("#txt_name").val();
	var remain = $("#txt_remain").val();
	var max_number = $("#txt_max_number").val();
	var teacher_id = $("#teacher_id").val();
	var classroom_id = $("#classroom_id").val();
	var classroom_name = $("#txt_classroom_name").val();
	var params = {
		"type" : type,
		"name" : name,
		"remain" : remain,
		"max_number" : max_number,
		"teacher_id" : teacher_id,
		"classroom_id" : classroom_id,
		"classroom_name" : classroom_name
	};
	$.get("/lession/do_insert", params, function(resp) {
		window.location.href = "/user/first";
	});
}
function initTeacherList() {
	$.get("/teacher/getTeacherList", function(data) {
		for ( var i in data) {
			var teacher = data[i];
			var option = '<option value="' + teacher.id + '">' + teacher.name
					+ '</option>';
			$("#teacher_id").append(option);
		}
	});
}
function initClassroomList() {
	$.get("/classroom/getClassroomList", function(data) {
		for ( var j in data) {
			var classroom = data[j];
			var option = '<option value="' + classroom.id + '">'
					+ classroom.name + '</option>'
			$("#classroom_id").append(option);
		}
	});
}
$(document).ready(function() {
	$("#btn_insert").click(insert);
	initTeacherList();
	initClassroomList();
});