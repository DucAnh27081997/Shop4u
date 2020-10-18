<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-md-12"><h3>name test: ${test.name}</h3></div>
	<div class="col-md-12">
		<b>link MP4: </b>
		<audio controls>
			<source src="${test.linkMP4}" type="audio/ogg">
			<source src="${test.linkMP4}" type="audio/mpeg">
		</audio>
	</div>
	<div class="col-md-12"><b>Ngày tạo:</b> ${test.dateCreate}</div>
</div>

<div class="row">
	<div class="col-md-12">
		<!-- Custom Tabs -->
		<div class="nav-tabs-custom">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#tab_1" data-toggle="tab"
					aria-expanded="true">Part 1</a></li>
				<li class=""><a href="#tab_2" data-toggle="tab"
					aria-expanded="false">Part 2</a></li>
				<li class=""><a href="#tab_3" data-toggle="tab"
					aria-expanded="false">Part 3</a></li>
				<li class=""><a href="#tab_4" data-toggle="tab"
					aria-expanded="false">Part 4</a></li>
				<li class=""><a href="#tab_5" data-toggle="tab"
					aria-expanded="false">Part 5</a></li>
				<li class=""><a href="#tab_6" data-toggle="tab"
					aria-expanded="false">Part 6</a></li>
				<li class=""><a href="#tab_7" data-toggle="tab"
					aria-expanded="false">Part 7</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> Dropdown
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Another action</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Something else here</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Separated link</a></li>
					</ul></li>
				<li class="pull-right"><a href="#" class="text-muted"><i
						class="fa fa-gear"></i></a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tab_1">
					<div class="row">
						<div class="col-md-6">
							<h3>Part I: Picture Description</h3>
						</div>
						<div class="col-md-6">
							<button type="button" class="btn btn-default pull-right"
								data-toggle="modal" data-target="#modal-default">Add</button>
						</div>
					</div>

					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col">id</th>
								<th scope="col">name</th>
								<th scope="col">file nghe</th>
								<th scope="col">ngay tao</th>
								<th scope="col">tool</th>
							</tr>
						</thead>
						<tbody id="table-data">
						</tbody>
					</table>
				</div>
				<!-- /.tab-pane -->
				<div class="tab-pane" id="tab_2">
					<h3>Part II: Question - Response</h3>
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col">id</th>
								<th scope="col">name</th>
								<th scope="col">file nghe</th>
								<th scope="col">ngay tao</th>
								<th scope="col">tool</th>
							</tr>
						</thead>
						<tbody id="table-data">

						</tbody>
					</table>
				</div>
				<!-- /.tab-pane -->
				<div class="tab-pane" id="tab_3">
					<h3>Part III: SHORT CONVERSATION</h3>
				</div>
				<div class="tab-pane" id="tab_4">
					<h3>PART IV: - Short Talk</h3>
				</div>
				<div class="tab-pane" id="tab_5">
					<h3>PART V: - Incomplete Sentence</h3>
				</div>
				<div class="tab-pane" id="tab_6">
					<h3>PART VI: Text Completion</h3>
				</div>
				<div class="tab-pane" id="tab_7">
					<h3>PART VII: Reading Archives</h3>
				</div>



				<!-- /.tab-pane -->
			</div>
			<!-- /.tab-content -->
		</div>
		<!-- nav-tabs-custom -->
	</div>
	<!-- /.col -->
</div>

<div class="modal fade in" id="modal-edit">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h5 class="modal-title">
					Chi tiêt sản phẩm <b style="color: red" id="id_number"></b>
				</h5>
			</div>
			<div class="modal-body">

				<div class="box-body">
					<input type="hidden" id="id-edit">
					<div class="form-group col-md-12">
						<label for="exampleInputEmail1">đường dẫn file âm thanh</label> <input
							type="text" class="form-control" id="name-edit"
							placeholder="đường dẫn file âm thanh">
					</div>
					<div class="form-group col-md-12">
						<label for="exampleInputPassword1"></label> <input type="text"
							class="form-control" id="cost-edit" placeholder="giá">
					</div>
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">A</label> <input type="text"
							class="form-control" id="name-edit"
							placeholder="đường dẫn file âm thanh">
					</div>
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">B</label> <input type="text"
							class="form-control" id="name-edit"
							placeholder="đường dẫn file âm thanh">
					</div>
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">C</label> <input type="text"
							class="form-control" id="name-edit"
							placeholder="đường dẫn file âm thanh">
					</div>
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">D</label> <input type="text"
							class="form-control" id="name-edit"
							placeholder="đường dẫn file âm thanh">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary"
					onclick="updateProduct()">Update</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal"
					onclick="hidenModaEdit()">Close</button>
			</div>
		</div>

		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<input type="text" id="id_test" value="${test.id}">
<script language="javascript"
	src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
<script>
	var list = null;
	var loadData = function (id) {
		$.ajax({
			url: "../../api/Part1/"+id,
			contentType: 'application/json',
			type: "GET",
			dataType: "json",
			success: function (result) {
				result.forEach(element => {
					var item = "<tr>"
						+ '<td scope="row">' + element.id + '</td>'
						+ '<td>' + element.linkImage + '</td>'
						+ '<td><audio controls><source src="' + element.linkMP4 + '" type="audio/mpeg"></audio></td>'
						+ '<td><<img class="img img-thum" alt="" src="' + element.linkImage + '"></td>'
						+ '<td>'
						+ '<span> A: ' + element.answer_A + ' </span>'
						+ '<span> B: ' + element.answer_B + ' </span>'
						+ '<span> C: ' + element.answer_C + ' </span>'
						+ '<span> D: ' + element.answer_D + ' </span>'
						+ '</td>'
						+ '<button class="btn btn-danger" onclick="deleteTest(' + element.id + ')">'
						+ '<i class="fa fa-trash" aria-hidden="true"></i>'
						+ '</button>'
						+ '<button class="btn btn-info" onclick="editProduct(' + element.id + ')"><i class="fa fa-edit" aria-hidden="true"></i>'
						+ '</button>'
						+ '<button class="btn btn-sm btn-success"><i class="fas fa-check" aria-hidden="true"></i></button>'
						+ '</td></tr>';
					$("#table-data").append(item);
				});
			},
			error: function (error) {
				$('#result').html("loi" + error.data);
			}
		});
	}

	var addTest = function () {
		var test = {
			name: $("#name-new").val(),
			linkMP4: $("#linkMP4-new").val(),
		};
		$.ajax({
			url: "../api/Test",
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify(test),
			success: function (result) {
				$("#table-data").empty();
				loadData();
			},
			error: function (error) {
				console.log(JSON.stringify(test));
				$('#result').html("loi" + error.data);
			}
		});
	}

	var updateQuestionPart1 = function (id) {
		var res = confirm("ban co muon xoa bai test " + id + "?");
		if (res == true) {
			$.ajax({
				url: "../../api/Test/" + id,
				type: "DELETE",
				contentType: 'application/json',
				success: function (result) {
					$("#table-data").empty();
					loadData();
				},
				error: function (error) {
					alert(error);
				}
			});
		}
	}
	var hidenModaEdit = function () {
		$("#modal-edit").modal("toggle");
	}
	loadData($("#id_test").val());
</script>