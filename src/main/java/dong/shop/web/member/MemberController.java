package dong.shop.web.member;

import dong.shop.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/joinMember")
    public String joinMember(MemberUpdateDto mDto, Model model){

        //검증로직 추가

        memberService.save(mDto);
        return "redirect:/items";
    }
}
