package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/")
	public String home(Board board,Model model) throws Exception{
		model.addAttribute("list",service.list());
		return "board/list";
	}
	
	
	@GetMapping("/register")
	public String registerForm(Board board, Model model) throws Exception{
		return "board/register";
	}
	
	
	@PostMapping("/register")
	public String register(@Validated Board board, BindingResult result,Model model) throws Exception{
		if(result.hasErrors()) {
			return "board/register";
		}
		board.setRegDate(LocalDateTime.now());
		service.register(board);
		return "redirect:/";
	}
	
	@GetMapping("/read")
	public String read(Long boardNo, Model model)throws Exception {
		model.addAttribute(service.read(boardNo));
		return "board/read";
	}
	
	@GetMapping("/update")
	public String update(Long boardNo, Model model)throws Exception {
		model.addAttribute(service.read(boardNo));
		return "board/update";
	}
	
	@PostMapping("/update")
	public String update(@Validated Board board, BindingResult result,Model model) throws Exception{
		if(result.hasErrors()) {
			return "board/update";
		}
		board.setRegDate(LocalDateTime.now());
		service.update(board);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(Long boardNo, Model model)throws Exception {
		model.addAttribute(service.read(boardNo));
		return "board/delete";
	}
	@PostMapping("/delete")
	public String delete_final(Long boardNo, Model model)throws Exception {
		service.remove(boardNo);
		return "redirect:/";
	}
	
	
	
	
}
