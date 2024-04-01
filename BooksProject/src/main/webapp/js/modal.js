/* 모달 */

'use strict';
// 클래스별 변수 지정
const openBtns = document.querySelectorAll(".modalOpen");
const closeBtn = document.querySelector(".modalClose");
const modal = document.querySelector('.modalBg');

openBtns.forEach(function(openBtn) {
	openBtn.addEventListener('click', function() {
		let bookId = openBtn.getAttribute("data-book-id"); // 각 버튼마다 고유한 bookId 값을 가져옴
		showModal(); // 모달을 보여주는 함수 호출		
		$("#cancleCheck").val(bookId);
	});
})

closeBtn.addEventListener('click', closeModal);

// 모달 보여주기
function showModal() {
	console.log("들어옴")
	modal.classList.remove('hidden');
	modal.classList.add('visible');
}

//모달 닫기
function closeModal() {
	modal.classList.remove('visible');
	modal.classList.add('hidden');
}

function cancleCheck(id) {
	window.location.href = "bookingCancle.do?book_id=" + id;
	alert("신청취소 되었습니다.")
}
