package com.aloha.Service;

import java.util.List;

import com.aloha.DAO.BoardDAO;
import com.aloha.DTO.Board;

public class BoardServiceImpl implements BoardService {

	/**
	 * 게시판 기능 - 비즈니스 로직 클래스
	 */

	private BoardDAO boardDAO = new BoardDAO();

	/**
	 * 게시글 목록
	 * 
	 * @return 조회된 글 목록
	 */
	@Override
	public List<Board> list() {
		// DAO 객체로 게시글 목록 요청하고 List<Board>
		List<Board> boardList = boardDAO.list();
		// 게시글 목록 데이터 반환
		return boardList;
	}

	/**
	 * 게시글 조회
	 * 
	 * @param boardNo 게시글 번호
	 * @return 조회된 글
	 */
	@Override
	public Board select(int no) {
		// 게시글 번호 no 를 DB 로 넘겨주고 게시글 정보 요청
		boardDAO.view(no);
		Board board = boardDAO.select(no);
		// 게시글 정보 반환
		return board;
	}

	/**
	 * 게시글 추가
	 * 
	 * @param board 게시글
	 * @return 추가된 글 수
	 */
	@Override
	public int insert(Board board) {
		// 게시글 정보를 전달하여 DB 에 데이터 등록 요청
		int result = boardDAO.insert(board);
		// 적용된 데이터 개수를 반환
		// - result(결과) : 0 --> 데이터 등록 실패
		// 1 --> 데이터 등록 성공
		if (result > 0)
			System.out.println("insert data succeeded");
		else
			System.err.println("insert data failed");
		return result;
	}

	/**
	 * 게시글 수정
	 * 
	 * @param board 게시글
	 * @return 수정된 글 수
	 */
	@Override
	public int update(Board board) {
		int result = boardDAO.update(board);
		// 적용된 데이터 개수를 반환
		// - result(결과) : 0 --> 데이터 수정 실패
		// 1 --> 데이터 수정 성공
		if (result > 0)
			System.out.println("update data succeeded");
		else
			System.err.println("udpate data failed");
		return result;
	}

	/**
	 * 게시글 삭제
	 * 
	 * @param boardNo 게시글 번호
	 * @return 삭제된 글 수
	 */
	@Override
	public int delete(int no) {
		int result = boardDAO.delete(no);
		// 적용된 데이터 개수를 반환
		// - result(결과) : 0 --> 데이터 삭제 실패
		// 1 --> 삭제 수정 성공
		if (result > 0)
			System.out.println("delete data succeeded");
		else
			System.err.println("delete data failed");
		return result;
	}
}
