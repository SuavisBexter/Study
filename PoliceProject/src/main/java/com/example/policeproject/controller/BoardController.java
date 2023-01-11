package com.example.policeproject.controller;

import com.example.policeproject.Entity.BoardEntity;
import com.example.policeproject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/board/list")
    public String boardList(Model model){

    model.addAttribute("list",boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/create")
    public String boardCreate(){

        return "boardcreate";
    }

    @PostMapping("/board/write")
    public String boardWrite(BoardEntity boardEntity, Model model){

        boardService.boardWrite(boardEntity);

        model.addAttribute("writemessage","글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl","/board/list");
        return "message";
    }

    @GetMapping("/board/detail")
    public String boardDetail(Model model,int id){

        model.addAttribute("detail",boardService.boardDetail(id));

        return "boarddetail";
    }

    @GetMapping("/board/update")
    public String boardUpdate(Model model,int id){

        model.addAttribute("update",boardService.boardDetail(id));

        return "boardupdate";
    }

    @PostMapping("/board/updatesuccess/{id}")
    public String boardUpdateSuccess(@PathVariable("id") int id,BoardEntity board,Model model){

        BoardEntity boardTemp = boardService.boardDetail(id);

        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.boardWrite(boardTemp);

        model.addAttribute("updatemessage","글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl","/board/list");
        return "message";
    }

    @GetMapping("/board/delete")
    public String boardDelete(int id,Model model){

        boardService.boardDelete(id);
        model.addAttribute("deletemessage","글 삭제가 완료되었습니다.");
        model.addAttribute("searchUrl","/board/list");
        return "message";
    }
}
