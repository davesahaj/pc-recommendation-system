<%@ page language="java" contentType="text/html; charset=UTF-8" session="false" pageEncoding="UTF-8"%>
<%@ page import="users.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Homepage</title>
<link rel="stylesheet" href="assets/css/footer.css" />
<link rel="stylesheet" href="assets/css/header.css" />
<link rel="stylesheet" href="assets/css/default.css" />
<link rel="stylesheet" href="assets/css/showcase.css" />
<link rel="stylesheet" href="assets/css/offer.css" />
<link rel="stylesheet" href="assets/css/webfeatures.css" />
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
</head>
<body>
	<section class="header">
		<section class="hamburgerbar">
			<i class="fa fa-bars fa-2x"></i>
		</section>
		<section class="logo-wrapper">
			<img src="assets/images/logo.png" alt="Recommendation System" />
		</section>

		<section class="menu-wrapper">
			<ul>
				<li><a href="home.jsp" id="active">Home</a></li>
				<li><a href="#">Explore</a></li>
				<li><a href="aboutus.jsp">About us</a></li>
				<%
					HttpSession session = request.getSession(false);

				if (session != null) {

					User user = (User) session.getAttribute("user");

					out.print("<li class=user><a href=profile.jsp>" + user.getUsername() + "</a></li>");
					if (user.getUsername().equals("admin")) {
						out.print("<li class=user><a href=AddProduct>Add Product</a></li>");
					}
					out.print("<li class=user><a href=LogoutServlet>Log Out</a></li>");

				} else {
					out.print("<li><a href=login.jsp>Log In</a></li>");
				}
				%>

			</ul>
		</section>
	</section>

	<!--showcase-->
	<span>${message}</span>
	<section class="showcase">
		<section class="content">
			<p>“Get the best Recommendation for the type of PC that suits
				you"</p>
		</section>
	</section>
	
	

	<!--webfeatures showcase-->
	<section class="webfeatures"
		style="box-shadow: yellow; background-color: black; margin-top: 10px">
		<section class="feature">
			<section class="info">
				<h1 style="color: rgb(251, 255, 0); font-size: 50px;">How it
					works</h1>
				<br />
				<p style="color: white">Choose the specifications that you want
					in your PC.</p>

				<p style="color: white">Select the things that you want from it.</p>
				<p style="color: white">And get a wide range and variety of
					options to choose from.</p>
				<p style="color: white">We genuinely believe that PCs should be
					a pleasure to purchase and own. They should help you get your work
					done, and not be a pain to manage. We make it our mission to create
					the best PC for you to run your games and applications in a budget
					that suits you. Rigorous tools are our foundational beliefs and
					have seen us serve customers</p>

				
				<a href="category.jsp"><input type="button" value="Get Started" /></a>
			</section>

			<section class="img-wrapper">
				<img src="assets/images/compare.PNG" />
			</section>
		</section>
	</section>

	<!--Offer-->
	<section class="offer">
		<section class="content">
			<h1 style="color: black">select your PC and buy from a variety
				of options</h1>
			<p style="color: black">see a range of buying options from
				different sites and get the best price</p>
			<button class="btn" style="color: black">Click here</button>
		</section>

		<section class="img-wrapper" style="width: 500px; height: auto">
			<img src="assets/images/shop.jpg" />
		</section>
	</section>

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
</body>
</html>