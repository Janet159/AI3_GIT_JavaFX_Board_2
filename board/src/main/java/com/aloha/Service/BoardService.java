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

    
    // 게시글 등록
    public int insert(Board board);
    // 게시글 목록
    public List<Board> list();
    // 게시글 조회
    public Board select(int no);
    // 게시글 수정
    public int update(Board board);
    // 게시글 삭제
    public int delete(int no);

}






