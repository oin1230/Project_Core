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

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/style.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<i class="fas fa-user fa-2x"></i>
<script src="https://kit.fontawesome.com/fdb678099a.js"
	crossorigin="anonymous"></script>
</head>

<body>

	<div id="spinner"
		class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
		<div class="spinner-grow text-primary" role="status"></div>
	</div>

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

	<div class="container-fluid page-header py-5">
		<h1 class="text-center text-white display-6">QNA</h1>
	</div>

	<section class="notice">
		<div class="page-title">
			<div class="container">
				<img class="qna-img" src="./img/QnA.png" alt="">
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
										<span id="que-1-toggle">+</span><span>환불을 받고싶어요, 어떻게
											해야하나요?</span>
									</button>
									<div class="answer" id="ans-1">

										환불에 대한 규정은 환불규정 페이지에서 자세히 확인하실 수 있습니다.<br> 고객님의 단순변심에 의한
										환불은 질문게시판에 글을 작성해주시면 최소 1일 ~ 최장 7일까지의 소요시간에 거쳐서 환불이 진행됩니다.<br>
										모집인원이 모이지 않아 조기 마감되었을 경우에는 고객님이 원하시는 방법으로 자동으로 환불이 진행됩니다.<br>

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
										<span id="que-2-toggle">+</span><span>제가 원하는 곳으로 가는 버스가
											없어요 따로 신청하는 방법은 없나요?</span>
									</button>
									<div class="answer" id="ans-2">
										상단의 메뉴바에 있는 BOARD에 있는 질문 게시판을 통하여 신청해주시면 확인 후 도와드릴 수 있습니다.<br>
										신청에 의한 모집은 확정까지 다소 시간이 걸릴 수 있으니 최소 3일의 여유를 가지고 신청을 해주시면
										감사하겠습니다.
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
										<span id="que-3-toggle">+</span><span>버스 운전자인데 서비스 제공 할
											수 있을까요?</span>
									</button>
									<div class="answer" id="ans-3">
										네 물론입니다.<br> 회원가입을 진행해주실때 우측 하단에 보시면 운전자용 회원가입 탭이 준비되어
										있습니다.<br> 그 곳을 통해 회원가입 후 당사에서 심사 후 저희 서비스를 이용하실 수 있도록
										준비되어있습니다.<br>
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

	<div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
		<div class="pb-4 mb-4 logo"
			style="border-bottom: 1px solid rgba(226, 175, 24, 0.5);">
			<img id="footerLogo" src="./img/ft_logo.png" alt="">
		</div>

		<div class="container">
			<span class="text-light"><a href="#"><i
					class="fas fa-copyright text-light me-2"></i>BUSTIVAL</a></span> <br> <span><a
				href="#">깃허브 주소</a></span> <br> <a href="https://smhrd.or.kr/">스마트인재개발원</a>
		</div>

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

		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
		<script src="lib/easing/easing.min.js"></script>
		<script src="lib/waypoints/waypoints.min.js"></script>
		<script src="lib/lightbox/js/lightbox.min.js"></script>
		<script src="lib/owlcarousel/owl.carousel.min.js"></script>

		<script src="js/main.js"></script>
</body>

</html>