package cn.zyc.crowd.mvc.controller;

import cn.zyc.crowd.constant.CrowdConstant;
import cn.zyc.crowd.entity.Admin;
import cn.zyc.crowd.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author zyc
 * @date 2021/11/26
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/do/login")
    public String doLogin(Admin admin, HttpSession session){

        Admin resultAdmin = adminService.getAdminByLoginAcct(admin);

        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,resultAdmin);

        return "redirect:/admin/to/main/page";
    }

    @GetMapping("admin/do/logout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/admin/to/login/page";
    }

    @RequestMapping("/admin/to/main/page")
    public String toMainPage(){
        return "admin-main";
    }

    @RequestMapping("/admin/get/page")
    public String doPageInfo(@RequestParam(value = "keyword",defaultValue = "") String keyword,
                             @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                             Model model){
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
        model.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO,pageInfo);

        return "admin-page";
    }

}
