package com.project.simpleB.board.controller;

import com.project.simpleB.board.dto.BoardDTO;
import com.project.simpleB.board.service.BoardService;
import com.project.simpleB.paging.Paging;
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
        boardService.write(boardDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Paging> list(@RequestParam(value="pageIndex", required = false, defaultValue = "0") int pageIndex) {
        Paging list = boardService.list(pageIndex);

        if (list == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{bId}")
    public ResponseEntity<BoardDTO> detail(@PathVariable Long bId) {
        BoardDTO boardDTO = boardService.detail(bId);

        if (boardDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(boardDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bId}")
    public ResponseEntity<Void> delete(@PathVariable Long bId) {
        boardService.delete(bId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(BoardDTO boardDTO) {
        boardService.update(boardDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
