package com.smhrd.database;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.model.BoardVO;
import com.smhrd.model.EventVO;
import com.smhrd.model.BoardLikeVO;
import com.smhrd.model.ShuttleVO;
import com.smhrd.model.UserVO;

public class DAO {

	// 1. 필드
	// DBCP 꺼내오기
	private SqlSessionFactory factory = MySqlSessionManager.getSqlSessionFactory();

	public int Join(UserVO vo) {

		SqlSession session = factory.openSession(true);

		int row = session.insert("Join", vo);

		session.close();

		return row;
	}

	public List<EventVO> eventList() {

		// 1. 연결객체 생성하기
		SqlSession session = factory.openSession(true);

		// 2. 연결객체 사용하기
		List<EventVO> resultVo = session.selectList("eventList");

		// 3. 연결객체 반납하기
		session.close();

		// 4. 결과값 반환하기
		return resultVo;
	}

	public UserVO Login(UserVO vo) {
		SqlSession session = factory.openSession(true);

		// select기능을 구행하고 난 결과 자료형은 제네릭 기법으로 결정된다
		// 제네릭 기법이란?
		// : 클래스 내부에서(SqlSession) 사용해야하는 자료형을 클래스 외부에서 결정하는 기법
		UserVO resultVo = session.selectOne("Login", vo);

		session.close();

		return resultVo;

	}

	public List<ShuttleVO> Shuttle() {

		// 1. 연결객체 생성하기
		SqlSession session = factory.openSession(true);

		// 2. 연결객체 사용하기
		List<ShuttleVO> resultVo = session.selectList("Shuttle");

		// 3. 연결객체 반납하기
		session.close();

		// 4. 결과값 반환하기
		return resultVo;
	}

	public void userUpdate(UserVO vo) {
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		// 2. 세션 사용하기
		session.update("userUpdate", vo);
		// 3. 세션 반납하기
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
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		// 2. 세션 사용하기
		int row = session.update("pwUpdate", vo);
		// 3. 세션 반납하기
		session.close();

		return row;
	}

	public int boardLike(BoardLikeVO vo) {
		SqlSession session = factory.openSession(true);

		int row = session.selectOne("boardLike", vo);

		session.close();

		return row;

	}

	public int boardLikeInsert(BoardLikeVO vo) {
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		// 2. 세션 사용하기
		int row = session.update("boardLikeInsert", vo);
		// 3. 세션 반납하기
		session.close();

		return row;
	}

	public int boardLikePlus(BoardLikeVO vo) {
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		// 2. 세션 사용하기
		int row = session.update("likePlus", vo);
		// 3. 세션 반납하기
		session.close();

		return row;
	}

	public List<BoardVO> boardDetail(BoardVO vo) {

		// 1. 연결객체 생성하기
		SqlSession session = factory.openSession(true);

		// 2. 연결객체 사용하기
		List<BoardVO> resultVo = session.selectList("boardDetail", vo);

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

	public List<BoardVO> boardList(BoardVO vo) {

		// 1. 연결객체 생성하기
		SqlSession session = factory.openSession(true);

		// 2. 연결객체 사용하기
		List<BoardVO> resultVo = session.selectList("boardList", vo);

		// 3. 연결객체 반납하기
		session.close();

		// 4. 결과값 반환하기
		return resultVo;
	}

	public UserVO AFindInfo(UserVO vo) {
		SqlSession session = factory.openSession(true);

		UserVO resultId = session.selectOne("AFindInfo", vo);

		session.close();

		return resultId;

	}

}
