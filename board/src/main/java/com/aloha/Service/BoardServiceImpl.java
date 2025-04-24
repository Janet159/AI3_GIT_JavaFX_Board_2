package com.aloha.Service;

import java.util.List;

import com.aloha.DAO.BoardDAO;
import com.aloha.DTO.Board;

public class BoardServiceImpl implements BoardService {

    BoardDAO boardDAO = new BoardDAO();

    @Override
    public int insert(Board board) {
        return boardDAO.insert(board);
    }

    	@Override
	public List<Board> list() {
		// DAO 객체로 게시글 목록 요청하고 List<Board>
		List<Board> boardList = boardDAO.list(); 
		// 게시글 목록 데이터 반환
		return boardList;
	}
    
}
