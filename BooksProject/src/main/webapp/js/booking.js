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
	return result;
}

var totalPrices = document.querySelectorAll('.allTotAmtLocD');
console.log("totalPrices 확인 >> ", totalPrices);
totalPrices[1];

const seats = document.querySelectorAll('.seat');

const seatNum = [];

seats.forEach(function(seat) {
	seat.addEventListener('click', function() {

		if (!seat.classList.contains('occupied')) {
			seat.classList.toggle('selected');

			const seatNumber = parseInt(seat.textContent);

			const index = seatNum.indexOf(seatNumber);
			if (index === -1) {
				seatNum.push(seatNumber);
			} else {
				seatNum.splice(index, 1);
			}
		}

		console.log('선택된 좌석:', seatNum);
		$("#allTotAmtLocD").text(calculatePrice().totalPriceText);
		$("#adltCnt").text(calculatePrice().totalSeat);

	});
});

window.onload = function() {
	calculatePrice();
};