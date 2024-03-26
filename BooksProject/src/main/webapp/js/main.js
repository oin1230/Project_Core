(function($) {
	"use strict";

	// Spinner
	var spinner = function() {
		setTimeout(function() {
			if ($('#spinner').length > 0) {
				$('#spinner').removeClass('show');
			}
		}, 1);
	};
	spinner(0);


	// Fixed Navbar
	$(window).scroll(function() {
		if ($(window).width() < 992) {
			if ($(this).scrollTop() > 55) {
				$('.fixed-top').addClass('shadow');
			} else {
				$('.fixed-top').removeClass('shadow');
			}
		} else {
			if ($(this).scrollTop() > 55) {
				$('.fixed-top').addClass('shadow').css('top', -55);
			} else {
				$('.fixed-top').removeClass('shadow').css('top', 0);
			}
		}
	});


	// Back to top button
	$(window).scroll(function() {
		if ($(this).scrollTop() > 300) {
			$('.back-to-top').fadeIn('slow');
		} else {
			$('.back-to-top').fadeOut('slow');
		}
	});
	$('.back-to-top').click(function() {
		$('html, body').animate({ scrollTop: 0 }, 1500, 'easeInOutExpo');
		return false;
	});

/* 오류발생으로 주석처리
	// Testimonial carousel
	$(".testimonial-carousel").owlCarousel({
		autoplay: true,
		smartSpeed: 2000,
		center: false,
		dots: true,
		loop: true,
		margin: 25,
		nav: true,
		navText: [
			'<i class="bi bi-arrow-left"></i>',
			'<i class="bi bi-arrow-right"></i>'
		],
		responsiveClass: true,
		responsive: {
			0: {
				items: 1
			},
			576: {
				items: 1
			},
			768: {
				items: 1
			},
			992: {
				items: 2
			},
			1200: {
				items: 2
			}
		}
	});


	// vegetable carousel
	$(".vegetable-carousel").owlCarousel({
		autoplay: true,
		smartSpeed: 1500,
		center: false,
		dots: true,
		loop: true,
		margin: 25,
		nav: true,
		navText: [
			'<i class="bi bi-arrow-left"></i>',
			'<i class="bi bi-arrow-right"></i>'
		],
		responsiveClass: true,
		responsive: {
			0: {
				items: 1
			},
			576: {
				items: 1
			},
			768: {
				items: 2
			},
			992: {
				items: 3
			},
			1200: {
				items: 4
			}
		}
	});
*/

	// Modal Video
	$(document).ready(function() {
		var $videoSrc;
		$('.btn-play').click(function() {
			$videoSrc = $(this).data("src");
		});
		console.log($videoSrc);

		$('#videoModal').on('shown.bs.modal', function(e) {
			$("#video").attr('src', $videoSrc + "?autoplay=1&amp;modestbranding=1&amp;showinfo=0");
		})

		$('#videoModal').on('hide.bs.modal', function(e) {
			$("#video").attr('src', $videoSrc);
		})
	});



	// Product Quantity
	$('.quantity button').on('click', function() {
		var button = $(this);
		var oldValue = button.parent().parent().find('input').val();
		if (button.hasClass('btn-plus')) {
			var newVal = parseFloat(oldValue) + 1;
		} else {
			if (oldValue > 0) {
				var newVal = parseFloat(oldValue) - 1;
			} else {
				newVal = 0;
			}
		}
		button.parent().parent().find('input').val(newVal);
	});

})(jQuery);


// 회원가입 js코드

window.addEventListener('load', () => {
	const forms = document.getElementsByClassName('validation-form');

	Array.prototype.filter.call(forms, (form) => {
		form.addEventListener('submit', function(event) {
			if (form.checkValidity() === false) {
				event.preventDefault();
				event.stopPropagation();
			}

			form.classList.add('was-validated');
		}, false);
	});
}, false);

// 회원가입 끝

