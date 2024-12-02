package com.app.mybatis.controller;

import com.app.mybatis.domain.ReplyDTO;
import com.app.mybatis.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reply/*")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyMapper replyMapper;

    @GetMapping("write")
    public void replyWrite(ReplyDTO replyDTO) {
        replyMapper.insert(replyDTO.toVO());
    }
}
