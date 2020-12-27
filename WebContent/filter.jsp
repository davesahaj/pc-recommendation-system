<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Set your preferences</title>
      <link rel="stylesheet" href="assets/css/footer.css" />
      <link rel="stylesheet" href="assets/css/header.css" />
      <link rel="stylesheet" href="assets/css/default.css" />
      <link rel="stylesheet" href="assets/css/showcase.css" />
      <link rel="stylesheet" href="assets/css/offer.css" />
      <link rel="stylesheet" href="assets/css/webfeatures.css" />
      <link rel="stylesheet" href="assets/css/filter.css" />

      <link href="https://fonts.googleapis.com/css?family=tittilium" rel="stylesheet" />
      <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous" />
      <link href="https://fonts.googleapis.com/css?family=BioRhyme" rel="stylesheet" />
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
            <li><a href="index.html" id="active">Home</a></li>
            <li><a href="explore.html">Explore</a></li>
            <li><a href="login.html">Log In</a></li>
            <li><a href="AboutUs.html">About us</a></li>
            <li><a href="donate.html">Donate</a></li>
            <li class="user"><a href="profile.html">My Profile</a></li>
          </ul>
        </section>
      </section>


      <h3 class="display-2" id="custom-build"><span id="">${message}</span></h3>

      <form action="" id="custom-form" method="POST">

        <!-------------------------------------------------------------------------------->

        <!--cpu-->
        <h3 class="display-4 sel1">1. Choose a Processor brand</h3>
        <select name="processorbrand" id="processorbrand" class="dropdown btn btn-primary choices subchoices"
          onchange="processortype()">
          <option value="0" class="opts">Select processor brand</option>
          <option value="intel" class="opts"> Intel </option>
          <option value="amd" class="opts"> AMD </option>
        </select>


        <select name="processor" class="dropdown btn btn-primary choices subchoices">
          <option value="0" class="opts">Select Processor model:</option>


          <c:forEach items="${productArray}" var="product">

            <c:if test="${product.product_type == 'cpu'}">
              <option value="${product.product_id}" class="opts cpu" id="${product.product_brand}"> ${product.product_model}</option>

            </c:if>

          </c:forEach>


        </select>

        <!-------------------------------------------------------------------------------->


        <!--GPU-->
        <h3 class="display-4 sel1">2. Choose a Graphics Card</h3>
        <select name="gpubrand" id="gpubrand" class="dropdown btn btn-warning choices subchoices" onchange="gputype()">
          <option value="0" class="opts">Select Graphics card brand</option>
          <option value="zotac" class="opts"> Zotac </option>
          <option value="nvidia" class="opts"> Nvidia </option>
          <option value="msi" class="opts"> MSI </option>
          <option value="evga" class="opts"> Evga </option>
          <option value="asus" class="opts"> Asus </option>
          <option value="gigabyte" class="opts"> Gigabyte </option>
        </select>


        <select name="gpu" class="dropdown btn btn-warning choices subchoices">
          <option value="0" class="opts">Select GPU model:</option>

          <c:forEach items="${productArray}" var="product">

            <c:if test="${product.product_type == 'gpu'}">
              <option value="${product.product_id}" class="opts gpu" id="${product.product_brand}"> ${product.product_model}</option>
            </c:if>

          </c:forEach>


        </select>



        <!-------------------------------------------------------------------------------->

        <!--motherboard-->
        <h3 class="display-4 sel1">3. Choose a MotherBoard</h3>
        <select name="mbbrand" id="mbbrand" class="dropdown btn btn-success choices subchoices" onchange="mbtype()">
          <option value="0" class="opts">Select MotherBoard brand</option>
          <option value="msi" class="opts"> MSI </option>
          <option value="asus" class="opts"> Asus </option>
          <option value="gigabyte" class="opts"> Gigabyte </option>
          <option value="asrock" class="opts"> ASRock </option>
        </select>


        <select name="mb" class="dropdown btn btn-success choices subchoices">
          <option value="0" class="opts">Select MotherBoard model:</option>

          <c:forEach items="${productArray}" var="product">
            <c:if test="${product.product_type == 'mb'}">
              <option value="${product.product_id}" class="opts mb" id="${product.product_brand}"> ${product.product_model}</option>
            </c:if>


          </c:forEach>


        </select>


        <!-------------------------------------------------------------------------------->


        <!--RAM-->
        <h3 class="display-4 sel1">4. Choose the RAM</h3>

        <h3 class="display-4 sel2">4.1 RAM type </h3>
        <select name="ramtype" class="dropdown btn btn-secondary choices subchoices">
          <option value="0" class="opts">Select RAM type:</option>
          <option value="ddr" class="opts">DDR</option>
          <option value="ddr2" class="opts">DDR2</option>
          <option value="ddr3" class="opts">DDR3</option>
          <option value="ddr4" class="opts">DDR4</option>
        </select>

        <h3 class="display-4 sel2">4.2. RAM size</h3>
        <select name="ramsize" class="dropdown btn btn-secondary choices subchoices">
          <option value="0" class="opts">Select RAM size:</option>
          <option value="4" class="opts">4 GB</option>
          <option value="8" class="opts">8 GB</option>
          <option value="16" class="opts">16 GB</option>
          <option value="32" class="opts">32 GB</option>
        </select>

        <!-------------------------------------------------------------------------------->

        <!--power supply-->
        <h3 class="display-4 sel1">5. Choose the wattage of Power Supply</h3>
        <select name="psu" class="dropdown btn btn-danger choices">
          <option value="0" class="opts">Select power supply:</option>
          <option value="550" class="opts"> 550 watts </option>
          <option value="750" class="opts"> 750 watts </option>
          <option value="850" class="opts"> 850 watts </option>
          <option value="1000" class="opts">1000 watts </option>

        </select>

        <!-------------------------------------------------------------------------------->

        <!--storage-->
        <h3 class="display-4 sel1">6. Choose the Storage</h3>

        <h3 class="display-4 sel2">6.1 Storage Type </h3>
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
        <select name="cabinet" id="cabinet" class="dropdown btn btn-primary choices">
          <option value="0" class="opts">Select a Cabinet</option>

          <c:forEach items="${productArray}" var="product">
            <c:if test="${product.product_type == 'cab'}">
              <option value="${product.product_id}" class="opts"> ${product.product_model}</option>
            </c:if>
          </c:forEach>

        </select>



        <!-------------------------------------------------------------------------------->

        <br><br>
        <button type="submit" class="btn btn-light btn-lg subbtn">Get my Recommendation<svg
            xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right"
            viewBox="0 0 16 16">
            <path fill-rule="evenodd"
              d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
          </svg></button>
      </form>

      <section class="footer">
        <section class="social_links">
          <i class="fa fa-facebook"></i>
          <i class="fa fa-instagram"></i>
          <i class="fa fa-twitter"></i>
        </section>
        <section class="f_info">
          <section class="f_info1">
            <h1>Recommendation.com</h1>
            <h1>About Us</h1>
            <span>Our website provides best Recommendation</span>
            <br />
            <br />
            <h1>Contact Us</h1>
            <i class="fa fa-phone" style="margin-right: 10px"></i>&nbsp;<span>+919974435870</span>
            <br />
            <i class="fa fa-envelope" style="margin-right: 10px"></i>&nbsp;<span>Recommendation@gmail.com</span>
          </section>

          <section class="newslatter">
            <h1>Subscribe to Recommendation@gmail.com</h1>
            <input type="email" placeholder="Your E-mail Address" />
            <br />
            <button onclick="subscribe()">Subscribe</button>
          </section>
        </section>
      </section>

      <script type="text/javascript">

        //for processor
        function processortype() {
          let ele = $("#processorbrand").val();

           $(".cpu").hide();
           $("#"+ele+"").show();
            
        }

        //for gpu
        function gputype() {
          let ele2 = $("#gpubrand").val();

          $(".gpu").hide();
          $("#"+ele2+"").show();

        }

        //for motherboard
        function mbtype() {

          let ele3 = $("#mbbrand").val();

          $(".mb").hide();
          $("#"+ele3+"").show();


        }




      </script>

    </body>

    </html>
