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

		if (!seat.classList.contains('seatOccupied')) {
			seat.classList.toggle('selected');
		}


		if (!seat.classList.contains('seatOccupied')) {
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
		} else if (seat.classList.contains('seatOccupied')) {
			alert("예매가 불가능합니다.");
		}

		console.log('선택된 좌석:', seatNum);
		$("#allTotAmtLocD").text(calculatePrice().totalPriceText);
		$("#adltCnt").text(calculatePrice().totalSeat);

	});
});

window.onload = function() {
	calculatePrice();
};