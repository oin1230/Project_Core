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

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

<!-- sidebar -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<i class="fas fa-user fa-2x"></i>
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
							<a href="goenroll.do" class="nav-item nav-link dropdown-toggle"
								data-bs-toggle="dropdown">BUSTIVAL</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="goenroll.do" class="dropdown-item">신청게시판</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="boardList.do?value=1&page=1"
								class="nav-item nav-link dropdown-toggle"
								data-bs-toggle="dropdown">BOARD</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="boardList.do?value=1&page=1" class="dropdown-item">자유게시판</a>
								<a href="boardList.do?value=2&page=1" class="dropdown-item">질문게시판</a>
								<a href="boardList.do?value=3&page=1" class="dropdown-item">후기게시판</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="qna.jsp" class="nav-link dropdown-toggle"
								data-bs-toggle="dropdown">INFO CENTER</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="goqna.do" class="dropdown-item">Q&A</a> <a
									href="noticeList.do?value=4&page=1" class="dropdown-item">공지사항</a>
								<a href="gorefundPolicy.do" class="dropdown-item">환불규정</a>
							</div>
						</div>
					</div>
					<div class="d-flex m-3 me-0">
						<c:if test="${member == null }">
							<!-- 로그인X 시 나타날 회원가입 버튼 -->
							<a href="gosignin.do" class="my-auto"> <i
								class="fa-solid fa-pen-nib fa-2xl"></i>
							</a>
							<!-- 로그인X 시 나타날 로그인 버튼 -->
							<a href="gologin.do" class="my-auto"> <i
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

	<!-- Single Page Header start -->
	<div class="container-fluid page-header py-5">
		<h1 class="text-center text-white display-6">환불규정</h1>
	</div>
	<!-- Single Page Header End -->


	<!-- 표표표표표표표표 -->
	<section class="notice">
		<div class="page-title">
			<div class="container">

				<img class="refund-img" src="./img/refund.png" alt="">
			</div>
		</div>


		<div id="board-list">
			<div class="container">
				<table class="board-table">
					<thead>
						<tr>
							<th scope="col" class="th-num">번호</th>
							<th scope="col" class="th-title">제목</th>
							<th scope="col" class="th-date">등록일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<th>
								<div class="faq-content">
									<button class="question" id="que-1">
										<span id="que-1-toggle">+</span><span>예약 취소 및 환불 요청</span>
									</button>
									<div class="answer" id="ans-1">
										1. 고객은 예약한 버스 대절 서비스를 시작하기 전에 언제든지 예약을 취소할 수 있습니다.<br> 2.
										환불 요청은 전화, 이메일 또는 홈페이지를 통해 접수될 수 있습니다.<br> 3. 환불 금액은 예약
										취소 시점에 따라 달라집니다.<br>
									</div>
								</div>
							</th>
							<td>2024.03.21</td>
						</tr>

						<tr>
							<td>2</td>
							<th>
								<div class="faq-content">
									<button class="question" id="que-2">
										<span id="que-2-toggle">+</span><span>환불 가능 금액</span>
									</button>
									<div class="answer" id="ans-2">
										1. 모집 시작일로부터 5일 이내: 전액 환불<br> 2. 셔틀 마감일 이전의 취소: 예약금의 90%
										환불<br> 3. 셔틀 마감일 이후의 취소: 예약금의 50% 환불<br>
									</div>
								</div>
							</th>
							<td>2024.03.21</td>
						</tr>

						<tr>
							<td>3</td>
							<th>
								<div class="faq-content">
									<button class="question" id="que-3">
										<span id="que-3-toggle">+</span><span>환불 처리 기간</span>
									</button>
									<div class="answer" id="ans-3">
										1. 환불 요청이 접수된 후, 환불 처리에는 최대 7일(영업일 기준)이 소요될 수 있습니다.<br>
										2. 환불은 원래 결제 방식을 통해 이루어집니다.<br> 3. 단, 모집인원 미달로 인한 취소 및
										자연재해, 정부의 강제 조치 등 불가항력적인 사유로 인한 예약 취소의 경우, 전액 환불이 가능하며 최대
										1일(영업일 기준)이내에 환불 진행됩니다.<br>
									</div>
								</div>
							</th>
							<td>2024.03.21</td>
						</tr>
					</tbody>
				</table>
				<!-- 해당 부분 관리자 계정만 글 쓰기 버튼 보이게 설정 -->
				<button type="button" class="addinfo"
					onclick="addInfo('${boardId}')">글 쓰기</button>
			</div>
		</div>

	</section>


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

		<script>


		const items = document.querySelectorAll('.question');

		function openCloseAnswer() {
		  const answerId = this.id.replace('que', 'ans');
		  const answerElement = document.getElementById(answerId);

		  if (answerElement.style.display === 'block' || answerElement.style.display === '') {
		    answerElement.style.display = 'none';
		    document.getElementById(this.id + '-toggle').textContent = '+';
		  } else {
		    answerElement.style.display = 'block';
		    document.getElementById(this.id + '-toggle').textContent = '-';
		  }
		}

		items.forEach(item => item.addEventListener('click', openCloseAnswer));



		</script>



		<!-- JavaScript Libraries -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
		<script src="lib/easing/easing.min.js"></script>
		<script src="lib/waypoints/waypoints.min.js"></script>
		<script src="lib/lightbox/js/lightbox.min.js"></script>
		<script src="lib/owlcarousel/owl.carousel.min.js"></script>


		<!-- Template Javascript -->
		<script src="js/main.js"></script>
</body>

</html>