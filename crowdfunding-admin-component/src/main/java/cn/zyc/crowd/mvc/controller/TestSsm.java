package cn.zyc.crowd.mvc.controller;

import cn.zyc.crowd.entity.Admin;
import cn.zyc.crowd.exception.LoginFailedException;
import cn.zyc.crowd.service.api.AdminService;
import cn.zyc.crowd.util.CrowdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zyc
 * @date 2021/11/25
 */
@Controller
public class TestSsm {

    @Autowired
    private AdminService adminService;

    Logger logger = LoggerFactory.getLogger(TestSsm.class);

    @GetMapping("/test/ssm")
    public String ssm(Model model, HttpServletRequest request){

        List<Admin> adminList = adminService.getAll();
        model.addAttribute("adminList",adminList);
        return "target";
    }

    @PostMapping("/send/array")
    public String array(Admin admin, HttpServletRequest request){
        System.out.println(admin);
        return "target";
    }

    @GetMapping("/error")
    public String error(){
        int a = 1/0;
        return "target";
    }


}
