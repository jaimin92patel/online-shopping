<div cass="container">

	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12"></div>

		<ol class="breadcrumb">
			<li><a href="${contextRoot}/home">Home</a></li>
			<li><a href="${contextRoot}/show/all/products">Products</a></li>
			<li class="active">${product.name}</li>
		</ol>
	</div>

	<div class="row">

		<!-- Display the Product Image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>

		<!-- Product Description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />
			
			<h4>
				Price: <strong> &#36; ${product.unitPrice} /-</strong>
			</h4>
			<hr/>		
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>Qty. Available: <span style="color:red;">Out Of Stock</span></h6>
				</c:when>
				<c:otherwise>
					<h6> Qty. Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike> 
					<span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</strike></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.id}/products"
				class="btn btn-success"> <span
				class="glyphicon glyphicon-shopping-cart"></span> Add to cart
			</a>
				</c:otherwise>
			</c:choose>
			

			 <a href="${contextRoot}/cart/add/${product.id}/products"
				class="btn btn-primary"> Back</a>

		</div>
	</div>

</div>