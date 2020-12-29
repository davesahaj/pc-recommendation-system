<%@ page language="java" contentType="text/html; charset=UTF-8" session="false" pageEncoding="UTF-8"%>
<%@ page import="users.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile</title>
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="assets/css/header.css">
<link rel="stylesheet" href="assets/css/default.css">
<link rel="stylesheet" href="assets/css/profile.css">
<link href='https://fonts.googleapis.com/css?family=tittilium'
	rel='stylesheet'>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=BioRhyme'
	rel='stylesheet'>



<script defer type="text/javascript">
	function editprofile() {
		var x = document.getElementsByClassName("edit");
		x[0].style.display = "none";
		var y = document.getElementsByClassName("editform");
		y[0].style.display = "block";

	}

	function changePassword() {
		var x = document.getElementsByClassName("edit");
		x[0].style.display = "none";
		var y = document.getElementById("e01");
		y.style.display = "block";

	}
</script>

</head>


<body>

	<!------------------------------------------------------------------------------->
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

					String message = "Please Login First";
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);

				}

				User user = (User) session.getAttribute("user");

				out.print("<li class=user><a href=profile.jsp>" + user.getUsername() + "</a></li>");
				out.print("<li class=user><a href=LogoutServlet>Log Out</a></li>");
				%>

			</ul>
		</section>
	</section>

	<!------------------------------------------------------------------------------->
	<div class="container">
		<div class="cover"></div>
		<div class="mainprofile">
			<div class="profilepic">
				<img src="assets/images/profile.jpg">
			</div>

			<!------------------------------------------------------------------------------->
			<div class="edit">
				<button onclick="editprofile()">
					Edit Profile <i class="fa fa-pencil" aria-hidden="true"></i>
				</button>
				</br>
				<button onclick="changePassword()">
					Change Password <i class="fa fa-key" aria-hidden="true"></i>
				</button>
				<h1>${user.getUsername()}</h1>
				<br> <br> <br> <span><b>Username: </b><%=user.getUsername() %></span>
				<br> <span><b>Email: </b><%=user.getEmail() %></span><br>
			</div>
			<!------------------------------------------------------------------------------->
			<div class="editform">
				<section class="eform">
					<form action="ProfileServlet" method="post">
						<input type="hidden" name="editOption" value="editDetails">
						<table>
							<tr>
								<td><label for="aname">User Name: </label></td>
								<td><input type="text" name="username" value=<%=user.getUsername() %>
									placeholder=""></td>
							</tr>

							<tr>
								<td><label for="pname">Email : </label></td>
								<td><input type="email" value=<%=user.getEmail() %> name="email"
									placeholder=""></td>
							</tr>

						</table>
						<button type="submit">Update</button>
					</form>
				</section>
			</div>

			<!------------------------------------------------------------------------------->
			<div class="editform" id="e01" style="display: none">
				<section class="eform">
					<form action="ProfileServlet" method="post">
						<input type="hidden" name="editOption" value="editPassword">
						<table>


							<tr>
								<td><label for="newpass">New Password: </label></td>
								<td><input type="text" value="" name="newpassword"
									placeholder=""></td>
							</tr>

							<tr>
								<td><label for="newpass">Confirm New Password: </label></td>
								<td><input type="text" value="" placeholder=""></td>
							</tr>

						</table>
						<button type="submit">Update</button>
					</form>
				</section>
			</div>
			<!------------------------------------------------------------------------------->
		</div>
	</div>

	<!------------------------------------------------------------------------------->
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