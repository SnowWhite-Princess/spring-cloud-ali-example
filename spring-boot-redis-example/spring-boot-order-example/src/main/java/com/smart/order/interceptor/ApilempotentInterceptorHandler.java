package com.smart.order.interceptor;

import com.smart.order.annotation.Apilempotent;
import com.smart.order.service.RedisService;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 检查token  拦截所所有controller
 * 判断的依据是什么? 在方法上面添加标识  自定义注解 有这个注解标识拦截  否则不拦截
 */
@RestControllerAdvice
public class ApilempotentInterceptorHandler implements HandlerInterceptor {
    //拦截  拦截方法 在controller 中的接口
    public static final String HEADER_TOKEN_NAME = "token";
    @Resource
    RedisService redisService;


    /**
     * @param request
     * @param response
     * @param handler
     * @return false  表示不执行核心代码  true 表示执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isSuccess = true;
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            Apilempotent methodAnnotation = method.getMethodAnnotation(Apilempotent.class);
            if (methodAnnotation != null) {
                //判断如果不能null 标识该方法需要进行拦截
                //检查是否是第一次提交
                isSuccess = checkToken(request);
            }
        }
        return isSuccess;
    }


    /**
     * 客服端必须写token信息
     * head 传递数据  key: value  例如 token: 12345
     * <p>
     * body  ?
     *
     * @return
     */
    private boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(HEADER_TOKEN_NAME);
        if (token == null) {
            throw new Exception("token 不存在 ");
        }
        if (redisService.hasKey(token)) {
            //删除token
            redisService.delete(token);
            return true;
        }
        System.out.println("失败");
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
