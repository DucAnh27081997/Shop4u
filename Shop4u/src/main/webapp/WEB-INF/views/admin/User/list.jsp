<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row" id="result"></div>

<button type="button" class="btn btn-default" data-toggle="modal"
	data-target="#modal-default">Add</button>
<table class="table">
	<thead class="thead-light">
		<tr>
			<th scope="col">id</th>
			<th scope="col">Sản Phẩm</th>
			<th scope="col">Ảnh</th>
			<th scope="col">Giá</th>
			<th scope="col">detail</th>
			<th scope="col">tool</th>
		</tr>
	</thead>
	<tbody id="table-data">

	</tbody>
</table>
<div class="modal fade in" id="modal-default">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h5 class="modal-title">Thêm sản phẩm</h5>
			</div>
			<div class="modal-body">

				<div class="box-body">
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">Tên sản phẩm</label> <input
							type="text" class="form-control" id="name-new"
							placeholder="Tên sản phẩm">
					</div>
					<div class="form-group col-md-6">
						<label for="exampleInputPassword1">giá</label> <input type="text"
							class="form-control" id="cost-new" placeholder="giá">
					</div>
					<div class="form-group col-md-12">
						<label for="exampleInputEmail1">đường dẫn ảnh</label> <input
							type="text" class="form-control" id="img-new"
							placeholder="đường dẫn ảnh">
					</div>
					<div class="form-group col-md-12">
						<label for="exampleInputPassword1">chi tiết</label> <input
							type="text" class="form-control" id="detail-new"
							placeholder="chi tiết">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="addUser()">Add New</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<!-- Modan edit -->


<div class="modal fade in" id="modal-edit">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h5 class="modal-title">Chi tiêt sản phẩm <b style="coloer:red" id="id_number"></b></h5>
			</div>
			<div class="modal-body">

				<div class="box-body">
					<input type="hidden" id="id-edit">
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">username</label> <input
							type="text" class="form-control" id="name-edit"
							placeholder="Tên sản phẩm">
					</div>
					<div class="form-group col-md-6">
						<label for="exampleInputPassword1">email</label> <input type="text"
							class="form-control" id="cost-edit" placeholder="giá">
					</div>
					<div class="form-group col-md-12">
						<label for="exampleInputEmail1">rule</label> <input
							type="text" class="form-control" id="img-edit"
							placeholder="đường dẫn ảnh">
					</div>
					<div class="form-group col-md-12">
						<label for="exampleInputPassword1">enable</label> <input
							type="text" class="form-control" id="detail-edit"
							placeholder="chi tiết">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="updateUser()">Update</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="hidenModaEdit()">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<script language="javascript" src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
<script>
		var list = null;
		var loadData = function(){
			$.ajax({
                    url : "../api/User",
					contentType: 'application/json',
                    type : "GET",
                    dataType: "json",                  
					success : function (result){
						result.forEach(element=> {
						var item = "<tr>"
							+ '<td scope="row">' + element.id + '</td>'
							+ '<td>' + element.username + '</td>'
							+ '<td>'+ element.email +'</td>'
							+ '<td><b>' + element.enable + ' VND</b></td>'
							+ '<td>' + element.rule + '</td>'
							+ '<th scope="col">'
							+ '<button class="btn btn-danger"onclick="deleteData('+ element.id +')">'
							+ '<i class="fa fa-trash" aria-hidden="true"></i>'
							+ '</button>'
							+ '<button class="btn btn-info" onclick="editUser(' + element.id + ')"><i class="fa fa-edit" aria-hidden="true"></i>'
							+ '</button>'
							+ '<button class="btn btn-sm btn-success"><i class="fas fa-check" aria-hidden="true"></i></button>'
							+ '</th></tr>';
							$("#table-data").append(item);
						});
                    },
					error: function (error) {
						$('#result').html("loi" + error.data);
					}
            });
		}
		
		var addUser = function(){			
			var User={
					name: $("#name-new").val(),
					img: $("#img-new").val(),
					detail : $("#detail-new").val(),
					cost :  parseFloat($("#cost-new").val())
			};
			$.ajax({
                    url : "../api/User",
                    type : "POST",
                    contentType: 'application/json',
    				data: JSON.stringify(User),                                
					success : function (result){
						$("#table-data").empty();
						loadData();					
                    },
					error: function (error) {
						console.log(JSON.stringify(User));
						$('#result').html("loi" + error.data);
					}
            });
		}
		
		var updateUser = function(){			
			var User={
					id: $("#id-edit").val(),
					name: $("#name-edit").val(),
					img: $("#img-edit").val(),
					detail : $("#detail-edit").val(),
					cost :  parseFloat($("#cost-edit").val())
			};
			$.ajax({
                    url : "../api/User",
                    type : "PUT",
                    contentType: 'application/json',
    				data: JSON.stringify(User),                                
					success : function (result){
						hidenModaEdit();
						$("#table-data").empty();
						loadData();					
                    },
					error: function (error) {
						$('#result').html("loi" + error.data);
					}
            });
		}
		
		var deleteData = function(id){
			$.ajax({
                    url : "../api/User/"+id,
                    type : "DELETE",
					success : function (result){
						$("#table-data").empty();
						loadData();
						console.log(result);
                    },
					error: function (error) {
						console.log("loi");
					}
            });
		}
		
		var editUser = function(id){
			$.ajax({
                    url : "../api/User/"+id,
                    type : "GET",
                    contentType: 'application/json',                            
					success : function (result){
						$("#id-edit").val(result.id);
						$("#name-edit").val(result.name);
						$("#img-edit").val(result.img);
						$("#detail-edit").val(result.detail);
						$("#cost-edit").val(result.cost.toString());
						$("#id_number").text(result.id);					
						$("#modal-edit").modal("toggle");
                    },
					error: function (error) {					
						$('#result').html("loi" + error.data);
					}
            });			
		}
		
		var hidenModaEdit= function(){
			$("#modal-edit").modal("toggle");
		}
		loadData();
</script>