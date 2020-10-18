<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="form-row">
		<div class="col">
			<label>name</label>
			<form:input class="form-control form-control-sm" path="username" />
			<p style="color: red">
				<form:errors path="username"></form:errors>
			</p>
		</div>

		<div class="col">
			<label>password</label>
			<form:input class="form-control form-control-sm" path="password" />
			<p style="color: red">
				<form:errors path="password"></form:errors>
			</p>
		</div>

		<div class="col">
			<label>email</label>
			<form:input class="form-control form-control-sm" path="email" />
			<p style="color: red">
				<form:errors path="email"></form:errors>
			</p>
		</div>

		<div class="col">
			<label>phonenumber</label>
			<form:input class="form-control form-control-sm" path="phonenumber" />
			<p style="color: red">
				<form:errors path="phonenumber"></form:errors>
			</p>
		</div>
	</div>
	<div class="form-row">
		<form:hidden path="id" />
		<!-- <div class="col-md-4">
			<label>role</label>
			<div class="form-check">
				<form:checkbox class="form-check-input" path="favourites" value="xem phim" />
				<label class="form-check-label" for="gridRadios1"> admin </label>
			</div>
			<div class="form-check">
				<form:checkbox class="form-check-input" path="favourites" value="code" />
				<label class="form-check-label" for="gridRadios1"> member </label>
			</div>
			<div class="form-check">
				<form:checkbox class="form-check-input" path="favourites" value="game" />
				<label class="form-check-label" for="gridRadios1"> user </label>
			</di -->v>
		</div>
		<div class="col-md-4">
			<label>gioi tinh</label>
			<form:select class="form-control" path="gender">
				<form:option value="Boy">Boy</form:option>
				<form:option value="Girl">Birl</form:option>
				<form:option value="Gay">Gay</form:option>
				<form:option value="Less">Less</form:option>
			</form:select>
		</div>
		<div class="col-md-4">
			<label>gioi tinh</label>
			<form:select class="form-control" path="role">
				<form:option value="ROLE_USER">SA</form:option>
				<form:option value="ROLE_ADMIN">admin</form:option>
				<form:option value="ROLE_MEMBER">member</form:option>
				<form:option value="ROLE_USER">user</form:option>
			</form:select>
		</div>
	</div>