// 찾기 시작
(function($) {
	"use strict";

	// Spinner
	var spinner = function() {
		setTimeout(function() {
			if ($('#spinner').length > 0) {
				$('#spinner').removeClass('show');
			}
		}, 1);
	};
	spinner(0);


	// Fixed Navbar
	$(window).scroll(function() {
		if ($(window).width() < 992) {
			if ($(this).scrollTop() > 55) {
				$('.fixed-top').addClass('shadow');
			} else {
				$('.fixed-top').removeClass('shadow');
			}
		} else {
			if ($(this).scrollTop() > 55) {
				$('.fixed-top').addClass('shadow').css('top', -55);
			} else {
				$('.fixed-top').removeClass('shadow').css('top', 0);
			}
		}
	});


	// Back to top button
	$(window).scroll(function() {
		if ($(this).scrollTop() > 300) {
			$('.back-to-top').fadeIn('slow');
		} else {
			$('.back-to-top').fadeOut('slow');
		}
	});
	$('.back-to-top').click(function() {
		$('html, body').animate({ scrollTop: 0 }, 1500, 'easeInOutExpo');
		return false;
	});

/* 오류발생으로 주석처리
	// Testimonial carousel
	$(".testimonial-carousel").owlCarousel({
		autoplay: true,
		smartSpeed: 2000,
		center: false,
		dots: true,
		loop: true,
		margin: 25,
		nav: true,
		navText: [
			'<i class="bi bi-arrow-left"></i>',
			'<i class="bi bi-arrow-right"></i>'
		],
		responsiveClass: true,
		responsive: {
			0: {
				items: 1
			},
			576: {
				items: 1
			},
			768: {
				items: 1
			},
			992: {
				items: 2
			},
			1200: {
				items: 2
			}
		}
	});


	// vegetable carousel
	$(".vegetable-carousel").owlCarousel({
		autoplay: true,
		smartSpeed: 1500,
		center: false,
		dots: true,
		loop: true,
		margin: 25,
		nav: true,
		navText: [
			'<i class="bi bi-arrow-left"></i>',
			'<i class="bi bi-arrow-right"></i>'
		],
		responsiveClass: true,
		responsive: {
			0: {
				items: 1
			},
			576: {
				items: 1
			},
			768: {
				items: 2
			},
			992: {
				items: 3
			},
			1200: {
				items: 4
			}
		}
	});
*/

	// Modal Video
	$(document).ready(function() {
		var $videoSrc;
		$('.btn-play').click(function() {
			$videoSrc = $(this).data("src");
		});
		console.log($videoSrc);

		$('#videoModal').on('shown.bs.modal', function(e) {
			$("#video").attr('src', $videoSrc + "?autoplay=1&amp;modestbranding=1&amp;showinfo=0");
		})

		$('#videoModal').on('hide.bs.modal', function(e) {
			$("#video").attr('src', $videoSrc);
		})
	});



	// Product Quantity
	$('.quantity button').on('click', function() {
		var button = $(this);
		var oldValue = button.parent().parent().find('input').val();
		if (button.hasClass('btn-plus')) {
			var newVal = parseFloat(oldValue) + 1;
		} else {
			if (oldValue > 0) {
				var newVal = parseFloat(oldValue) - 1;
			} else {
				newVal = 0;
			}
		}
		button.parent().parent().find('input').val(newVal);
	});

})(jQuery);


// 회원가입 js코드

window.addEventListener('load', () => {
	const forms = document.getElementsByClassName('validation-form');

	Array.prototype.filter.call(forms, (form) => {
		form.addEventListener('submit', function(event) {
			if (form.checkValidity() === false) {
				event.preventDefault();
				event.stopPropagation();
			}

			form.classList.add('was-validated');
		}, false);
	});
}, false);

// 회원가입 끝

// 찾기 시작

// 프로그레스바

document.addEventListener('DOMContentLoaded', function() {
  var totalSeats = [28, 28, 28, 28, 28, 28, 28]; // 각 프로그레스바에 대한 전체 좌석 수 예시
  var bookedSeats = [10, 20, 8, 11, 22, 25, 20]; // 각 프로그레스바에 대한 예약된 좌석 수 예시
  var progressBars = document.getElementsByClassName("progressBar");

  for (var i = 0; i < progressBars.length; i++) {
    var bookedPercentage = (bookedSeats[i] / totalSeats[i]) * 100;
    progressBars[i].style.width = bookedPercentage + '%';
  }
});



