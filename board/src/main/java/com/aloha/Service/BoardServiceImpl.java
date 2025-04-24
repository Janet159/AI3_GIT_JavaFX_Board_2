package com.aloha.Service;

import java.util.List;

import com.aloha.DAO.BoardDAO;
import com.aloha.DTO.Board;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO = new BoardDAO();

	/**
	 * 게시글 목록
	 * @return 조회된 글 목록
	 */
	@Override
	public List<Board> list() {
		List<Board> boardList = (List<Board>) boardDAO.selectList();
		return boardList;
	}

	/**
	 * 게시글 조회
	 * @param boardNo 게시글 번호
	 * @return 조회된 글
	 */
	@Override
	public Board select(int boardNo) {
		Board board = (Board) boardDAO.select(boardNo);
		return board;
	}

	/**
	 * 게시글 추가
	 * @param board 게시글
	 * @return 추가된 글 수
	 */
	@Override
	public int insert(Board board) {
		int result = boardDAO.insert(board);
		return result;
	}

	/**
	 * 게시글 수정
	 * @param board 게시글
	 * @return 수정된 글 수
	 */
	@Override
	public int update(Board board) {
		int result = boardDAO.update(board);
		return result;
	}

	/**
	 * 게시글 삭제
	 * @param boardNo 게시글 번호
	 * @return 삭제된 글 수
	 */
	@Override
	public int delete(int boardNo) {
		int result = boardDAO.delete(boardNo);
		return result;
	}
}
