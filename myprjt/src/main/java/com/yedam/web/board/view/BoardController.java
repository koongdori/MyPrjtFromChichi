package com.yedam.web.board.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yedam.web.board.BoardService;
import com.yedam.web.board.BoardVO;

@Controller
@SessionAttributes("board") // model에 board라는 속성이 추가된다면 자동으로 session에도 추가하라는 말임
public class BoardController {
	
	@Autowired
	BoardService boardService;
	@ModelAttribute("conditionMap")
	//385p 얘가 먼저 실행된다.
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	@RequestMapping("/getBoardList")
	public String getBoardList(HttpServletRequest request, BoardVO vo) {
		request.setAttribute("boardList", boardService.getBoardList());
		return "board/getBoardList";
	}
	
	//수정폼 
	@RequestMapping(value="/updateBoard", method=RequestMethod.GET)
	public String updateBoardForm() {
		//옛날처럼 단건조회해서 수정페이지로 넘어 가는 게 아니라
		return "board/updateBoard";
	}	
	
	//수정 업데이트 처리 SessionAttribute 388p
	@RequestMapping(value="/updateBoard", method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board")BoardVO vo) {
		System.out.println(vo);
		//서비스를 불러서 수정처리 해줘야 함
	//	boardService.updateBoard(vo);
		return "board/getBoard";
	}	
	
	//등록폼
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoardForm() {
		return "board/insertBoard";
	}	
	//등록처리
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) {
		//command객체는 자동으로 vo에 저장이 되므로
		//model.addAttribute("boardVo",vo) 안해도 된다.
		//command 객체를 저장할 때 저장될 객체의 속성명을 바꾸고 싶을 때는 @ModelAttribute("vo") BoardVO vo)를 쓴다. 377p and 385p
		
		//서비스 이용하여 등록처리하고 목록페이지로 이동
		System.out.println(vo);
		boardService.insertBoard(vo);
		//return "redirect:/getBoardList";
		return "board/getBoard";
	}
	/* Request Param 설정
	@RequestMapping("/getBoard")
	//value="s"(parameter값과 value의 필드명이 일치하지 않을 때 이렇게 설정하면 400번 오류 방지 가능,
	//required=false, 필수로 param 값을 넘겨받는 것은 아니다. param 값이 없는 경우에는 아래와 같이
	//defaultValue="1" 디폴트 param을 설정함으로써 param이 없으면 기본적으로 1로 넘겨 받는다. 383p
	public String getBoard(@RequestParam(value="s",required=false, defaultValue="1") String seqs, Model model) {
		System.out.println("seq:"+seqs);
		model.addAttribute("board",boardService.getBoard(seqs));
		return "board/getBoard";
	}*/
	
/*	@RequestMapping("/getBoard/{seqs}/{title}")
	// PathVariable 여러 개 선언도 가능하다.
	public String getBoard(@PathVariable String seqs,@PathVariable String title , Model model) {
		System.out.println("seq:"+seqs);
		model.addAttribute("board",boardService.getBoard(seqs));
		return "board/getBoard";*/
	
	@RequestMapping("/getBoard/{seqs}")
	public String getBoard(@PathVariable String seqs, Model model) {
		System.out.println("seq:"+seqs);
		model.addAttribute("board",boardService.getBoard(seqs)); //"board"는 model에도 저장되지만 제일 위의 session에도 저장된다.
		return "board/getBoard";
	}
}
