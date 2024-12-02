package com.app.mybatis.mapper;

import com.app.mybatis.domain.ReplyDTO;
import com.app.mybatis.domain.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    댓글 작성
    public void insert(ReplyVO replyVO);

//    대댓글 작성
    public void insertReply(ReplyVO replyVO);

//    댓글 목록
    public List<ReplyDTO> selectReplyAll();

//    대댓글 목록
    public List<ReplyDTO> selectInsertReplyAll();

//    댓글 수정
    public void updateReply(ReplyVO replyVO);

//    댓글 삭제
    public void deleteReply(Long id);
}
