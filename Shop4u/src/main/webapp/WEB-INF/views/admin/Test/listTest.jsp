<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row" id="result"></div>
<div class="row">
	<div class="form-group col-xs-1">
		<select class="form-control" id="choise-page-number">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="40">40</option>
		</select>
	</div>
	<div class="form-group col-xs-2">
		<button type="button" class="btn btn-default" data-toggle="modal"
			data-target="#modal-default">Add</button>
	</div>
	<div class="form-group col-xs-2">
		<select class="form-control" id="btn-tieuchi">
			<option value="">All</option>
			<option value="name">ten san pham</option>
			<option value="cost">gia san pham</option>
			<option value="detail">chi tiết sản phẩm</option>
		</select>
	</div>
	<div class="form-group col-xs-3">
		<input id="text-search" type="text" class="form-control"
			placeholder="thông tin cần tìm kiếm">
	</div>
	<div class="form-group col-xs-2">
		<button type="button" class="btn btn-info" onclick="timkiem()">Search</button>
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


<div class="row">
	<div class="col-sm-5">
		<div class="dataTables_info" id="example2_info" role="status"
			aria-live="polite">Showing 1 to 10 of 57 entries</div>
	</div>
	<div class="col-sm-7">
		<div class="dataTables_paginate paging_simple_numbers"
			id="example2_paginate">
			<ul class="pagination" id="page-number">
				<li class="paginate_button previous disabled" id="example2_previous"><a
					href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>
				<li class="paginate_button active"><a href="#"
					aria-controls="example2" data-dt-idx="1" tabindex="0">1</a></li>
				<li class="paginate_button "><a href="#"
					aria-controls="example2" data-dt-idx="2" tabindex="0">2</a></li>
				<li class="paginate_button "><a href="#"
					aria-controls="example2" data-dt-idx="3" tabindex="0">3</a></li>
				<li class="paginate_button "><a href="#"
					aria-controls="example2" data-dt-idx="4" tabindex="0">4</a></li>
				<li class="paginate_button "><a href="#"
					aria-controls="example2" data-dt-idx="5" tabindex="0">5</a></li>
				<li class="paginate_button "><a href="#"
					aria-controls="example2" data-dt-idx="6" tabindex="0">6</a></li>
				<li class="paginate_button next" id="example2_next"><a href="#"
					aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>
			</ul>
		</div>
	</div>
</div>

<div class="modal fade in" id="modal-default">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h5 class="modal-title">Thêm bài test</h5>
			</div>
			<div class="modal-body">

				<div class="box-body">
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">Tiêu đề</label> <input
							type="text" class="form-control" id="name-new"
							placeholder="Tiêu đề">
					</div>
					<div class="form-group col-md-12">
						<label for="exampleInputEmail1">đường dẫn file nghe</label> <input
							type="text" class="form-control" id="linkMP4-new"
							placeholder="đường dẫn ảnh">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="addTest()">Add
					New</button>
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
				<h5 class="modal-title">
					Chi tiêt sản phẩm <b style="color: red" id="id_number"></b>
				</h5>
			</div>
			<div class="modal-body">

				<div class="box-body">
					<input type="hidden" id="id-edit">
					<div class="form-group col-md-6">
						<label for="exampleInputEmail1">Tên sản phẩm</label> <input
							type="text" class="form-control" id="name-edit"
							placeholder="Tên sản phẩm">
					</div>
					<div class="form-group col-md-6">
						<label for="exampleInputPassword1">giá</label> <input type="text"
							class="form-control" id="cost-edit" placeholder="giá">
					</div>
					<div class="form-group col-md-12">
						<label for="exampleInputEmail1">đường dẫn ảnh</label> <input
							type="text" class="form-control" id="img-edit"
							placeholder="đường dẫn ảnh">
					</div>
					<div class="form-group col-md-12">
						<label for="exampleInputPassword1">chi tiết</label> <input
							type="text" class="form-control" id="detail-edit"
							placeholder="chi tiết">
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
<script language="javascript" src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
<script>
		var list = null;
		var loadData = function(){
			$.ajax({
                    url : "../api/Test",
					contentType: 'application/json',
                    type : "GET",
                    dataType: "json",                  
					success : function (result){
						result.forEach(element=>{
						var item = "<tr>"
							+ '<td scope="row">' + element.id + '</td>'
							+ '<td>' + element.name + '</td>'				
							+ '<td><audio controls><source src="' + element.linkMP4 + '" type="audio/mpeg"></audio></td>'
							+ '<td><b>' + (new Date(element.dateCreate)).toLocaleString() + '</b></td>'
							+ '<td>'
							+ '<button class="btn btn-danger" onclick="deleteTest('+ element.id +')">'
							+ '<i class="fa fa-trash" aria-hidden="true"></i>'
							+ '</button>'
							+ '<a class="btn btn-info" href="./chi-tiet-bai-test/'+element.id+'"><i class="fa fa-edit" aria-hidden="true"></i>'
							+ '</a>'
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
		
		var addTest = function(){			
			var test={
					name: $("#name-new").val(),
					linkMP4: $("#linkMP4-new").val(),				
			};
			$.ajax({
                    url : "../api/Test",
                    type : "POST",
                    contentType: 'application/json',
    				data: JSON.stringify(test),                                
					success : function (result){
						$("#table-data").empty();
						loadData();					
                    },
					error: function (error) {
						console.log(JSON.stringify(test));
						$('#result').html("loi" + error.data);
					}
            });
		}
		
		var deleteTest = function(id){		
			var res = confirm("ban co muon xoa bai test "+id+"?");
			if(res==true){
				$.ajax({
                    url : "../api/Test/"+id,
                    type : "DELETE",
                    contentType: 'application/json',                              
					success : function (result){
						$("#table-data").empty();
						loadData();					
                    },
					error: function (error) {
						alert(error);
					}
            });
			}	
		}
		var hidenModaEdit= function(){
			$("#modal-edit").modal("toggle");
		}
		loadData();
</script>
