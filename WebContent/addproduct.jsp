<!--<%@ page language="java" contentType="text/html; charset=UTF-8" session="false" pageEncoding="UTF-8"%>-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Add Product</title>
<link rel="stylesheet" href="assets/css/footer.css" />
<link rel="stylesheet" href="assets/css/header.css" />
<link rel="stylesheet" href="assets/css/default.css" />
<link rel="stylesheet" href="assets/css/ReccomsndationProfilePage.css" />
<link href="https://fonts.googleapis.com/css?family=tittilium"
	rel="stylesheet" />
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous" />
<link href="https://fonts.googleapis.com/css?family=BioRhyme"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.css"
	integrity="sha512-MxCUiuI+uAXgr9Z9fxH1Y82CnqRrWySWqHejZyUMW55VJqL4trf9FXM/SiT7NQXZd4H0nJOr6FAAJTEjAmrm+A=="
	crossorigin="anonymous" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<section class="header">
		<section class="hamburgerbar">
			<i class="fa fa-bars fa-2x"></i>
		</section>
		<section class="logo-wrapper">
			<img src="assets/images/logo.png" alt="Recommedation System" />
		</section>

		<section class="menu-wrapper">
			<ul>
				<li><a href="home.jsp" id="active">Home</a></li>
				<li><a href="explore.jsp">Explore</a></li>
				<li><a href="aboutus.jsp">About us</a></li>
				<%
					HttpSession session = request.getSession(false);
				if (session != null && ((String) session.getAttribute("user")).equals("admin")) {

					String username = (String) session.getAttribute("user");

					out.print("<li class=user><a href=profile.jsp>" + username + "</a></li>");
					out.print("<li class=user><a href=LogoutServlet>Log Out</a></li>");
				} else {

					RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
					dispatcher.forward(request, response);

				}
				%>

			</ul>
		</section>
	</section>

	<div class="container">

		${message}



		<form action="AdminServlet" method="POST">
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Select Product Type </label>
				<div class="col-sm-10">
					<select class="custom-select" name="productType" id="productType"
						onchange="setProductFields()">
						<option selected="">None</option>
						<option value="cpu">Processor</option>
						<option value="mb">Motherboard</option>
						<option value="cab">Cabinet</option>
						<option value="ram">RAM</option>
						<option value="psu">Power Supply</option>
						<option value="hdd">Hard Disk Drive</option>
						<option value="ssd">Solid State Drive</option>
						<option value="gpu">Graphics Card</option>
					</select>
				</div>
			</div>
			<!--Brand-->
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Select Brand: </label>
				<div class="col-sm-10">
					<select class="custom-select" name="brandType" id="brandType">
						<option selected="">None</option>
					</select>
				</div>
			</div>
			<!---->

			<!--model-->
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Enter Model: </label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="modeltype"
						id="modeltype" />
				</div>
			</div>
			<!---->

			<!--CPU-->
			<div id="cpuSpecs">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">CPU Clock Speed: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="cpuSpeed"
							id="cpuSpeed" value=0 />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">CPU Cores: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="cpuCores"
							id="cpuCores" value=0 />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Socket Type: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="cpuSocket"
							id="cpuSocket" />
					</div>
				</div>
			</div>
			<!---->

			<!--Motherboard-->
			<div id="mbSpecs">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Board Chipset: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="mbChipset"
							id="mbChipset" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Memory Slots: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="mbSlots"
							id="mbSlots" value=0 />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Socket Type: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="mbSocket"
							id="mbSocket" />
					</div>
				</div>
			</div>
			<!---->

			<!--RAM-->
			<div id="ramSpecs">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Speed: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="ramSpeed"
							id="ramSpeed" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Size: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="ramSize"
							id="ramSize" value=0 />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Ram Type: </label>
					<div class="col-sm-10">
						<select class="custom-select" name="ramType" id="ramType">
							<option selected="">DDR3</option>
							<option selected="">DDR4</option>
						</select>
					</div>
				</div>
			</div>
			<!---->

			<!--GPU-->
			<div id="gpuSpecs">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Speed: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="gpuSpeed"
							id="gpuSpeed" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Chipset: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="gpuChipset"
							id="gpuChipset" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">GPU Type: </label>
					<div class="col-sm-10">
						<select class="custom-select" name="gpuType" id="gpuType">
							<option selected="">DDR3</option>
							<option selected="">DDR4</option>
							<option selected="">DDR5</option>
						</select>
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Interface: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="gpuInterface"
							id="gpuInterface" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">GPU Size: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="gpuSize"
							id="gpuSize" value=0 />
					</div>
				</div>
			</div>
			<!---->

			<!--PSU-->
			<div id="psuSpecs">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Power: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="psuWatts"
							id="psuWatts" placeholder="in watts" value=0 />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Efficiency: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="psuEfficiency"
							id="psuEfficiency" />
					</div>
				</div>
			</div>
			<!---->

			<!--HDD-->
			<div id="hddSpecs">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">RPM: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="hddSpeed"
							id="hddSpeed" value=0 />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Storage Size: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="hddSize"
							id="hddSize" value=0 />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Storage Interface: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="hddInterface"
							id="hddInterface" />
					</div>
				</div>
			</div>
			<!---->

			<!--SSD-->
			<div id="ssdSpecs">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Storage Size: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="ssdSize"
							id="ssdSize" value=0 />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Storage Interface: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="ssdInterface"
							id="ssdInterface" />
					</div>
				</div>
			</div>
			<!---->

			<!--URL-->
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Enter Product URL: </label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="pURL" id="pURL" />
				</div>
			</div>
			<!---->

			<div class="form-group row">
				<div class="col-sm-10 offset-sm-2">
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</div>
		</form>


	</div>

	<section class="footer">
		<section class="social_links">
			<i class="fa fa-facebook"></i> <i class="fa fa-instagram"></i> <i
				class="fa fa-twitter"></i>
		</section>
		<section class="f_info">
			<section class="f_info1">
				<h1>About Us</h1>
				<span> Builts by Price </span>| <span> Parts </span>| <span>
					Game Criteria </span>| <span> Prebuilts Recommendations </span> <br /> <br />
				<h1>Contact Us</h1>
				<i class="fa fa-phone" style="margin-right: 10px"></i>&nbsp;<span>+919974435870</span>
				<br /> <i class="fa fa-envelope" style="margin-right: 10px"></i>&nbsp;<span>Recommendation@gmail.com</span>
			</section>

			<section class="newslatter">
				<h1>Subscribe for NewsLetters</h1>
				<input type="email" placeholder="Your E-mail Address" /> <br />
				<button onclick="subscribe()">Subscribe</button>
			</section>
		</section>
	</section>

	<script type="text/javascript">
		//on load

		function hideAll() {
			$("#cpuSpecs").hide();
			$("#gpuSpecs").hide();
			$("#ramSpecs").hide();
			$("#mbSpecs").hide();
			$("#psuSpecs").hide();
			$("#ssdSpecs").hide();
			$("#hddSpecs").hide();
		}

		hideAll();

		function setProductFields() {
			let p_type = $("#productType").val();

			switch (p_type) {
			case "cpu":
				hideAll();
				$("#cpuSpecs").show();
				break;
			case "gpu":
				hideAll();
				$("#gpuSpecs").show();
				break;
			case "ram":
				hideAll();
				$("#ramSpecs").show();
				break;
			case "mb":
				hideAll();
				$("#mbSpecs").show();
				break;
			case "psu":
				hideAll();
				$("#psuSpecs").show();
				break;
			case "ssd":
				hideAll();
				$("#ssdSpecs").show();
				break;
			case "hdd":
				hideAll();
				$("#hddSpecs").show();
				break;

			default:
				hideAll();
			}

			let data = {
				cpu : [ "Amd", "Intel" ],
				mb : [ "Asus", "Gigabyte", "ASRock", "MSI" ],
				cab : [ "NZXT", "Corsair", "Thermaltake", "Phanteks",
						"Cooler Master" ],
				ram : [ "Corsair", "G.Skill", "kingston", "Crusial" ],
				gpu : [ "Zotac", "NVIDIA", "MSI", "EVGA", "ASUS", "Gigabyte" ],
				psu : [ "EVGA", "Seasonic", "Corsair", "Thermaltake" ],
				hdd : [ "Segate", "WD(Western Digital)", "Toshiba" ],
				ssd : [ "Samsung", "Corsair" ]
			};

			let dropdown = document.getElementById("brandType");
			dropdown.length = 0;

			let option;
			for (let i = 0; i < data[p_type].length; i++) {
				option = document.createElement("option");
				option.text = data[p_type][i];
				dropdown.add(option);
			}
		}
	</script>
</body>
</html>
