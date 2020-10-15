<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<option value="">All</option>
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
	<div class="modal-dialog modal-lg">
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
						<label for="exampleInputPassword1">chi tiết</label> 
						<textarea   row="6"  class="form-control" id="detail-new" placeholder="chi tiết">
							
						</textarea>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="addProduct()">Add
					New</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<!-- Modan edit -->
<div class="modal fade" id="modal-edit">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h5 class="modal-title">
					Chi tiêt sản phẩm <b style="coloer: red" id="id_number"></b>
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
						<label for="detail-edit">chi tiết</label> <textarea
							col="3" class="form-control" id="detail-edit"
							placeholder="chi tiết">
							</textarea>
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
	CKEDITOR.replace("detail-new");
	CKEDITOR.replace("detail-edit");
</script>
<script>
		var list = null;
		var loadData = function(){
			$.ajax({
                    url : "../api/Product",
					contentType: 'application/json',
                    type : "GET",
                    dataType: "json",                  
					success : function (result){
						result.forEach(element=>{
						var item = "<tr>"
							+ '<td scope="row">' + element.id + '</td>'
							+ '<td>' + element.name + '</td>'
							+ '<td><img src="'+ element.img +'" class="img img-rounded" alt="'+ element.img +'" width="100" height="100"></td>'
							+ '<td><b>' + element.cost + ' VND</b></td>'
							+ '<td>' + element.detail + '</td>'
							+ '<th scope="col">'
							+ '<button class="btn btn-danger"onclick="deleteData('+ element.id +')">'
							+ '<i class="fa fa-trash" aria-hidden="true"></i>'
							+ '</button>'
							+ '<button class="btn btn-info" onclick="editProduct(' + element.id + ')"><i class="fa fa-edit" aria-hidden="true"></i>'
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
		
		var addProduct = function(){			
			var product={
					name: $("#name-new").val(),
					img: $("#img-new").val(),
					detail : $("#detail-new").val(),
					cost :  parseFloat($("#cost-new").val())
			};
			$.ajax({
                    url : "../api/Product",
                    type : "POST",
                    contentType: 'application/json',
    				data: JSON.stringify(product),                                
					success : function (result){
						$("#table-data").empty();
						loadData();					
                    },
					error: function (error) {
						console.log(JSON.stringify(product));
						$('#result').html("loi" + error.data);
					}
            });
		}
		
		var updateProduct = function(){			
			var product={
					id: $("#id-edit").val(),
					name: $("#name-edit").val(),
					img: $("#img-edit").val(),
					detail : $("#detail-edit").val(),
					cost :  parseFloat($("#cost-edit").val())
			};
			$.ajax({
                    url : "../api/Product",
                    type : "PUT",
                    contentType: 'application/json',
    				data: JSON.stringify(product),                                
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
                    url : "../api/Product/"+id,
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
		
		var editProduct = function(id){
			$.ajax({
                    url : "../api/Product/"+id,
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
		
		var timkiem = function() {
			var tieuchi = $("#btn-tieuchi").val();
			var noidung = $("#text-search").val();
			var start = $("#result-start").val();
			var max = $("#result-limit").val();
			
			$.ajax({
                url : "../api/ProductByParameters",
                type : "POST",
                dataType: "json",              
                data: {key:tieuchi,value:noidung,begin:satrt,max:limit},    
				success : function (result){
					$("#table-data").empty();
					result.forEach(element=>{
					var item = "<tr>"
						+ '<td scope="row">' + element.id + '</td>'
						+ '<td>' + element.name + '</td>'
						+ '<td><img src="'+ element.img +'" class="img img-rounded" alt="'+ element.img +'" width="100" height="100"></td>'
						+ '<td><b>' + element.cost + ' VND</b></td>'
						+ '<td>' + element.detail + '</td>'
						+ '<th scope="col">'
						+ '<button class="btn btn-danger"onclick="deleteData('+ element.id +')">'
						+ '<i class="fa fa-trash" aria-hidden="true"></i>'
						+ '</button>'
						+ '<button class="btn btn-info" onclick="editProduct(' + element.id + ')"><i class="fa fa-edit" aria-hidden="true"></i>'
						+ '</button>'
						+ '<button class="btn btn-sm btn-success"><i class="fas fa-check" aria-hidden="true"></i></button>'
						+ '</th></tr>';
						$("#table-data").append(item);
					});
                },
				error: function (error) {
					alert("loi" + error);
				}
        });
		}
		
		// var getTotalRecords = function(){
		// 	$.ajax({
		// 		url : "../api/getTotalRecords",
        //         type : "GET",
        //         dataType: "json",              
		// 		success : function (result){
		// 				alert("Tong so trang"result);
		// 			});
        //         },
		// 		error: function (error) {
		// 			alert("loi" + error);
		// 		}
		// 	});
		// }
		
		// var phan_trang = function () {
		// 	  var total_records  = getTotalRecords();
		// 	  var limit = $("#result-limit").val();;
		// 	  var page = (total_records % limit)==0?(total_records / limit):(total_records / limit)+1;
		//       $("#page-number").empty();
		//       for (var i = 0; i < page ; i++) {	    	  
		//     	  var html = '<li class="paginate_button"><a href="#"aria-controls="example2" data-dt-idx="1" tabindex="0">'+ i +'</a></li>';
		//     	  $("#page-number").append(html);	
		//     	  $("#example2_info").text("Showing 1 to 10 of "+total_records+" entries")
		// 	}
		// }
		// phan_trang();
		loadData();
</script>
