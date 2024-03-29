package com.smhrd.database;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.model.BoardVO;
import com.smhrd.model.CommentVO;
import com.smhrd.model.EventVO;
import com.smhrd.model.SeatVO;
import com.smhrd.model.BoardLikeVO;
import com.smhrd.model.ShuttleVO;
import com.smhrd.model.UserVO;
import com.smhrd.model.myPageVO;
import com.smhrd.model.pageVO;

public class DAO {

	// git
	private SqlSessionFactory factory = MySqlSessionManager.getSqlSessionFactory();

	public int Join(UserVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.insert("Join", vo);

		session.close();

		return row;
	}

	public UserVO Login(UserVO vo) {
		SqlSession session = factory.openSession(true);

		UserVO resultVo = session.selectOne("Login", vo);

		session.close();

		return resultVo;

	}

	public List<ShuttleVO> Shuttle() {

		SqlSession session = factory.openSession(true);

		List<ShuttleVO> resultVo = session.selectList("Shuttle");

		session.close();

		return resultVo;
	}

	public void userUpdate(UserVO vo) {

		SqlSession session = factory.openSession(true);

		session.update("userUpdate", vo);

		session.close();
	}

	public int shuttRegister(ShuttleVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.insert("shuttRegister", vo);

		session.close();

		return row;
	}

	public int userDelete(UserVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.delete("userDelete", vo);

		session.close();

		return row;

	}

	public int pwUpdate(UserVO vo) {
		SqlSession session = factory.openSession(true);
		int row = session.update("pwUpdate", vo);
		session.close();

		return row;
	}

	public BoardVO boardDetail(BoardVO vo) {

		// 1. 연결객체 생성하기
		SqlSession session = factory.openSession(true);

		// 2. 연결객체 사용하기
		BoardVO resultVo = session.selectOne("boardDetail", vo);

		// 3. 연결객체 반납하기
		session.close();

		// 4. 결과값 반환하기
		return resultVo;
	}

	public int boardDelete(BoardVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.delete("boardDelete", vo);

		session.close();

		return row;

	}

	public UserVO AFindInfo(UserVO vo) {
		SqlSession session = factory.openSession(true);

		UserVO resultId = session.selectOne("AFindInfo", vo);

		session.close();

		return resultId;

	}

	public void boardRegister(BoardVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.insert("boardRegister", vo);

		session.close();

	}

	public List<EventVO> eventList() {

		SqlSession session = factory.openSession(true);

		List<EventVO> resultVo = session.selectList("eventList");

		session.close();

		return resultVo;
	}

	public List<ShuttleVO> bookingList(ShuttleVO vo) {

		SqlSession session = factory.openSession(true);

		List<ShuttleVO> resultVo = session.selectList("bookingList", vo);

		session.close();

		return resultVo;
	}

	public List<EventVO> mainEventlist() {

		SqlSession session = factory.openSession(true);

		List<EventVO> resultVo = session.selectList("mainEventlist");

		session.close();

		return resultVo;
	}

	public List<BoardVO> boardList(BoardVO vo) {

		SqlSession session = factory.openSession(true);

		List<BoardVO> resultVo = session.selectList("boardList", vo);

		session.close();

		return resultVo;
	}

	public List<SeatVO> progressBar(SeatVO vo) {
		SqlSession session = factory.openSession(true);

		List<SeatVO> resultVo = session.selectList("progressBar", vo);

		session.close();

		return resultVo;
	}

	public void boardUpdate(BoardVO vo) {

		SqlSession session = factory.openSession(true);

		session.update("boardUpdate", vo);

		session.close();
	}

	public BoardLikeVO boardLikeUpdate(BoardLikeVO vo) {

		SqlSession session = factory.openSession(true);

		BoardLikeVO boardLikeUpdate = session.selectOne("boardLikeUpdate", vo);

		session.close();

		return boardLikeUpdate;

	}

	public int boardLikeInsert(BoardLikeVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.insert("boardLikeInsert", vo);

		session.close();

		return row;
	}

	public int boardLikePlus(BoardLikeVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.update("boardLikePlus", vo);

		session.close();

		return row;
	}

	public BoardLikeVO boardLikeSelect(BoardLikeVO vo) {

		SqlSession session = factory.openSession(true);

		BoardLikeVO result = session.selectOne("boardLikeSelect", vo);

		session.close();

		return result;

	}

	/////////////////////// myPage///////////////////////////////////
	public List<myPageVO> myPageApply(myPageVO vo) {

		SqlSession session = factory.openSession(true);

		List<myPageVO> result = session.selectList("myPageApply", vo);

		session.close();

		return result;

	}

	public List<myPageVO> myPageRefund(myPageVO vo) {

		SqlSession session = factory.openSession(true);

		List<myPageVO> result = session.selectList("myPageRefund", vo);

		session.close();

		return result;

	}

	public List<myPageVO> myPageEnd(myPageVO vo) {

		SqlSession session = factory.openSession(true);

		List<myPageVO> result = session.selectList("myPageEnd", vo);

		session.close();

		return result;

	}

	public void commentRegister(CommentVO vo) {

		SqlSession session = factory.openSession(true);

		session.insert("commentRegister", vo);

		session.close();

	}

	public List<CommentVO> commentList(CommentVO vo) {

		SqlSession session = factory.openSession(true);

		List<CommentVO> resultVo = session.selectList("commentList", vo);

		session.close();

		return resultVo;
	}

	public void commentDelete(CommentVO vo) {

		SqlSession session = factory.openSession(true);

		session.delete("commentDelete", vo);

		session.close();

	}

	public UserVO userInfo(UserVO vo) {
		SqlSession session = factory.openSession(true);

		UserVO resultVo = session.selectOne("userInfo", vo);

		session.close();

		return resultVo;

	}

	public void boardView(BoardVO vo) {

		SqlSession session = factory.openSession(true);

		session.update("boardView", vo);

		session.close();

	}

	// 24.03.28 bookingCancle 추가 - 인영
	public int bookingCancle(myPageVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.update("bookingCancle", vo);

		session.close();

		return row;

	}

	// 24.03.29 bookingSeat 추가 - 준범
	public List<SeatVO> bookingSeat(SeatVO vo) {

		SqlSession session = factory.openSession(true);

		List<SeatVO> resultVo = session.selectList("bookingSeat", vo);

		session.close();

		return resultVo;
	}

	// 24.03.29 bookingUpdate-seatUpdate 추가 - 인영
	public int seatUpdate(SeatVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.update("seatUpdate", vo);

		session.close();

		return row;
	}

	// bookingUpdate-bookInsert 추가 - 인영
	public int bookInsert(myPageVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.insert("bookInsert", vo);

		session.clearCache();

		return row;
	}
	
	public pageVO boardNum(pageVO vo) {

		SqlSession session = factory.openSession(true);

		pageVO resultVo = session.selectOne("boardNum", vo);

		session.close();

		return resultVo;
	}
	
	public List<BoardVO> boardList2(pageVO vo) {

		SqlSession session = factory.openSession(true);

		List<BoardVO> resultVo = session.selectList("boardList", vo);

		session.close();

		return resultVo;
	}

}
