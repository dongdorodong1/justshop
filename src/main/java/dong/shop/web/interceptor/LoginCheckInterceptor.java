package dong.shop.web.interceptor;

import dong.shop.domain.member.Member;
import dong.shop.web.session.SessionConstant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        log.info("인증 체크 인터셉터 실행 {}",requestURI);

        HttpSession session = request.getSession();

        if(null == session || null == session.getAttribute(SessionConstant.LOGIN_MEMBER.getValue())) {
            log.info("미인증 사용자 요청");
            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false;
        }

        Member member = (Member) session.getAttribute(SessionConstant.LOGIN_MEMBER.getValue());
        request.setAttribute("loginMemberId",member.getId());
        log.info("USER_ID[{}][{}]",member.getId(),requestURI);

        return true;
    }
}
