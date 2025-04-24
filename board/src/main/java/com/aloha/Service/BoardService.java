package com.aloha.Service;

import java.util.List;

import com.aloha.DTO.Board;

/**
 *  게시판 프로그램 - 기능 메소드
 *  - 게시글 목록
 *  - 게시글 조회
 *  - 게시글 등록
 *  - 게시글 수정
 *  - 게시글 삭제
 */

public interface BoardService {

	/**
	 * 게시글 목록
	 * @return 조회된 글 목록
	 */
	List<Board> list();

	/**
	 * 게시글 조회
	 * @param boardNo 게시글 번호
	 * @return 조회된 글
	 */
	Board select(int boardNo);

	/**
	 * 게시글 추가
	 * @param board 게시글
	 * @return 추가된 글 수
	 */
	int insert(Board board);

	/**
	 * 게시글 수정
	 * @param board 게시글
	 * @return 수정된 글 수
	 */
	int update(Board board);

	/**
	 * 게시글 삭제
	 * @param boardNo 게시글 번호
	 * @return 삭제된 글 수
	 */
	int delete(int boardNo);

}






