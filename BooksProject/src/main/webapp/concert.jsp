<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.smhrd.model.SeatVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">


<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/fdb678099a.js"
	crossorigin="anonymous"></script>

</head>

<body>

	<!-- Spinner Start -->
	<div id="spinner"
		class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
		<div class="spinner-grow text-primary" role="status"></div>
	</div>
	<!-- Spinner End -->


	<!-- Navbar start -->
	<div class="container-fluid fixed-top">
		<div class="container px-0">
			<nav class="navbar navbar-light bg-white navbar-expand-xl">
				<a href="gomain.do" class="navbar-brand"> <img
					src="./img/logo2.png" alt="" class="logoimg">
				</a>
				<button class="navbar-toggler py-2 px-3" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
					<span class="fa fa-bars text-primary"></span>
				</button>
				<div class="collapse navbar-collapse bg-white" id="navbarCollapse">
					<div class="navbar-nav mx-auto">
						<div class="nav-item dropdown">
							<a href="#" class="nav-item nav-link dropdown-toggle"
								data-bs-toggle="dropdown">BUSTIVAL</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="goenroll.do" class="dropdown-item">신청게시판</a> <a
									href="#" class="dropdown-item">요청게시판</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="#" class="nav-item nav-link dropdown-toggle"
								data-bs-toggle="dropdown">BOARD</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="boardList.do?value=1" class="dropdown-item">자유게시판</a> <a
									href="boardList.do?value=2" class="dropdown-item">질문게시판</a> <a
									href="boardList.do?value=3" class="dropdown-item">후기게시판</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="qna.jsp" class="nav-link dropdown-toggle"
								data-bs-toggle="dropdown">INFO CENTER</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="qna.jsp" class="dropdown-item">Q&A</a> <a
									href="noticeList.do?value=4" class="dropdown-item">공지사항</a> <a
									href="refund_Policy.jsp" class="dropdown-item">환불규정</a>
							</div>
						</div>
					</div>
					<div class="d-flex m-3 me-0">
						<!-- 로그인X 시 나타날 회원가입 버튼 -->
						<c:if test="${member == null }">
							<a href="signin.jsp" class="my-auto"> <i
								class="fa-solid fa-pen-nib fa-2xl"></i>
							</a>
							<!-- 로그인X 시 나타날 로그인 버튼 -->
							<a href="login.jsp" class="my-auto"> <i
								class="fas fa-user fa-2x"></i>
							</a>
						</c:if>
						<!--로그인 시 나타날 마이페이지 버튼-->
						<c:if test="${member != null }">
							<a href="myPage.do" class="my-auto"> <i
								class="fas fa-user fa-2x"></i>
							</a>
						</c:if>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Navbar End -->

	<%
	String event_id = request.getParameter("event_id");
	String event_img = request.getParameter("event_img");
	String event_name = request.getParameter("event_name");
	String event_date = request.getParameter("event_date");
	String event_loc = request.getParameter("event_loc");
	List<SeatVO> progressBar = (List<SeatVO>) request.getAttribute("progressBar");
	int index= 0;
	%>
	<!-- Concert infomation 콘서트 정보 -->
	<div class="container-fluid contact py-5">
		<div class="container py-5">
			<!-- 전체 모양 지정 -->
			<div class="p-5 bg-light rounded custom-wide">
				<div class="row g-4">
					<!-- 콘서트 이름  -->
					<div class="col-12">
						<div class="text-center mx-auto" style="max-width: 700px;">
							<h1 class="text-primary">행사 정보</h1>
						</div>
					</div>
					<div class="flex-container">
						<div class="h-100 rounded">
							<h6><%=event_name%></h6>
							<h6 class="m"><%=event_date%></h6>
							<img src="<%=event_img%>" id="EVENT_IMG">
						</div>
						<div class="conInfo">
							<div>
								<!-- 지역 추가 -->
								<h5>Going from 서울</h5>
								<div class="flex-container">
									<div class="progressBarContainer">
										<div class="progressBar">
											<span class="percentage"></span>
										</div>
									</div>
									<div class="buttons">
									<% if(progressBar.size() > index) { %>
										<button class="btn btn-one btn-lg btn-block">
											<a href="bookingList.do?SHTL_ID=<%=progressBar.get(index++).getSHTL_ID()%>&event_id=<%=event_id%>&go=서울">예약</a>
										</button>
									</div>
								</div>
							</div>
							<!-- 지역 추가 끝 -->
							<div>
								<!-- 지역 추가 -->
								<h5>Going from 광주</h5>
								<div class="flex-container">
									<div class="progressBarContainer">
										<div class="progressBar">
											<span class="percentage"></span>
										</div>
									</div>
									<div class="buttons">
										<button class="btn btn-one btn-lg btn-block">
											<a href="bookingList.do?SHTL_ID=<%=progressBar.get(index++).getSHTL_ID()%>&event_id=<%=event_id%>&go=광주">예약</a>
										</button>
									</div>
								</div>
							</div>
							<!-- 지역 추가 끝 -->
							<div>
								<!-- 지역 추가 -->
								<h5>Going from 부산</h5>
								<div class="flex-container">
									<div class="progressBarContainer">
										<div class="progressBar">
											<span class="percentage"></span>
										</div>
									</div>
									<div class="buttons">
										<button class="btn btn-one btn-lg btn-block">
											<a href="bookingList.do?SHTL_ID=<%=progressBar.get(index++).getSHTL_ID()%>&event_id=<%=event_id%>&go=부산">예약</a>
										</button>
									</div>
								</div>
							</div>
							<!-- 지역 추가 끝 -->
							<div>
								<!-- 지역 추가 -->
								<h5>Going from 대구</h5>
								<div class="flex-container">
									<div class="progressBarContainer">
										<div class="progressBar">
											<span class="percentage"></span>
										</div>
									</div>
									<div class="buttons">
										<button class="btn btn-one btn-lg btn-block">
											<a href="bookingList.do?SHTL_ID=<%=progressBar.get(index++).getSHTL_ID()%>&event_id=<%=event_id%>&go=대구">예약</a>
										</button>
									</div>
								</div>
							</div>
							<!-- 지역 추가 끝 -->
							<div>
								<!-- 지역 추가 -->
								<h5>Going from 인천</h5>
								<div class="flex-container">
									<div class="progressBarContainer">
										<div class="progressBar">
											<span class="percentage"></span>
										</div>
									</div>
									<div class="buttons">
										<button class="btn btn-one btn-lg btn-block">
											<a href="bookingList.do?SHTL_ID=<%=progressBar.get(index++).getSHTL_ID()%>&event_id=<%=event_id%>&go=인천">예약</a>
										</button>
									</div>
								</div>
							</div>
							<!-- 지역 추가 끝 -->
							<div>
								<!-- 지역 추가 -->
								<h5>Going from 대전</h5>
								<div class="flex-container">
									<div class="progressBarContainer">
										<div class="progressBar">
											<span class="percentage"></span>
										</div>
									</div>
									<div class="buttons">
										<button class="btn btn-one btn-lg btn-block">
											<a href="bookingList.do?SHTL_ID=<%=progressBar.get(index++).getSHTL_ID()%>&event_id=<%=event_id%>&go=대전">예약</a>
										</button>
									</div>
								</div>
							</div>
							<!-- 지역 추가 끝 -->
							<div>
								<!-- 지역 추가 -->
								<h5>Going from 울산</h5>
								<div class="flex-container">
									<div class="progressBarContainer">
										<div class="progressBar">
											<span class="percentage"></span>
										</div>
									</div>
									<div class="buttons">
										<button class="btn btn-one btn-lg btn-block">
											<a href="bookingList.do?SHTL_ID=<%=progressBar.get(index++).getSHTL_ID()%>&event_id=<%=event_id%>&go=울산">예약</a>
										</button>
										            <% } %>
									</div>
								</div>
							</div>
							<!-- 지역 추가 끝 -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Concert infomation End -->


	<!-- Footer Start -->
	<div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
		<div class="pb-4 mb-4 logo"
			style="border-bottom: 1px solid rgba(226, 175, 24, 0.5);">
			<img id="footerLogo" src="./img/ft_logo.png" alt="">
		</div>
		<!-- Footer End -->

		<!-- Copyright Start -->
		<div class="container">
			<span class="text-light"><a href="#"><i
					class="fas fa-copyright text-light me-2"></i>BUSTIVAL</a></span> <br> <span><a
				href="#">깃허브 주소</a></span> <br> <a href="https://smhrd.or.kr/">스마트인재개발원</a>
			<!--깃허브 주소 넣기.-->
		</div>
		<!-- Copyright End -->





		<!-- JavaScript Libraries -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
		<script src="lib/easing/easing.min.js"></script>
		<script src="lib/waypoints/waypoints.min.js"></script>
		<script src="lib/lightbox/js/lightbox.min.js"></script>
		<script src="lib/owlcarousel/owl.carousel.min.js"></script>
		<%
		request.getSession().setAttribute("event_id", event_id);
		request.getSession().setAttribute("event_loc", event_loc);
		request.getSession().setAttribute("event_name", event_name);
		request.getSession().setAttribute("event_date", event_date);
		%>



		progressBar = (List<SeatVO>) request.getAttribute("progressBar");
		<script>
		document.addEventListener('DOMContentLoaded', function() {
		    var totalSeats = [28, 28, 28, 28, 28, 28, 28]; // 각 프로그레스바에 대한 전체 좌석 수 예시
		    var bookedSeats = [
		        <%for (SeatVO pro : progressBar) {%>
		            <%=pro.getRESERVED_SEAT_COUNT()%><%if (pro != progressBar.get(progressBar.size() - 1)) {%>, <%}%>
		        <%}%>
		    ]; // 각 프로그레스바에 대한 예약된 좌석 수


		    var progressBars = document.getElementsByClassName("progressBar");

		    for (var i = 0; i < progressBars.length; i++) {
		        var bookedPercentage;
		        if (totalSeats[i] === 0) {
		            bookedPercentage = 0;
		        } else {
		            bookedPercentage = (bookedSeats[i] / totalSeats[i]) * 100;
		        }
		        if (isNaN(bookedPercentage)) {
		            bookedPercentage = 0;
		        }
		        progressBars[i].style.width = bookedPercentage + '%';

		        var percentageSpan = progressBars[i].getElementsByClassName("percentage")[0];
		        percentageSpan.innerText = bookedPercentage.toFixed(0) + '%';
		    }
		});</script>



		<!-- Template Javascript -->
		<script src="js/main.js"></script>
</body>

</html>