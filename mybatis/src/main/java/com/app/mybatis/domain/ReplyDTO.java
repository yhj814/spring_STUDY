package com.app.mybatis.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long id;
    private Long postId;
    private Long memberId;
    private String replyContent;
    private Long groupId;
    private int replyDepth;
    private String createdDate;
    private String updatedDate;

    public ReplyVO toVO(){
        return new ReplyVO(id,postId,memberId,replyContent,groupId,replyDepth,createdDate,updatedDate);
    }
}