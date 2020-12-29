<%@ page language="java" contentType="text/html; charset=UTF-8" session="false" pageEncoding="UTF-8"%>
<%@ page import="users.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="assets/css/header.css">
<link rel="stylesheet" href="assets/css/default.css">
<link rel="stylesheet" href="assets/css/filter.css">
<link rel="stylesheet" href="assets/css/slider.css">
<link rel="stylesheet" href="assets/css/checkbox.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Customise</title>


</head>


<body>
	<div id="overlay"></div>
	<!------------------------------------------>
	<section class="header">
		<section class="hamburgerbar">
			<i class="fa fa-bars fa-2x"></i>
		</section>
		<section class="logo-wrapper">

			<img src="assets/images/logo.png" alt="Recommedation System">

		</section>

		<section class="menu-wrapper">
			<ul>
				<li><a href="home.jsp" id="active">Home</a></li>
				<li><a href="#">Explore</a></li>
				<li><a href="aboutus.jsp">About us</a></li>
				<%
					HttpSession session = request.getSession(false);
				if (session == null) {
					response.sendRedirect(request.getContextPath() + "/home");

				} else {
					User user = (User) session.getAttribute("user");
					out.print("<li class=user><a href=profile.jsp>" + user.getUsername() + "</a></li>");
					out.print("<li class=user><a href=LogoutServlet>Log Out</a></li>");
				}
				%>

			</ul>
		</section>
	</section>

	<!------------------------------------------>

	<div class="fcontainer">
		<div class="categories">
			<h1>Choose Your Preferences</h1>
			</br>
			<form action="PCBuilder" method="POST" onsubmit="turnon()">
				<!--Gaming pc----------------------------------------->
				<div class="gaming" id="gaming">
					<span class="cat">Gaming</span>

					<!--Questions- gaming------------------------------->
					<div class="question gaming">
						<h2>Select atleast 3 games you'd like to play</h2>

						<div class="games">
							<ul>
								<li><input type="checkbox" id="cb1" name="game"
									value="csgo" /> <label for="cb1"><img
										src="assets/images/csgo.jpg" /></label></li>
								<li><input type="checkbox" id="cb2" name="game"
									value="cyberpunk" /> <label for="cb2"><img
										src="assets/images/cyberpunk2077.jpg" /></label></li>
								<li><input type="checkbox" id="cb3" name="game" value="gta" />
									<label for="cb3"><img src="assets/images/gta.jpg" /></label></li>
								<li><input type="checkbox" id="cb4" name="game"
									value="creed" /> <label for="cb4"><img
										src="assets/images/creed.jpg" /></label></li>

								<li><input type="checkbox" id="cb5" name="game"
									value="farcry" /> <label for="cb5"><img
										src="assets/images/farcry.jpg" /></label></li>

								<li><input type="checkbox" id="cb6" name="game"
									value="hitman" /> <label for="cb6"><img
										src="assets/images/hitman2.jpg" /></label></li>

								<li><input type="checkbox" id="cb7" name="game"
									value="cuphead" /> <label for="cb7"><img
										src="assets/images/cuphead.jpg" /></label></li>

								<li><input type="checkbox" id="cb8" name="game"
									value="pubg" /> <label for="cb8"><img
										src="assets/images/pubg.webp" /></label></li>
							</ul>

						</div>
					</div>

					<div class="question">
						<h2>how many hours do you play games?</h2>
						<!--Slider code------------------------------->
						<div class="range">
							<div class="sliderValue">
								<span class="output">100</span>
							</div>
							<div class="field">
								<div class="value left">1</div>
								<input type="range" class="slider" min="0" max="5" value="0"
									steps="1" name="gamingHoursSlider" value="">
								<div class="value right">5</div>
							</div>
						</div>
						<!------------------------------------------->
					</div>

					<div class="question">
						<h2>what do you prefer more in your games?</h2>
						<!--Slider code------------------------------->
						<div class="range">
							<div class="sliderValue">
								<span class="output">100</span>
							</div>
							<div class="field">
								<div class="value left">Performance</div>
								<input type="range" class="slider" min="0" max="10" value="0"
									steps="1" name="gamingPQSlider" value=""
									style="margin-left: 40%; margin-right: 12%;">
								<div class="value right">Quality</div>
							</div>
						</div>
						<!------------------------------------------->
					</div>
					<!-------------------------------------------------->

				</div>
				<!---------------------------------------------------->


				<!------Casual PC-------------------->
				<div class="casual" id="casual" style="display: none;">
					<span class="cat">Casual</span></br>

					<div class="questions">
						<h2>How likely would you do the following on your PC on
							regular basis</h2>
						<!--Questtion----------------------->
						<div class="question">
							<h2>
								Movies
								<h2>
									<!--Slider code------------------------------->
									<div class="range">
										<div class="sliderValue">
											<span class="output">100</span>
										</div>
										<div class="field">
											<div class="value left">0</div>
											<input type="range" class="slider" min="0" max="5" value="0"
												steps="1" name="casualMovieSlider" value="">
											<div class="value right">5</div>
										</div>
									</div>
								</h2>
							</h2>
							<!------------------------------------------->
						</div>
						<!----------------------------->

						<!--Questtion----------------------->
						<div class="question">
							<h2>
								Office Work
								<h2>

									<!--Slider code------------------------------->
									<div class="range">
										<div class="sliderValue">
											<span class="output">100</span>
										</div>
										<div class="field">
											<div class="value left">0</div>
											<input type="range" class="slider" min="0" max="5" value="0"
												steps="1" name="casualOfficeSlider" value="">
											<div class="value right">5</div>
										</div>
									</div>

								</h2>
							</h2>
							<!------------------------------------------->
						</div>
						<!----------------------------->

						<!--Questtion----------------------->
						<div class="question">
							<h2>
								Internet
								<h2>
									<!--Slider code------------------------------->
									<div class="range">
										<div class="sliderValue">
											<span class="output">100</span>
										</div>
										<div class="field">
											<div class="value left">0</div>
											<input type="range" class="slider" min="0" max="5" value="0"
												steps="1" name="casualInternetSlider" value="">
											<div class="value right">5</div>
										</div>
									</div>

								</h2>
							</h2>
							<!------------------------------------------->
						</div>
						<!----------------------------->
					</div>
				</div>
				<!---------------------------------------------------->


				<!--------Designing------------------------------------------------->
				<div class="designing" id="designing" style="display: none;">
					<span class="cat">Designing</span>

					<!--Questions- software------------------------------->
					<div class="question software">
						<h2>Select atleast 3 Programs you use the most</h2>

						<div class="softwares">
							<ul>
								<li><input type="checkbox" id="db1" name="designSoftware"
									value="maya" /> <label for="db1"><img
										src="assets/images/maya.jpg" /></label></li>
								<li><input type="checkbox" id="db2" name="designSoftware"
									value="blender" /> <label for="db2"><img
										src="assets/images/blender.jpg" /></label></li>
								<li><input type="checkbox" id="db3" name="designSoftware"
									value="aftereffects" /> <label for="db3"><img
										src="assets/images/ae.webp" /></label></li>
								<li><input type="checkbox" id="db4" name="designSoftware"
									value="photoshop" /> <label for="db4"><img
										src="assets/images/ps.jpg" /></label></li>

								<li><input type="checkbox" id="db5" name="designSoftware"
									value="illustrator" /> <label for="db5"><img
										src="assets/images/ai.jpg" /></label></li>

								<li><input type="checkbox" id="db6" name="designSoftware"
									value="unreal" /> <label for="db6"><img
										src="assets/images/unreal.jpg" /></label></li>


							</ul>

						</div>
					</div>

					<div class="question">
						<h2>What describes you the most?</h2>
						<!--Slider code------------------------------->
						<div class="choice">
							<ul>
								<li><input type="checkbox" class="ch" id="tb1"
									name="designWork" value="professional" /> <label for="tb1"
									class="ch"><p class="btn">Professional Designer</p></label></li>
								<li><input type="checkbox" class="ch" id="tb2"
									name="designWork" value="adept" /> <label for="tb2" class="ch"><p
											class="btn">Freelance Artist</p></label></li>
								<li><input type="checkbox" class="ch" id="tb3"
									name="designWork" value="novice" /> <label for="tb3"
									class="ch"><p class="btn">Beginner</p></label></li>
							</ul>
						</div>
					</div>

					<div class="question">
						<h2>How long do you intend to use PC?</h2>
						<!--Slider code------------------------------->
						<div class="range">
							<div class="sliderValue">
								<span class="output">100</span>
							</div>
							<div class="field">
								<div class="value left">0</div>
								<input type="range" class="slider" min="0" max="10" value="0"
									steps="1" name="designHoursSlider" value="">
								<div class="value right">10</div>
							</div>
						</div>
						<!------------------------------------------->
					</div>
					<!-------------------------------------------------->

				</div>
				<!---------------------------------------------------->


				<!--------Custom built------------------------------------------------->
				<div class="custom" id="custom">
					<h2 class="display-2" id="custom-build">Customize Your PC</h2>

					<!--cpu-->
					<h3 class="display-4 sel1">1. Choose a Processor brand</h3>
					<select name="processorbrand" id="processorbrand"
						class="dropdown btn btn-primary choices subchoices"
						onchange="processortype()">
						<option value="0" class="opts">Select processor brand</option>
						<option value="intel" class="opts">Intel</option>
						<option value="amd" class="opts">AMD</option>
					</select> <select name="processor"
						class="dropdown btn btn-primary choices subchoices">
						<option value="0" class="opts">Select Processor model:</option>


						<c:forEach items="${productArray}" var="product">

							<c:if test="${product.product_type == 'cpu'}">
								<option value="${product.product_id}" class="opts cpu"
									id="${product.product_brand}">
									${product.product_model}</option>

							</c:if>

						</c:forEach>


					</select>

					<!-------------------------------------------------------------------------------->


					<!--GPU-->
					<h3 class="display-4 sel1">2. Choose a Graphics Card</h3>
					<select name="gpubrand" id="gpubrand"
						class="dropdown btn btn-warning choices subchoices"
						onchange="gputype()">
						<option value="0" class="opts">Select Graphics card brand</option>
						<option value="zotac" class="opts">Zotac</option>
						<option value="nvidia" class="opts">Nvidia</option>
						<option value="msi" class="opts">MSI</option>
						<option value="evga" class="opts">Evga</option>
						<option value="asus" class="opts">Asus</option>
						<option value="gigabyte" class="opts">Gigabyte</option>
					</select> <select name="gpu"
						class="dropdown btn btn-warning choices subchoices">
						<option value="0" class="opts">Select GPU model:</option>

						<c:forEach items="${productArray}" var="product">

							<c:if test="${product.product_type == 'gpu'}">
								<option value="${product.product_id}" class="opts gpu"
									id="${product.product_brand}">
									${product.product_model}</option>
							</c:if>

						</c:forEach>


					</select>



					<!-------------------------------------------------------------------------------->

					<!--motherboard-->
					<h3 class="display-4 sel1">3. Choose a MotherBoard</h3>
					<select name="mbbrand" id="mbbrand"
						class="dropdown btn btn-success choices subchoices"
						onchange="mbtype()">
						<option value="0" class="opts">Select MotherBoard brand</option>
						<option value="msi" class="opts">MSI</option>
						<option value="asus" class="opts">Asus</option>
						<option value="gigabyte" class="opts">Gigabyte</option>
						<option value="asrock" class="opts">ASRock</option>
					</select> <select name="mb"
						class="dropdown btn btn-success choices subchoices">
						<option value="0" class="opts">Select MotherBoard model:</option>

						<c:forEach items="${productArray}" var="product">
							<c:if test="${product.product_type == 'mb'}">
								<option value="${product.product_id}" class="opts mb"
									id="${product.product_brand}">
									${product.product_model}</option>
							</c:if>


						</c:forEach>


					</select>


					<!-------------------------------------------------------------------------------->


					<!--RAM-->
					<h3 class="display-4 sel1">4. Choose the RAM</h3>

					<h3 class="display-4 sel2">4.1 RAM type</h3>
					<select name="ramtype"
						class="dropdown btn btn-secondary choices subchoices">
						<option value="0" class="opts">Select RAM type:</option>
						<option value="ddr" class="opts">DDR</option>
						<option value="ddr2" class="opts">DDR2</option>
						<option value="ddr3" class="opts">DDR3</option>
						<option value="ddr4" class="opts">DDR4</option>
					</select>

					<h3 class="display-4 sel2">4.2. RAM size</h3>
					<select name="ramsize"
						class="dropdown btn btn-secondary choices subchoices">
						<option value="0" class="opts">Select RAM size:</option>
						<option value="4" class="opts">4 GB</option>
						<option value="8" class="opts">8 GB</option>
						<option value="16" class="opts">16 GB</option>
						<option value="32" class="opts">32 GB</option>
					</select>

					<!-------------------------------------------------------------------------------->

					<!--power supply-->
					<h3 class="display-4 sel1">5. Choose the wattage of Power
						Supply</h3>
					<select name="psu" class="dropdown btn btn-danger choices">
						<option value="0" class="opts">Select power supply:</option>
						<option value="550" class="opts">550 watts</option>
						<option value="750" class="opts">750 watts</option>
						<option value="850" class="opts">850 watts</option>
						<option value="1000" class="opts">1000 watts</option>

					</select>

					<!-------------------------------------------------------------------------------->

					<!--storage-->
					<h3 class="display-4 sel1">6. Choose the Storage</h3>

					<h3 class="display-4 sel2">6.1 Storage Type</h3>
					<select name="ram" class="dropdown btn btn-info choices subchoices">
						<option value="0" class="opts">Select Storage Type:</option>
						<option value="hdd" class="opts">HDD</option>
						<option value="ssd" class="opts">SSD</option>
					</select>

					<h3 class="display-4 sel2">6.2. Storage size</h3>
					<select name="gpu" class="dropdown btn btn-info choices subchoices">
						<option value="0">Select Storage size:</option>
						<option value="1" class="opts">1 TB</option>
						<option value="2" class="opts">2 TB</option>
						<option value="3" class="opts">3 TB</option>
						<option value="4" class="opts">4 TB</option>
						<option value="5" class="opts">5 TB</option>
						<option value="6" class="opts">6 TB</option>
						<option value="8" class="opts">8 TB</option>
						<option value="10" class="opts">10 TB</option>

					</select>


					<!-------------------------------------------------------------------------------->

					<!--cabinet-->
					<h3 class="display-4 sel1">7. Choose a Cabinet</h3>
					<select name="cabinet" id="cabinet"
						class="dropdown btn btn-primary choices">
						<option value="0" class="opts">Select a Cabinet</option>

						<c:forEach items="${productArray}" var="product">
							<c:if test="${product.product_type == 'cab'}">
								<option value="${product.product_id}" class="opts">
									${product.product_model}</option>
							</c:if>
						</c:forEach>

					</select>



					<!-------------------------------------------------------------------------------->

					<br> <br>

				</div>
				<!---------------------------------------------------->
				<button type="submit" class="btn">
					Generate Your Build <i class="fa fa-chevron-right"></i>
				</button>

				<input type="hidden" name="BuilderPageType" value="preferencespage">
				<input type="hidden" name="budget" value="${budget}"> <input
					type="hidden" name="category" value="${category}">
			</form>
		</div>
	</div>

	<!------------------------------------------>
	<section class="footer">
		<section class="social_links">
			<i class="fa fa-facebook"></i> <i class="fa fa-instagram"></i> <i
				class="fa fa-twitter"></i>
		</section>
		<section class="f_info">
			<section class="f_info1">
				<h1>About Us</h1>
				<span> Builts by Price </span>| <span> Parts </span>| <span>
					Game Criteria </span>| <span> Prebuilts Recommendations </span> <br>
				<br>
				<h1>Contact Us</h1>
				<i class="fa fa-phone" style="margin-right: 10px"></i>&nbsp;<span>+919974435870</span>
				<br> <i class="fa fa-envelope" style="margin-right: 10px"></i>&nbsp;<span>Recommendation@gmail.com</span>

			</section>

			<section class="newslatter">
				<h1>Subscribe for NewsLetters</h1>
				<input type="email" placeholder="Your E-mail Address"> <br>
				<button onclick="subscribe()">Subscribe</button>
			</section>
		</section>
	</section>
	<!------------------------------------------>



	<script type="text/javascript">
		var slider = [], output = [];
		for (let i = 0; i < 10; i++) {
			slider[i] = document.getElementsByClassName("slider")[i];
			output[i] = document.getElementsByClassName("output")[i];
			output[i].innerHTML = slider[i].value;
			slider[i].oninput = function() {
				output[i].innerHTML = this.value;
			}
		}
	</script>

	<script type="text/javascript">
		function hideAll() {
			document.getElementById("gaming").style.display = "none";
			document.getElementById("casual").style.display = "none";
			document.getElementById("designing").style.display = "none";
			document.getElementById("custom").style.display = "none";
		}
		hideAll();
		//take category from backend
		let category = "${category}";

		function showCategory(cat) {
			switch (cat) {
			case "gaming":
				document.getElementById("gaming").style.display = "block";
				break;

			case "casual":
				document.getElementById("casual").style.display = "block";
				break;

			case "designing":
				document.getElementById("designing").style.display = "block";
				break;

			case "custom":
				document.getElementById("custom").style.display = "block";
				break;
			default:
				hideAll();

			}
		}

		showCategory(category);

		// slider management

		function turnon() {
			document.getElementById("overlay").style.display = "block";
		}
	</script>

</body>




</html>
