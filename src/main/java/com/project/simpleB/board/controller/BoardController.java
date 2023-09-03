package com.project.simpleB.board.controller;

import com.project.simpleB.board.dto.BoardDTO;
import com.project.simpleB.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/write")
    public ResponseEntity<Void> write(BoardDTO boardDTO) {
        int check = boardService.write(boardDTO);

        if (check >= 1) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDTO>> list() {
        List<BoardDTO> list = boardService.list();

        if (list == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{bId}")
    public ResponseEntity<BoardDTO> detail(@PathVariable long bId) {
        BoardDTO boardDTO = boardService.detail(bId);

        if (boardDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(boardDTO, HttpStatus.OK);
    }
}
