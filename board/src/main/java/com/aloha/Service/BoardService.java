package com.aloha.Service;

import java.util.List;

import com.aloha.DTO.Board;

public interface BoardService {
    
    // 게시글 등록
    public int insert(Board board);
    // 게시글 목록
    public List<Board> list();
}
