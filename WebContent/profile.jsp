<%@ page language="java" contentType="text/html; charset=UTF-8" session="false"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile</title>
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="assets/css/header.css">
<link rel="stylesheet" href="assets/css/default.css">
<link rel="stylesheet" href="assets/css/ReccomsndationProfilePage.css">
<link href='https://fonts.googleapis.com/css?family=tittilium'
	rel='stylesheet'>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=BioRhyme'
	rel='stylesheet'>

</head>


<body>
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
				<li><a href="explore.jsp">Explore</a></li>
				<li><a href="aboutus.jsp">About us</a></li>
				<%
					HttpSession session = request.getSession(false);
				if (session != null) {
					String username = (String) session.getAttribute("user");
					out.print("<li class=user><a href=profile.jsp>" + username + "</a></li>");
					out.print("<li class=user><a href=LogoutServlet>Log Out</a></li>");
				} else {
					String message = "Please Login First";
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
					//response.sendRedirect("login.jsp");
				}
				%>

			</ul>
		</section>
	</section>

	<div class="container">
		<div class="cover"></div>
		<div class="mainprofile">
			<div class="profilepic">
				<img src="assets/images/profile.jpg">
			</div>
			<div class="edit">
				<button>
					Edit Profile<i class="fa fa-pencil" aria-hidden="true"></i>
				</button>
				<h1>Abhik Vaghela</h1>
				<br> <br>
				<p>
					<b>About me</b>
				</p>
				<br>
				<p>no personal bio added yet.</p>
				<br> <br> <span><b>Location: </b>Ahmedabad</span><br>
				<br> <span><b>Email: </b>abhikvaghela14@gmail.com</span><br>
				<br> <span><b>Username </b>abhik69</span>
			</div>
		</div>
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