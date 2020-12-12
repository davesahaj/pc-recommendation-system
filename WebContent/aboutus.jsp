<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	if (session.getAttribute("uname") == null || session.getAttribute("pass") == null) {
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>About Us</title>
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="assets/css/header.css">
<link rel="stylesheet" href="assets/css/default.css">
<link rel="stylesheet" href="assets/css/showcase.css">
<link rel="stylesheet" href="assets/css/offer.css">
<link rel="stylesheet" href="assets/css/webfeatures.css">
<link rel="stylesheet" href="assets/css/AboutUs.css">
<link rel="stylesheet" href="assets/css/ReccomsndationProfilePage.css">

<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">


</head>
<body>
	<section class="header">
		<section class="hamburgerbar">
			<i class="fa fa-bars fa-2x"></i>
		</section>
		<section class="logo-wrapper">

			<img src="assets/images/logo.png" alt="Recommendation System">

		</section>

		<section class="menu-wrapper">
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="explore.jsp">Explore</a></li>
				<li><a href="login.jsp">Log In</a></li>
				<li><a href="aboutus.jsp" id="active">About us</a></li>
				<li class="user"><a href="profile.jsp">My Profile</a></li>
			</ul>
		</section>
	</section>



	<section class=aboutus>
		<section class="img-wrapper"></section>

		<section class="info">


			<section class="intro">
				<section class="info-wrapper">
					<h1>About Us</h1>
					<p>We're a team of modders, gamers and tech enthusiasts. We
						happen to help you build the fastest Custom PC builds in India.
						Using our Recommendation System you can build them mean and build
						them fast. speed demons, content creators, data scientists,
						Machine learning experts, and just about anyone who wants the
						latest and greatest in tech.</p>

					<p>As cliched as it sounds, we are insanely passionate about
						gaming and everything related to tech. We managed to fit in 16
						long years of education in between bouts of endless gaming. We
						realized that we'd geek out to help begineers with their custom PC
						builts.</p>

					<p>Our biggest driving force has been spreading the joy of
						gaming - and reading / hearing satisfied gamers giving their
						honest feedback. We’re committed to provide you with the solutions
						to incorporate elements that would make the journey to your dream
						PC simpler.</p>

					</p>
				</section>

				<section class="img-wrapper">
					<img src="assets/images/cpu.png">
				</section>
			</section>



		</section>






	</section>
	</section>

	</section>
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