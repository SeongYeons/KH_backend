package com.kh.mvc.board.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.common.util.MultipartFileUtil;
import com.kh.mvc.common.util.PageInfo;
import com.kh.mvc.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService service;
	
	private final ResourceLoader resourceLoader;

	@GetMapping("/list")
	public ModelAndView list(
			ModelAndView modelAndView,
			@RequestParam(defaultValue = "1") int page) {
		
		int listCount = 0;
		PageInfo pageInfo = null;
		List<Board> list = null;
				
		listCount = service.getBoardCount();
		pageInfo = new PageInfo(page, 5, listCount, 10);
		list = service.getBoardList(pageInfo);
				
		log.info("Page Number : {}", page);
		log.info("List Count : {}", listCount);
		
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("board/list");		
		
		return modelAndView;
	}
	
	@GetMapping("/view")
	public ModelAndView view(ModelAndView modelAndView,
			@RequestParam int no) {
		Board board = null;
		
		log.info("view() 호출 - {}", no);
		
		board = service.getBoardByNo(no);
				
		modelAndView.addObject("board", board);
		modelAndView.setViewName("board/view");
		
		return modelAndView;
	}
	
	@GetMapping("/write")
	public String write() {
		
		log.info("write() 호출 - 게시글 작성 페이지 요청");
		
		return "board/write";
	}
	
	@PostMapping("/write")
	public ModelAndView write(ModelAndView modelAndView,
			@SessionAttribute("loginMember") Member loginMember,
			Board board,
			@RequestParam("upfile") MultipartFile upfile) {
		int result = 0;
		
		log.info(board.toString());
		
		// 1. 파일을 업로드 했는지 확인 후 파일을 저장
		// 파일을 업로드하지 않으면 true, 파일을 업로드하면 false
		log.info("isEmpty : {}", upfile.isEmpty());
		
		// 파일을 업로드하지 않으면 "", 파일을 업로드하면 "파일명"
		log.info("File Name : {}", upfile.getOriginalFilename());
		
		if (upfile != null && !upfile.isEmpty()) {
			String location = null;
			String renamedFileName = null;
		
			try {
				location = 
					resourceLoader.getResource("resources/upload/board")
							  	  .getFile()
							  	  .getPath();
				renamedFileName =
						MultipartFileUtil.save(upfile, location);
				
				if (renamedFileName != null) {
					board.setOriginalFilename(upfile.getOriginalFilename());
					board.setRenamedFilename(renamedFileName);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 2. 작성한 게시글을 데이터베이스에 저장
		board.setWriterNo(loginMember.getNo());
		
		result = service.save(board);
		
		if (result > 0) {
			modelAndView.addObject("msg", "게시글 등록 성공");
			modelAndView.addObject("location", "/board/view?no=" + board.getNo());
		} else {
			modelAndView.addObject("msg", "게시글 등록 실패");
			modelAndView.addObject("location", "/board/write");	
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	@GetMapping("/fileDown")
	public ResponseEntity<Resource> fileDown(
			@RequestParam String oname,
			@RequestParam String rname,
			@RequestHeader("user-agent") String userAgent) {
		Resource resource = null;
		String downName = null;
				
		log.info("oname : {}, rname : {}", oname, rname);
		
		try {
			// 1. 클라이언트로 전송할 파일을 가져온다.
			resource = resourceLoader
				.getResource("resources/upload/board/" + rname);
			
			// 2. 브라우저별 인코딩 처리
			boolean isMSIE = userAgent.indexOf("MSIE") != -1 || userAgent.indexOf("Trident") != -1;
			
			if(isMSIE) {
				downName = URLEncoder.encode(oname, "UTF-8").replaceAll("\\+", "%20");
			} else {
				downName = new String(oname.getBytes("UTF-8"), "ISO-8859-1");			
			}
			
			// 3. 응답 메시지 작성 & 클라이언트로 출력(전송)하기
			return ResponseEntity.ok()
//						 .header("Content-Type", "application/octet-stream")
						 .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
//						 .header("Content-Disposition", "attachment;filename=" + downName)
						 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + downName)
						 .body(resource);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
//			return ResponseEntity.status(500).build();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/update")
	public ModelAndView update(ModelAndView modelAndView,
			@SessionAttribute Member loginMember,
			@RequestParam int no) {
		Board board = null;
		
		board = service.getBoardByNo(no);
		
		if (board != null && board.getWriterId().equals(loginMember.getId())) {
			modelAndView.addObject("board", board);
			modelAndView.setViewName("board/update");
		} else {
			modelAndView.addObject("msg", "잘못된 접근입니다.");
			modelAndView.addObject("location", "/board/list");
			modelAndView.setViewName("common/msg");
		}
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView update(ModelAndView modelAndView,
			@RequestParam int no,
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam MultipartFile upfile,
			@SessionAttribute Member loginMember) {
		int result = 0;
		Board board = null;
				
		board = service.getBoardByNo(no);
		
		if (board != null && board.getWriterId().equals(loginMember.getId())) {
			if (upfile != null && !upfile.isEmpty()) {
				String location = null;
				String renamedFileName = null;
				
				try {
					location = 
							resourceLoader.getResource("resources/upload/board")
									      .getFile()
									      .getPath();
					
					// 이전에 업로드된 파일을 삭제
					if (board.getRenamedFilename() != null) {
						MultipartFileUtil.delete(location + "/" + board.getRenamedFilename());
					}
					
					renamedFileName = 
							MultipartFileUtil.save(upfile, location);
					
					if (renamedFileName != null) {
						board.setOriginalFilename(upfile.getOriginalFilename());
						board.setRenamedFilename(renamedFileName);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
			
			board.setTitle(title);
			board.setContent(content);
			
			result = service.save(board);
			
			if (result > 0) {
				modelAndView.addObject("msg", "게시글 수정 성공");
				modelAndView.addObject("location", "/board/view?no=" + board.getNo());
			} else {
				modelAndView.addObject("msg", "게시글 수정 실패");
				modelAndView.addObject("location", "/board/update?no=" + board.getNo());
			}
		} else {
			modelAndView.addObject("msg", "잘못된 접근입니다.");
			modelAndView.addObject("location", "/board/list");
		}
		
		modelAndView.setViewName("common/msg");
			
		return modelAndView;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(ModelAndView modelAndView,
			@RequestParam("no") int no,
			@SessionAttribute("loginMember") Member loginMember) {
		int result = 0;
		Board board = null;
		
		log.info("delete() 호출 - {}", no);
		
		board = service.getBoardByNo(no);
		
		if (board != null && board.getWriterId().equals(loginMember.getId())) {
			result = service.delete(no);
			
			if (result > 0) {
				modelAndView.addObject("msg", "게시글 삭제 성공");
				modelAndView.addObject("location", "/board/list");	
			} else {
				modelAndView.addObject("msg", "게시글 삭제 실패");
				modelAndView.addObject("location", "/board/view?no=" + no);
			}
		} else {
			modelAndView.addObject("msg", "잘못된 접근입니다.");
			modelAndView.addObject("location", "/board/list");
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
}
