package com.app.mybatis.mapper;

import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.ReplyDTO;
import com.app.mybatis.domain.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private PostDTO postDTO;

    //   댓글작성
    @Test
    public void testInsert() {
        ReplyVO replyVO = new ReplyVO(null,2L,2L,"테스트 댓글2",null,0,null,null);

        replyMapper.insert(replyVO);
    }

//    대댓글작성
//    그룹 ID (댓글은 NULL, 대댓글은 해당 댓글의 ID) / 댓글은 0, 대댓글은 1 이상
    @Test
    public void testInsertReply(){
        ReplyVO replyVO=new ReplyVO(null,1L,1L,"테스트 댓글1의 대댓글 2,",1L,1,null,null);
        replyMapper.insertReply(replyVO);
    }

//    댓글목록조회
    @Test
    public void testSelectAllReply(){
        replyMapper.selectReplyAll().stream().map(ReplyDTO::toString).forEach(log::info);
    }
//    대댓글목록조회
    @Test
    public void testSelectALlInsertReply(){
        replyMapper.selectInsertReplyAll().stream().map(ReplyDTO::toString).forEach(log::info);
    }

//    댓글 수정
    @Test
    public void testUpdateReply(){
//      selectReplyAll().get(0) 는 전체댓글 가져오는것중 리스트의 첫번째 요소를 말한다 즉 0은 첫번째 댓글
        ReplyDTO replyDTO= replyMapper.selectReplyAll().get(0);
        replyDTO.setReplyContent("댓글수정");
        replyMapper.updateReply(replyDTO.toVO());
    }

//    댓글 삭제
    @Test
    public void testDeleteReply(){
        replyMapper.deleteReply(2L);
    }
}
