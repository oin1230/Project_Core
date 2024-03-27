function AFindID() {
	let AInfoID = {
		"AInfoID": $("#findID").val()
	};
	$.ajax({

		url: "AFindInfo.do",
		type: 'post',
		data: AInfoID,
		dataType: "json",
		/*contentType: 'application/json; charset=utf-8',*/
		success: function(res) {
			alert("회원님의 이메일은" + res.email + "입니다")


		},
		error: function() {
			alert("핸드폰번호를 확인해주세요")
		}
	})

}

function AFindPW() {
	let AInfoPW = {
		"AInfoPW": $("#findPW").val()
	};
	$.ajax({

		url: "AFindInfo.do",
		type: 'post',
		data: AInfoPW,
		dataType: "json",
		/*contentType: 'application/json; charset=utf-8',*/
		success: function(res) {
			alert("회원님의 비밀번호를 입력하신" + res.email + "이메일로 발송해드렸습니다.")
			// 데이터베이스 확인하고 입력된 이메일로 보내주기

		},
		error: function() {
			alert("이메일을 확인해주세요")
		}
	})
}

function likePlus(id) {
	let b_id = {
		"b_id": id
	};

	$.ajax({

		url: "boardLikeUpdate.do",
		type: "post",
		data: b_id,
		//dataType : "json",
		success: function(res) {
			// 확인용
			console.log(res);

			console.log($("#likePlus").text());
			if (res == $("#likePlus").text()) {
				alert("이미 추천 했습니다.");
			} else {
				$("#likePlus").text(res);
			}
		},
		error: function() {

			alert("서버 점검 중이요");
		}
	})

}


