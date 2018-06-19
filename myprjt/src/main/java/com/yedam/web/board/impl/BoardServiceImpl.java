package com.yedam.web.board.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.web.board.BoardService;
import com.yedam.web.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDAO dao;
	
	@Override
	public List<Map<String, Object>> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public List<BoardVO> getBoardList2(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getBoard(String seqs) {
		// TODO Auto-generated method stub
		return dao.getBoard(seqs);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(String seqs) {
		// TODO Auto-generated method stub
		
	}

}
