package com.cnu.library.action;

import com.cnu.library.model.Admin;
import com.cnu.library.model.Borrower;
import com.cnu.library.service.AdminService;
import com.cnu.library.service.BorrowerService;
import com.cnu.library.vo.LoginVo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/servlet/loginAction/")
public class LoginAction {
    private AdminService adminService;
    private BorrowerService borrowerService ;

    @RequestMapping(value = "login")
    public String login( Model model,LoginVo formbean,HttpServletRequest request){
        System.out.println("登录进来"+formbean.getId()+formbean.getPassword());
        //管理员登陆
        Admin admin= null;
        Borrower borrower =null;
        if( formbean.getUserType()==0){
            admin= adminService.login(formbean.getAccount(), formbean.getPassword());

        }else if( formbean.getUserType()==1){//读者登陆
            borrower =borrowerService.login(formbean.getAccount(), formbean.getPassword());
        }else{
            model.addAttribute("message", "请选择登陆类型！");
            model.addAttribute("formbean", formbean);
            return "index";
        }
        if( admin!=null || borrower !=null){

            request.getSession().setAttribute("user", admin==null?borrower:admin);
            request.getSession().setAttribute("userType", formbean.getUserType());
            return "main";
        }else{
            model.addAttribute("message", "用户名或密码错误!");
        }
        model.addAttribute("formbean", formbean);
        return "index";
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("userType");
        return "index";
    }
    public AdminService getAdminService() {
        return adminService;
    }
    @Resource
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
    public BorrowerService getBorrowerService() {
        return borrowerService;
    }
    @Resource
    public void setBorrowerService(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

}
