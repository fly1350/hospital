package com.sgxrmyy.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 主页、登陆控制器
 * @author 袁明 on 2017/2/13.
 */
@Controller
@Slf4j
public class HomeController {

    @RequestMapping(value = {"/", "/index"})
    public String index(Map<String, Object> map) {
        map.put("name", "zk");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        log.info("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");

        log.info("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                log.info("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                log.info("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if (ExcessiveAttemptsException.class.getName().equals(exception)) {
                log.info("ExcessiveAttemptsException -- > 登录失败次数过多：");
                msg = "ExcessiveAttemptsException -- > 登录失败次数过多：";
            }else if ("kaptchaValidateFailed".equals(exception)) {
                log.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            }
            else {
                msg = "else >> "+exception;
                log.info("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
    }

    @GetMapping("/error/{status}")
    public String error(@PathVariable("status") String status){
        return status;
    }
}
