package com.app.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
    private Long id;
    private Long postId;
    private Long memberId;
    private String replyContent;
    private Long groupId;
    private int replyDepth;
    private String createdDate;
    private String updatedDate;
}