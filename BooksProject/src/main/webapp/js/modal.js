/* 모달 */

'use strict';
// 클래스별 변수 지정
const openBtns = document.querySelectorAll(".modalOpen");
const closeBtn = document.querySelector(".modalClose");
const modal = document.querySelector('.modalBg');

// 버튼을 누르면 모달 여/닫기
openBtns.forEach(function(openBtn) {
	openBtn.addEventListener('click', showModal);
});
closeBtn.addEventListener('click', closeModal);

// 모달 보여주기
function showModal() {
	console.log("들어옴")
	modal.classList.remove('hidden');
	modal.classList.add('visible');
}

// 모달 닫기
function closeModal() {
	modal.classList.add('hidden');
	modal.classList.remove('visible');
}

function cancleCheck(id) {
	window.location.href = "bookingCancle.do?book_id="+id;
	alert("신청취소 되었습니다.")
}
