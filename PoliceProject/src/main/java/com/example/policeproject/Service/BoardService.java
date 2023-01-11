package com.example.policeproject.Service;

import com.example.policeproject.Entity.BoardEntity;
import com.example.policeproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardService {

    @Autowired 
    private BoardRepository boardRepository;
    
    //리스트에 글을 뿌리기
    public List<BoardEntity> boardList(){

        return boardRepository.findAll();

    }

    //글 저장
    public void boardWrite(BoardEntity boardEntity){

        boardRepository.save(boardEntity);
    }

    //자세한 페이지
    public BoardEntity boardDetail(int id){
        return boardRepository.getById(id);
    }

    public void boardDelete(int id){
        boardRepository.deleteById(id);
    }
}
