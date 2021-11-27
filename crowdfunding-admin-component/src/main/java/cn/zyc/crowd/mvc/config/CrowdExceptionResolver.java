package cn.zyc.crowd.mvc.config;

import cn.zyc.crowd.constant.CrowdConstant;
import cn.zyc.crowd.exception.AccessForbiddenException;
import cn.zyc.crowd.exception.LoginFailedException;
import cn.zyc.crowd.util.CrowdUtil;
import cn.zyc.crowd.util.ResultEntity;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zyc
 * @date 2021/11/26
 *
 * 异常处理类
 *
 */
@ControllerAdvice
public class CrowdExceptionResolver {

    @ExceptionHandler(value = {NullPointerException.class})
    public ModelAndView resolverNullPointException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return commonResolve("system-error",e,request,response);
    }

    @ExceptionHandler(value = {LoginFailedException.class})
    public ModelAndView resolverLoginFailedException(LoginFailedException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return commonResolve("admin-login",e,request,response);
    }

    @ExceptionHandler(value = {AccessForbiddenException.class})
    public ModelAndView resolverAccessForbiddenException(AccessForbiddenException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return commonResolve("admin-login",e,request,response);
    }

    private ModelAndView commonResolve(String viewName,Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //judge request type is ajax?
        boolean judgeResult = CrowdUtil.judgeRequestType(request);
        if(judgeResult){
            //return a ResultEntity Object
            ResultEntity<Object> resultEntity = ResultEntity.failed(e.getMessage());
            //object convert a json
            String data = new Gson().toJson(resultEntity);
            response.getWriter().write(data);
            return null;
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION,e);
            modelAndView.setViewName(viewName);
            return modelAndView;
        }
    }

}
