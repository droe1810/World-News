<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>

<html>
    <head>
        <title>WorldNews</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
        <link href="css/element.css" rel="stylesheet">
        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </head>
    <body>
        <section id="header" class="clearfix">
            <nav class="navbar navbar-default navbar-fixed-top">
                <!-- /.container-fluid -->
                <section id="menu_box">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12 menu_box">
                                <div class="col-sm-3">
                                    <div class="menu_box_1">
                                        <h1><a href="home">WorldNews!</a></h1>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="menu_box_2">
                                        <input class="form_1" type="text">
                                        <a href="#">Search </a>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="menu_box_3 text-right">
                                        <span class="tag_1"><a href="login.jsp">Log in</a></span>
                                        <span class="tag_1"><a href="logout">Log out</a></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <div class="container">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="hidden">
                                <a href="#page-top"></a>
                            </li>
                            <li class="active_1">
                                <a class="li_1" href="home"><i class="fa fa-home"></i>Home</a>
                            </li>
                            <li>
                                <a class="li_1" href="addnew">Post New</a>
                            </li>

                            <li>
                                <a class="li_1" href="managerwriter">Manager Writer</a>
                            </li> 
                            <li>
                                <a class="li_1" href="managernew">Manager New</a>
                            </li>

                            <li>
                                <a class="li_1" href="viewprofile">Profile</a>
                            </li>
                        </ul>
                    </div>
                </div>

            </nav>
        </section>

        <section id="center">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 center_main">
                        <div class="col-sm-2">
                            <div class="center_1">
                                <ul>
                                    <div><h3>${c.cname} News</h3></div>
                                    <c:forEach items="${listC}" var="o">                                   
                                        <li><a href="home?cid=${o.cid}">${o.cname}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <c:forEach items="${listN}" var="o">
                                <div class="col-sm-12 center_2_inner_main_1">
                                    <div class="col-sm-4">
                                        <div class="center_2_inner_1">
                                            <a href="#"><img src="${o.image}" width="100%"></a>
                                        </div>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="center_2_inner_2">
                                            <h4>
                                                <a href="detail?id=${o.id}">
                                                    ${o.name}                                              
                                                </a>
                                            </h4>
                                            <p><a href="#">
                                                    ${o.title}
                                                </a></p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col-sm-3">
                            <div class="center_3">
                                <div class="col-sm-12 weather">
                                    <h4><a href="#">Ha Noi<i class="fa fa-map-marker"></i></a></h4>
                                    <div class="col-sm-3">
                                        <div class="weather_1 text-center">
                                            <p><a href="#">
                                                    <div class="day"><a href="#">Today</a></div>
                                                    <div class="cloud_1"><i class="fa fa-cloud"></i></div>
                                                    <h3><a href="#">35°</a></h3>
                                                </a>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="weather_1 text-center">
                                            <p><a href="#">
                                                    <div class="day"><a href="#">Thu</a></div>
                                                    <div class="cloud_1 color_1"><i class="fa fa-sun-o"></i></div>
                                                    <h3><a href="#">32°</a></h3>
                                                </a>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="weather_1 text-center">
                                            <p><a href="#">
                                                    <div class="day"><a href="#">Fri</a></div>
                                                    <div class="cloud_1"><i class="fa fa-moon-o"></i></div>
                                                    <h3><a href="#">36°</a></h3>
                                                </a>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="weather_1 text-center">
                                            <p><a href="#">
                                                    <div class="day"><a href="#">Sat</a></div>
                                                    <div class="cloud_1 color_1"><i class="fa fa-sun-o"></i></div>
                                                    <h3><a href="#">33°</a></h3>
                                                </a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <h5><a href="#">Lastest News</a></h5>           

                                <div class="col-sm-12 center_3_link">
                                    <a href="#"><img class="img-circle" src="img/26.jpg" width="100%"></a>
                                    <p><a href="#">Good Evening World</a></p>
                                    <h4><a href="#"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio.</a></h4>
                                </div>
                                <div class="col-sm-12 center_3_link">
                                    <a href="#"><img class="img-circle" src="img/27.jpg" width="100%"></a>
                                    <p><a href="#">World Hub</a></p>
                                    <h4><a href="#"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio.</a></h4>
                                </div>
                                <div class="col-sm-12 center_3_image">
                                    <div class="media">
                                        <a href="#">
                                            <img class="media-object dp " src="img/28.jpg" width="100%">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-sm-12 center_3_image">
                                    <div class="media">
                                        <a href="#">
                                            <img class="media-object dp " src="img/29.jpg" width="100%">
                                        </a>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="col-sm-3">
                            <div class="footer_1">
                                <h3>ABOUT US</h3>
                                <hr> 
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero.</p>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="footer_2">
                                <h3>CONTACT INFO</h3>
                                <hr>
                                <p><i class="glyphicon glyphicon-map-marker"></i>10 Pham Van Bach, Ha Noi</p>
                                <p><i class="glyphicon glyphicon-envelope"></i>FPT@gmail.com</p>
                                <p><i class="glyphicon glyphicon-earphone"></i>+1234 567 890</p>
                            </div> 
                        </div>


                    </div>
                </div>
            </div>
        </section>



        <!-- //for header -->	
        <script src="js/classie.js"></script>
        <script src="js/cbpAnimatedHeader.js"></script>
        <!-- //for header_end -->	

        <!-- //for slider -->
        <script type="text/javascript">
            jQuery(document).ready(function ($) {

                $('#myCarousel').carousel({
                    interval: 5000
                });

                $('#carousel-text').html($('#slide-content-0').html());

                //Handles the carousel thumbnails
                $('[id^=carousel-selector-]').click(function () {
                    var id = this.id.substr(this.id.lastIndexOf("-") + 1);
                    var id = parseInt(id);
                    $('#myCarousel').carousel(id);
                });


                // When the carousel slides, auto update the text
                $('#myCarousel').on('slid.bs.carousel', function (e) {
                    var id = $('.item.active').data('slide-number');
                    $('#carousel-text').html($('#slide-content-' + id).html());
                });
            });
        </script>
        <!-- //for slider_end -->
    </body>

</html>
