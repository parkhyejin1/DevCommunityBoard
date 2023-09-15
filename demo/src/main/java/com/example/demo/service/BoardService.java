package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Board;

public interface BoardService {

	public void register(Board board) throws Exception;
	public List<Board> list() throws Exception;
	
	public Board read(Long boardNo) throws Exception;
	public void update(Board board) throws Exception;
	public void remove(Long boardNo) throws Exception;
	
}
