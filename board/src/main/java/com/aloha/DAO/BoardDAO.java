package com.aloha.DAO;

import java.sql.SQLException;
import java.util.List;

import com.aloha.DTO.Board;

public class BoardDAO extends JDBConnection {

	// 게시글 등록
	public int insert(Board board) {
		int result = 0;

		String sql = " INSERT INTO board ( title, writer, content ) "
				+ " VALUES( ?, ?, ?) ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getWriter());
			psmt.setString(3, board.getContent());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("게시글 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public Board select(int boardNo) {
		Board board = new Board();
		String sql = " SELECT * FROM board WHERE no = " + boardNo;

		try {
			stmt = con.createStatement(); // 쿼리 실행 객체 생성
			rs = stmt.executeQuery(sql); // 쿼리 실행 - 결과 --> rs (ResultSet)

			// 조회 결과 가져오기
			if (rs.next()) {
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setCreatedAt(rs.getTimestamp("reg_date"));
				board.setUpdatedAt(rs.getTimestamp("upd_date"));
			}

		} catch (SQLException e) {
			System.err.println("게시글 조회 시, 에러 발생");
			// e.printStackTrace();
			board = null;
		}
		return board;
	}

	public int update(Board board) {
		int result = 0;
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE board ");
		sql.append(" SET title = ? , content = ? , writer = ? , upd_date = now() ");
		sql.append(" WHERE no = ? ");
		// - now() : 현재 날짜/시간을 반환하는 MySQL 함수

		try {
			psmt = con.prepareStatement(sql.toString());
			psmt.setString(1, board.getTitle()); // 1번 ? 에 제목을 매핑
			psmt.setString(2, board.getContent()); // 2번 ? 에 내용을 매핑
			psmt.setString(3, board.getWriter()); // 3번 ? 에 작성자를 매핑
			psmt.setInt(4, board.getNo()); // 4번 ? 에 게시글 번호를 매핑

			result = psmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("게시글 수정 시, 에러 발생");
			// e.printStackTrace();
			result = -1;
		}
		return result;
	}

	public int delete(int boardNo) {
		int result = 0;

		String sql = " DELETE FROM board WHERE no = " + boardNo;

		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("게시글 삭제 시, 에러 발생");
			// e.printStackTrace();
			result = -1;
		}
		return result;
	}

	public List<Board> selectList() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'selectList'");
	}

}
