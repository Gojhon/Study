package com.solidit.myhome.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.solidit.myhome.model.Board;
import com.solidit.myhome.repository.BoardRepository;
import com.solidit.myhome.validator.BoardValidator;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardValidator boardValidator;
	
	@GetMapping("/list")
    public String list(Model model,@PageableDefault(size=2)Pageable pageable) {
		Page<Board> boards = boardRepository.findAll(pageable);
		//boards.getTotalElements();
		int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
	    int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
		model.addAttribute("boards",boards);
		model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "board/list";
    }
	
	@GetMapping("/form")
	public String form(Model model,@RequestParam(required=false) Long id)
	{
		if(id==null)
		{
			model.addAttribute("board",new Board());
		}else
		{
			Board board =boardRepository.findById(id).orElse(null);
			model.addAttribute("board", board);
		}
		return "board/form";
	}
	
	@PostMapping("/form")
	public String greetingSubmit(@Valid Board board,BindingResult bindingResult)
	{
		boardValidator.validate(board, bindingResult);
		if(bindingResult.hasErrors())
		{
			return "board/form";
		}
		boardRepository.save(board);
		return "redirect:/board/list";
	}
}
