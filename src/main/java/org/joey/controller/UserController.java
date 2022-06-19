package org.joey.controller;

import org.joey.dao.EmployeeDao;
import org.joey.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: JoeyShelby
 * @date: 2022-06-16 08:32
 */
@Controller
public class UserController {
    EmployeeDao employeeDao;
    @Autowired
    public UserController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    private static final String PASSWORD = "123456";

    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, Model model, HttpSession session) {
        //根据 username 和 password 验证登录，登录通过，放行并添加 session，否则返回登录页面，并携带回显信息
        if(!StringUtils.isEmpty(username) && PASSWORD.equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/main";
        } else {
            model.addAttribute("msg", "用户名或密码错误，请重新登录");
            return "login";
        }
    }

    @RequestMapping("/main")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeDao.listAllEmployees();
        model.addAttribute("employees",employees);

        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:login";
    }

}
