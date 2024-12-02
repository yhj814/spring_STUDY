package com.app.threetier.controller.member;

import com.app.threetier.domain.member.MemberDTO;
import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.exception.LoginFailException;
import com.app.threetier.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;
import java.util.Optional;

@Controller
// 최상위 경로를 설정하여 컨트롤러를 구분한다.
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

//    회원가입 페이지로 이동(GET)
    @GetMapping("join")
//    화면에 있는 input태그의 속성을 채울 때,
//    해당 객체의 필드명과 동일하게 맞춰야 한다.
//    이를 위해 비어있는 객체를 화면으로 전달해준다.
    public void goToJoinForm(MemberDTO memberDTO, HttpSession session){;}

//    회원가입 완료(POST)
//    경로가 같아도 REQUEST METHOD가 다르면 구분할 수 있다.
    @PostMapping("join")
//    화면에서 작성된 input태그의 name과 MemberDTO 필드명이 mapping된다.
    public RedirectView join(MemberDTO memberDTO){
//        전달받은 정보를 테이블에 INSERT한다.
        memberService.join(memberDTO.toVO());
//        redirect방식을 사용해서 member/login 컨트롤러로 이동한다.
//        만약 forward방식을 사용해서 login.html로 이동하게 되면,
//        화면은 로그인 페이지가 나오겠지만, 경로는 member/join(POST)이기 때문에
//        새로고침 할 때마다 현재 메소드가 계속 실행되면서 INSERT쿼리 또한 매번 발생한다.
//        이는 심각한 문제이다.
        return new RedirectView( "/member/login");
    }

    @GetMapping("login")
//    @RequestParam(required = false)
//    전달받은 데이터가 null일 경우 required의 default값이 true이기 때문에,
//    NPE가 발생할 수 있다. 이를 필수가 아닌 선택으로(null 허용) 변경하고 싶다면,
//    required 설정을 false로 지정한다.
    public void goToLoginForm(@RequestParam(required = false) Boolean status, MemberDTO memberDTO, HttpServletRequest request, Model model){
//        log.info("{}", status);

//        쿠키 조회
        Cookie[] cookies = request.getCookies();

        for(int i = 0; i < cookies.length; i++){
            log.info(cookies[i].getName());
//            save라는 key가 있다면,
            if(cookies[i].getName().equals("save")){
//                해당 value를 화면으로 보낸다.
                model.addAttribute("save", cookies[i].getValue());

            }
            if(cookies[i].getName().equals("memberEmail")){
                memberDTO.setMemberEmail(cookies[i].getValue());
            }

        }
    }

    @PostMapping("login")
//    HttpSession
//    서버의 Session영역을 관리해주는 객체이다.
//    Spring이 해당 객체를 주입해준다.
    public RedirectView login(MemberDTO memberDTO, String save, HttpSession session, HttpServletResponse response){
//        memberService.login(memberDTO.toVO())
//                .ifPresentOrElse(
//                        (member) -> {
//                            log.info(member.toString());
//                            log.info("로그인 성공");
//                        },
//                        () -> {
//                            log.info("로그인 실패");
//                        });
        
        Optional<MemberVO> foundMember = memberService.login(memberDTO.toVO());
//        null인지 검사할 때
//        if(memberService.login(memberDTO.toVO()).isPresent()){
//
//        }

//        null이 아닐 때에만 실행
//        foundMember.ifPresent((member) -> {
//            session.setAttribute("memberId", member.getId());
//        });

//        null이 아니면 단일 객체 리턴, null이면 예외 발생
        MemberVO memberVO = foundMember.orElseThrow(() -> {throw new LoginFailException("(" + LocalTime.now() + ")로그인 실패");});

//        id만 담아놓으면 사용할 때마다 SELECT 쿼리를 발생시켜야 한다(싫어!)
//        session.setAttribute("memberId", memberVO.getId());
//        전체 정보를 담아놓기 때문에 쿼리를 따로 발생시킬 필요 없다(좋아!)
        session.setAttribute("member", memberVO);

//        화면에서 아이디 저장을 선택했다면 null이 아니다.
        if(save != null){
//            쿠키 생성, 저장
            Cookie saveCookie = new Cookie("save", save);
            Cookie memberEmailCookie = new Cookie("memberEmail", memberDTO.getMemberEmail());

//            -1: 쿠키 계속 유지
            saveCookie.setMaxAge(-1);
            memberEmailCookie.setMaxAge(-1);

            response.addCookie(saveCookie);
            response.addCookie(memberEmailCookie);

        }else{
//            쿠키 삭제
            Cookie saveCookie = new Cookie("save", null);
            Cookie memberEmailCookie = new Cookie("memberEmail", null);

            saveCookie.setMaxAge(0);
            memberEmailCookie.setMaxAge(0);

            response.addCookie(saveCookie);
            response.addCookie(memberEmailCookie);
        }


        return new RedirectView( "/post/list");
    }

//    로그 아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/member/login");
    }

//    회원 정보 조회
//    회원 정보 수정
    @GetMapping(value = {"read", "update"})
    public void goToReadForm(/*Long id, */Model model, HttpSession session){
//        memberService.getMember(id).ifPresent((member) -> {
//            log.info(member.toString());
//        });
//        Long id = (Long)session.getAttribute("memberId");
//        model.addAttribute("member", memberService.getMember(id).get().toDTO());
        MemberVO memberVO = (MemberVO) session.getAttribute("member");
        model.addAttribute("member", memberVO);
    }

//    회원 정보 수정
//    @GetMapping("update")
//    public void goToUpdateForm(Long id){
//
//    }

    @PostMapping("update")
    public RedirectView update(MemberDTO memberDTO){
        log.info(memberDTO.toString());
        memberService.update(memberDTO.toVO());
        return new RedirectView("/member/read?id=" + memberDTO.getId());
    }

//    회원 탈퇴(delete 진행)
    @GetMapping("delete")
    public RedirectView delete(Long id){
//        쿼리 발생
        memberService.delete(id);
        return new RedirectView("/member/login");
    }
}















