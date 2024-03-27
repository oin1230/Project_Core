<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.ShuttleVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>BUSTIVAL</title>
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

<!-- Template Stylesheet css연결하는 곳-->
<link href="css/style.css" rel="stylesheet">
<!-- 슬라이드 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://kit.fontawesome.com/fdb678099a.js"
	crossorigin="anonymous"></script>


</head>
<body>
	<%
	String event_id = (String) request.getSession().getAttribute("event_id");
	String event_loc = (String) request.getSession().getAttribute("event_loc");
	String event_name = (String) request.getSession().getAttribute("event_name");
	String event_date = (String) request.getSession().getAttribute("event_date");
	String go = request.getParameter("go");
	List<ShuttleVO> bookingList = (List<ShuttleVO>) request.getAttribute("bookingList");
	%>
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
									href="announcement.jsp" class="dropdown-item">공지사항</a> <a
									href="refund_Policy.jsp" class="dropdown-item">환불규정</a>
							</div>
						</div>
					</div>
					<div class="d-flex m-3 me-0">
						<c:if test="${member == null }">
							<!-- 로그인X 시 나타날 회원가입 버튼 -->
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
							<a href="myPage.jsp" class="my-auto"> <i
								class="fas fa-user fa-2x"></i>
							</a>
						</c:if>

					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Navbar End -->




	<div class="container-fluid contact py-5 py-booking">
		<div class="container py-5">
			<div class="p-5 bg-light rounded custom-wide">
				<div class="row g-4">
					<!-- 버스 좌석 -->
					<h1 class="res">예약하기</h1>
					<div class="bus-container">
						<div class="busseat">
							<div class="choice-container">
								<select id="choice">
								</select>
							</div>

							<ul class="showcase">
								<li>
									<div class="seat"></div> <small>N/A</small>
								</li>
								<li>
									<div class="selectedSeats" id="count"></div> <small>Selected</small>
								</li>
								<li>
									<div class="seatOccupied"></div> <small>Occupied</small>
								</li>
							</ul>

							<div class="seatContainer">
								<div class="row">
									<div class="seat">25</div>
									<div class="seat">22</div>
									<div class="seat">19</div>
									<div class="seat">16</div>
									<div class="seat">13</div>
									<div class="seat">10</div>
									<div class="seat">7</div>
									<div class="seat">4</div>
									<div class="seat">1</div>
								</div>
								<div class="row">
									<div class="seat">26</div>
									<div class="seat">23</div>
									<div class="seat">20</div>
									<div class="seat">17</div>
									<div class="seat">14</div>
									<div class="seat">11</div>
									<div class="seat">8</div>
									<div class="seat">5</div>
									<div class="seat">2</div>
								</div>
								<div class="row">
									<div class="seat">27</div>
								</div>
								<div class="row">
									<div class="seat">28</div>
									<div class="seat">24</div>
									<div class="seat">21</div>
									<div class="seat">18</div>
									<div class="seat">15</div>
									<div class="seat">12</div>
									<div class="seat">9</div>
									<div class="seat">6</div>
									<div class="seat">3</div>
								</div>
							</div>

						</div>
					</div>

					<!-- 테이블 생성 -->
					<div class="table-container">
						<table class="tableBooking">
							<tbody>
							<thead class="tBth">
								<tr>
									<th colspan="2" class="tBth-th">행사명</th>
									<th colspan="2" class="tBth-th">행사장소</th>
									<th class="tBth-th">행사날짜</th>
								</tr>
								<tr>
									<td colspan="2" class="tBth-td"><%=event_name%></td>
									<td colspan="2" class="tBth-td"><%=event_loc%></td>
									<td class="tBth-td"><%=event_date%></td>
								</tr>

							</thead>
							<c:forEach var="shuttle" items="${bookingList}">
								<thead class="tBth">
									<tr>
										<th class="tBth-th">셔틀 탑승 장소</th>
										<th class="tBth-th">셔틀 탑승일</th>
										<th class="tBth-th">셔틀 가격</th>
										<th class="tBth-th">셔틀 모집 시작일</th>
										<th class="tBth-th">셔틀 마감일</th>
									</tr>
									<tr>
										<td class="tBth-td">${go}</td>
										<td class="tBth-td">${shuttle.riding_date}</td>
										<td class="tBth-td"><span id="allTotAmtLocD">0원</span></td>
										<td class="tBth-td">${shuttle.start_date}</td>
										<td class="tBth-td">${shuttle.end_date}</td>

									</tr>
								</thead>
							</c:forEach>

							</tbody>
						</table>
					</div>

					<div class="cbp">
						<div class="countBox">
							<p>
								총 인원 수 <br> <span id="adltCnt"></span>
							</p>

						</div>
						<div class="price">
							<span class="txt_tit">결제 금액</span><br> <span
								id="allTotAmtLocD">0원</span>

						</div>
					</div>
					<div class="btnPay">
						<button class="btn btn-one btn-lg btn-block btn-price"
							type="button">
							<a href="#">결제하기</a>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>


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





		<script type="text/javascript">
			function category1() {
				sessionStorage.setItem("b_category", "1");
			}
			function category2() {
				sessionStorage.setItem("b_category", "2");
			}
			function category3() {
				sessionStorage.setItem("b_category", "3");
			}
		</script>


		<!-- Template Javascript -->
		<script src="js/main.js"></script>
		<script src="js/booking.js"></script>
</body>

</html>