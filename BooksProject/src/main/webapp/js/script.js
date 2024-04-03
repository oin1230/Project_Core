const movieSelect = document.getElementById('choice');
const container = document.querySelector('.container');
const seats = document.querySelectorAll('.row .seat:not(.occupied)');
const count = document.getElementById('count');
const total = document.getElementById('total');

populateUI();
function populateUI() {
  const selectedSeats = JSON.parse(localStorage.getItem('selectedSeats'));
  if (selectedSeats !== null && selectedSeats.length > 0) {
    selectedSeats.forEach((seatIndex) => {
      seats[seatIndex].classList.add('selected');
    });
  }
}

function updateSelectedCount() {
  const selectedSeats = document.querySelectorAll('.row .selected');
  const selectedSeatCount = +selectedSeats.length;
  const selectedSeatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));
  localStorage.setItem('selectedSeats', JSON.stringify(selectedSeatsIndex));
  count.textContent = selectedSeatCount;
}

container.addEventListener('click', (event) => {
  if (event.target.classList.contains('seat') && !event.target.classList.contains('occupied')) {
    event.target.classList.toggle('selected');
    updateSelectedCount();
  }
});

document.querySelector('.btnC').addEventListener('click', () => {
  const selectedSeats = document.querySelectorAll('.row .seat.selected');
  const selectedSeatsIndex = [...selectedSeats].map(seat => [...seats].indexOf(seat));
  fetch('http://your-server.com/save-seats', {
    method: 'POST', 
    headers: {
      'Content-Type': 'application/json', 
    },
    body: JSON.stringify({selectedSeatsIndex}), 
  })
  .then(response => response.json()) 
  .then(data => console.log(data)) 
  .catch(error => console.error('Error:', error)); 
  alert("전송 성공")
});

updateSelectedCount();