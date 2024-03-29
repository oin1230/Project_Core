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
	totalPriceText = totalPrice + '원';
	
	let result ={
		"totalPriceText" : totalPriceText,
		"totalSeat" : selectedSeatsCount
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

// 좌석 선택/해제 이벤트 처리
const seats = document.querySelectorAll('.seat');
seats.forEach(function(seat) {
	seat.addEventListener('click', function() {
		if (!seat.classList.contains('occupied')) {
			seat.classList.toggle('selected');
		}
		
		$("#allTotAmtLocD").text(calculatePrice().totalPriceText);
		$("#adltCnt").text(calculatePrice().totalSeat);

		//calculatePrice(); // 좌석 선택 상태가 변경될 때마다 가격을 다시 계산합니다.


	});
});

// 페이지 로드 시 초기화 함수 실행
window.onload = function() {
	calculatePrice();
};