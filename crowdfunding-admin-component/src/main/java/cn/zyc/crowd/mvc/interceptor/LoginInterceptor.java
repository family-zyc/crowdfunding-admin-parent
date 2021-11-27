package cn.zyc.crowd.mvc.interceptor;

import cn.zyc.crowd.constant.CrowdConstant;
import cn.zyc.crowd.entity.Admin;
import cn.zyc.crowd.exception.AccessForbiddenException;
import cn.zyc.crowd.exception.LoginFailedException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录访问权限拦截器
 * @author zyc
 * @date 2021/11/26
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);
        if(admin == null){
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
        }

        return true;
    }
}
