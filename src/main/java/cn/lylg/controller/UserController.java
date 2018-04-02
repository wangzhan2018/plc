package cn.lylg.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.lylg.service.impl.CompanyServiceImpl;
import cn.lylg.util.RandomCode;

@Controller
@RequestMapping("/user")
public class UserController {

    private CompanyServiceImpl companyService;


    public CompanyServiceImpl getCompanyService() {
        return companyService;
    }

    @Resource(name = "companyService")
    public void setCompanyService(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/login")
    public String showUser(HttpServletRequest request) {
        System.out.println(1);
        return "/login";
    }

    @RequestMapping("/loginspass")
    public String login(@RequestParam(required = false) String loginname, @RequestParam(required = false) String loginpass, HttpServletRequest request) {

        HttpSession session = request.getSession();


        List<String> msg = new ArrayList<String>();

        String name = (String) session.getAttribute("name");
        if (name != null) {

            return "/main";
        }

        if (loginname == null || loginname.equals("") || loginpass == null || loginpass.equals("")) {
            msg.add("账号已过期，请从新登录！");
            request.getSession().setAttribute("msg", msg);
            return "/login";
        } else {
            //添加业务逻辑

            int i = companyService.getByNamePass(loginname, loginpass);
            if (i <= 0) {
                msg.add("用户名或是密码不正确！");
                request.getSession().setAttribute("msg", msg);
                return "/login";

            }


            session.setAttribute("name", loginname);
            session.setAttribute("pass", loginpass);
            return "/main";

        }


    }


    @RequestMapping("/code")
    public void showCode(HttpServletRequest request, HttpServletResponse response) throws Exception {


        RandomCode ran = new RandomCode();

        ran.codeSet(request, response);

    }

    @RequestMapping("/codeistrue")
    public void codeistrue(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String verifyCode = request.getParameter("verifyCode").toUpperCase();

        String code = (String) request.getSession().getAttribute("randomCode");

        if (verifyCode.equals(code) || verifyCode == code) {
            response.getOutputStream().print(true);
        } else response.getOutputStream().print(false);

    }

    @RequestMapping("/exit")
    public void exit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.getSession().removeAttribute("name");
        request.getSession().removeAttribute("pass");

        response.getWriter().write("{\"isok\":\"ok\"}");
        response.getWriter().flush();
        response.getWriter().close();


    }


}