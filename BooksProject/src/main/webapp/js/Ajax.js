function AFindID() {
	let AInfoID = {
		"AInfoID": $("#findID").val()
	};
	$.ajax({
		url: "AFindInfo.do",
		type: 'post',
		data: AInfoID,
		dataType: "json",
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
		success: function(res) {
			alert("회원님의 비밀번호를 입력하신" + res.email + "이메일로 발송해드렸습니다.")
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
		success: function(res) {
			console.log($("#likePlus").text());
			if (res == $("#likePlus").text()) {
				alert("이미 추천 했습니다.");
			} else {
				$("#likePlus").text(res);
			}
		},
		error: function() {
			alert("로그인 확인해주세요");
		}
	})
}
function Comment(id) {
	let data = {
		"b_id": id,
		"comment": $("#contentComment").val()
	};
	console.log($("#contentComment").val());
	$.ajax({
		url: "commentRegister.do",
		type: "post",
		data: data,
		dataType: "json",
		success: function(res) {
			$("#contentComment").val('');
			var commentText = res.cmt_content;
			var date = res.cmt_date;
			var email = res.email;
			var commentDiv = document.createElement("div");
			commentDiv.className = "card my-3";
			commentDiv.innerHTML = `
        <div class="card-body">
            <p class="card-text">${commentText}</p>
            <p class="card-text"><small class="text-muted">${date}</small></p>
            <p class="card-text"><small class="text-muted">${email}</p>
        </div>
    `;
			var commentsDiv = document.querySelector(".comments");
			commentsDiv.insertBefore(commentDiv, commentsDiv.firstChild);
			commentInput.value = "";
		},
		error: function() {
			alert("로그인 해주세요");
		}
	})
}

function boardRegister() {
	$.ajax({
		url: "boardRegisterCheck.do",
		type: "post",
		data: data,
		dataType: "json",
		success: function(res) {
			window.location.href = "boardWrite.jsp?value=" + data;
		},
		error: function() {
			alert("로그인 해주세요");
		}
	})
}

function Login() {
	$.ajax({
		url: "boardLikeUpdate.do",
		type: "post",
		data: b_id,
		success: function(res) {
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






$(function() {
	$('#loginSubmit').on("click", function() {
		var form = $("#login-form").serialize();
		$.ajax({
			type: "post",
			url: "/login/check",
			data: form,
			dataType: 'json',
			success: function(data) {
				alert("success");
				console.log(data);
			},
			error: function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);

			}
		});
	});
});




