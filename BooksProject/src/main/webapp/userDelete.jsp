<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<a href="#" class="nav-item nav-link dropdown-toggle"
								data-bs-toggle="dropdown">BUSTIVAL</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="#" class="dropdown-item">신청게시판</a> <a href="#"
									class="dropdown-item">요청게시판</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="#" class="nav-item nav-link dropdown-toggle"
								data-bs-toggle="dropdown">CONCERT</a>
							<div class="dropdown-menu m-0 bg-secondary rounded-0">
								<a href="#" class="dropdown-item">발라드</a> <a href="#"
									class="dropdown-item">아이돌</a> <a href="#" class="dropdown-item">트로트</a>
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




	<!-- Single Page Header start -->
	<div class="container-fluid page-header py-5">
		<h1 class="text-center text-white display-6">회원탈퇴</h1>
		<ol class="breadcrumb justify-content-center mb-0">
			<h2>본인확인을 위해 정확한 비밀번호를 입력해주세요.</h2>
		</ol>
	</div>
	<!-- Single Page Header End -->

	<br>
	<br>
	<div class="container mb-4 main-container">
		<div class="row">
			<div class="col-lg-4 pb-5">
				<!-- Account Sidebar-->
				<div class="author-card pb-3">
					<div class="author-card-profile">
						<div class="author-card-details">
							<h4 class="author-card-name text-lg">Nickname</h4>
						</div>
					</div>
				</div>
				<div class="wizard">
					<nav class="list-group list-group-flush">
						<a class="list-group-item" href="myPage.jsp" tagert="__blank"><i
							class="fa fa-tag mr-1 text-muted"></i>마이페이지</a> <a
							class="list-group-item" href="userUpdateUserInfo.do" target="__blank"><i
							class="fa fa-user text-muted"></i> 회원정보 수정</a> <a
							class="list-group-item" href="userPwEdit.jsp" tagert="__blank"><i
							class="fa fa-heart mr-1 text-muted"></i>비밀번호 변경</a> <a
							class="list-group-item" href="userDelete.jsp" target="__blank"><i
							class="fa fa-user text-muted"></i> 회원탈퇴</a>
					</nav>
				</div>
			</div>


			<!-- user  -->
			<div class="col-lg-8 pb-5">
				<div class="d-flex justify-content-end pb-3">
				
					<c:if test="${userDeletePwChecking != 'Y'}">
						<form action="userDeletePwCheck.do" id="edit-form">
							<label for="nickname">비밀번호 입력</label> <input type="password"
								name="PW" class="form-control" value="" id="ePwC"
								placeholder="비밀번호를 입력해주세요">

							<button class="btn btn-primary btn-lg btn-block find-button"
								onclick="WithDraw()" type="submit">회원탈퇴</button>
						</form>
					</c:if>
					
					<c:if test="${userDeletePwChecking == 'Y'}">
						<script type="text/javascript">
							alert("비밀번호가 일치하지 않습니다");
						</script>
						<%
						session.setAttribute("userDeletePwChecking", "N");
						%>
						<form action="userDeletePwCheck.do" id="edit-form">
							<label for="nickname">비밀번호 입력</label> <input type="password"
								name="PW" class="form-control" value="${PW}" id="ePwC"
								placeholder="비밀번호를 입력해주세요">

							<button class="btn btn-primary btn-lg btn-block find-button"
								onclick="WithDraw()" type="submit">회원탈퇴</button>
						</form>
					</c:if>
					
					
				</div>
			</div>
		</div>
	</div>


	<div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
		<div class="pb-4 mb-4 logo"
			style="border-bottom: 1px solid rgba(226, 175, 24, 0.5);">
			<img id="footerLogo" src="./img/ft_logo.png" alt="">
		</div>
		<!-- Footer End -->

		<!-- Copyright Start -->
		<div class="container">
			<div class="row">
				<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
					<span class="text-light"><a href="#"><i
							class="fas fa-copyright text-light me-2"></i>BUSTIVAL</a> Books Team</span>
					<br> <span><a href="#">깃허브 주소</a></span>
					<!--깃허브 주소 넣기.-->
				</div>
				<div class="col-md-6 my-auto text-center text-md-end text-white">
					<a href="https://smhrd.or.kr/">스마트인재개발원</a>
				</div>
			</div>
		</div>
		<!-- Copyright End -->
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