package com.project.simpleB.reply.controller;

import com.project.simpleB.reply.dto.ReplyDTO;
import com.project.simpleB.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/list/{bId}")
    public ResponseEntity<List<ReplyDTO>> list(@PathVariable long bId) {
        List<ReplyDTO> list = replyService.list(bId);

        if (list == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/write")
    public ResponseEntity<Void> write(@RequestBody ReplyDTO replyDTO) {
        int result = replyService.write(replyDTO);

        if (result >= 1) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
