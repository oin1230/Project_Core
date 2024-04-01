// 좌석 선택에 따른 가격 계산을 위한 함수
var totalPriceText = calculatePrice();

function calculatePrice() {
	// 선택된 좌석 수를 가져옵니다.
	var selectedSeats = document.querySelectorAll('.seat.selected');
	// 총 선택된 좌석 수를 계산합니다.
	var selectedSeatsCount = selectedSeats.length;
	// 좌석 당 가격을 가져와서 숫자로 변환합니다.
	// jQuery에서 가져온 텍스트를 숫자로 변환합니다.
	var pricePerSeatText = $(".allTotAmtLocD").text();
	// 가격 가져오는거 
	var pricePerSeat = parseInt(pricePerSeatText.replace(/,/g, ''));
	// 총 가격을 계산합니다.
	var totalPrice = selectedSeatsCount * pricePerSeat;
	// 총 가격을 페이지에 표시합니다.
	selectedSeatsCount = selectedSeats.length + '명';
	totalPriceText = totalPrice;

	let result = {
		"totalPriceText": totalPriceText,
		"totalSeat": selectedSeatsCount
	}

	// document.addEventListener('DOMContentLoaded', function() {
	// 결제 금액 업데이트 함수
	// function updateTotalPrice(totalPrice) {
	//	var totalPrices = document.querySelectorAll('.allTotAmtLocD');
	//	totalPrices.forEach(function(priceElement) {
	//		priceElement.innerText = totalPrice + '원';
	//	});
	// }
	// });
	// document.getElementsByClassName('allTotAmtLocD').textContent = totalPrices + '원';

	return result;

}


// 'allTotAmtLocD' 클래스를 가진 모든 요소를 찾아 총 가격을 할당합니다.
var totalPrices = document.querySelectorAll('.allTotAmtLocD');
console.log("totalPrices 확인 >> ", totalPrices);
totalPrices[1];

// 선택된 좌석 수를 표시합니다.
//document.getElementById('adltCnt').textContent = selectedSeatsCount + '명';
//}

// ///////////////////인영

// 좌석 선택/해제 이벤트 처리
const seats = document.querySelectorAll('.seat');

// 1. seat의 번호를 저장할 배열 선언
const seatNum = [];

seats.forEach(function(seat) {
	seat.addEventListener('click', function() {

		if (!seat.classList.contains('occupied')) {
			seat.classList.toggle('selected');

			// 선택된 좌석의 번호를 변수에 저장
			const seatNumber = parseInt(seat.textContent);

			// 좌석의 번호가 배열에 저장되어 있는지를 확인
			// 번호가 없다면 -1 반환, 있다면 해당 인덱스 반환
			const index = seatNum.indexOf(seatNumber);
			if (index === -1) {
				// 인덱스가 -1이라면 해당 좌석의 번호를 인덱스에 저장
				seatNum.push(seatNumber);
			} else {
				// 인덱스가 반환된다면, 해당 인덱스를 지우겠다. (index번호, index로부터 지울 갯수)
				// 인덱스번호가 0이반환되다면, 지울 갯수가 1일경우, 0 을 지움
				seatNum.splice(index, 1);
			}
		}

		console.log('선택된 좌석:', seatNum);
		$("#allTotAmtLocD").text(calculatePrice().totalPriceText);
		$("#adltCnt").text(calculatePrice().totalSeat);

	});
});


/*
// 결제하기 버튼을 클릭 시 실행하는 함수
 $("#bookingUpdate").click(function() {

	PayMent();

	// url로부터 주소 가져오기
	var queryString = window.location.search;

	// 자바스크립트의 내장객체인 URLSearchParams 객체 생성하여 쿼리 문자열 파싱
	var params = new URLSearchParams(queryString);

	// 파라미터로부터 SHTML_ID 가져와서 uri로 인코딩하기
	var shuttleID = encodeURIComponent(params.get('SHTL_ID'));

	console.log(shuttleID);
	// 전체 결제 금액 가져오기
	// uri이 올바르게 작동하지않을경우를 대비해 안정성을 높이기 위한 인코딩 구문 추가
	var pay = encodeURIComponent($("#allTotAmtLocD").text());
	// seatNum배열을 문자열 형태로만들기
	// 배열들을 ,을 기준으로 합침 1,2,3 이런식으로
	var seatList = encodeURIComponent(seatNum.join(','));
	var url = "bookingUpdate.do?pay=" + pay + "&seatList=" + seatList + "&shuttleID=" + shuttleID;

	window.location.href = url;

});
*/

// ///////////////////인영 끝//////////////////


// 페이지 로드 시 초기화 함수 실행
window.onload = function() {
	calculatePrice();
};