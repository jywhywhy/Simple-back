package com.project.simpleB.reply.controller;

import com.project.simpleB.paging.Paging;
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
    public ResponseEntity<Paging> list(@PathVariable Long bId, @RequestParam(value="pageIndex", required = false, defaultValue = "0") int pageIndex) {
        Paging list = replyService.list(bId, pageIndex);

        if (list == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/write")
    public ResponseEntity<Void> write(@RequestBody ReplyDTO replyDTO) {
        replyService.write(replyDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{rId}")
    public ResponseEntity<Void> delete(@PathVariable Long rId) {
        replyService.delete(rId);
        return null;
    }
}
