function PayMent() {

	var IMP = window.IMP;
	IMP.init("imp64663086");
	IMP.request_pay({
		pg: 'html5_inicis.INIpayTest',
		pay_method: 'card',
		merchant_uid: 'uid' + + new Date().getTime(), 
		name: $("#eventName").text(), 
		amount: $("#allTotAmtLocD").text(),  
		buyer_email: '',  
		buyer_tel: '' 
	}, function(rsp) { 
		if (rsp.success) {
			var msg = '결제가 완료되었습니다.'; 
			msg += '고유ID : ' + rsp.imp_uid;
			msg += '상점 거래ID : ' + rsp.merchant_uid;
			msg += '결제 금액 : ' + rsp.paid_amount;
			msg += '카드 승인번호 : ' + rsp.apply_num;
			msg += '구매자 아이디 : ' + rsp.buyer_email;
			msg += '구매자 전화번호 : ' + rsp.buyer_tel;
			alert(msg);
			console.log(rsp.merchant_uid);
			pay_info(rsp);
			location.replace("index.html");

		} else {
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
			var seatList = encodeURIComponent(seatNum.join(','));
			var url = "bookingUpdate.do?pay=" + pay + "&seatList=" + seatList + "&shuttleID=" + shuttleID;
			window.location.href = url;
		}
	});

}

