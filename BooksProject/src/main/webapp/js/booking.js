
//예약

// 좌석 선택에 따른 가격 계산을 위한 함수
function calculatePrice() {


  // 선택된 좌석 수를 가져옵니다.
  var selectedSeats = document.querySelectorAll('.seat.selected');
  // 총 선택된 좌석 수를 계산합니다.
  var selectedSeatsCount = selectedSeats.length;
  // 좌석 당 가격을 설정합니다. 예를 들어, 1000원으로 설정합니다.
  var pricePerSeat = 1000;
  // 총 가격을 계산합니다.
  var totalPrice = selectedSeatsCount * pricePerSeat;
  // 총 가격을 페이지에 표시합니다.
  var totalPriceText = totalPrice + '원';
  document.getElementById('allTotAmtLocD').textContent = totalPriceText;

  // id가 'allTotAmtLocD'인 요소를 찾아 총 가격을 할당합니다.
  var totalPrices = document.querySelectorAll('#allTotAmtLocD');
  totalPrices.forEach(function (element) {
    element.textContent = totalPriceText;
  });

  // 선택된 좌석 수를 표시합니다.
  document.getElementById('adltCnt').textContent = selectedSeatsCount + '명';
}

// 좌석 선택/해제 이벤트 처리
var seats = document.querySelectorAll('.seat');
seats.forEach(function (seat) {
  seat.addEventListener('click', function () {
    if (!seat.classList.contains('occupied')) {
      seat.classList.toggle('selected');
      calculatePrice(); // 좌석 선택 상태가 변경될 때마다 가격을 다시 계산합니다.
    }
  });
});

// 좌석 선택 시 초기 가격 계산
calculatePrice();


// 페이지 로드 시 초기화 함수 실행
window.onload = function () {
  calculatePrice();
};

