package cn.edu.bupt.todolist_4.controller;

import cn.edu.bupt.todolist_4.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @GetMapping({"/login", "/"})
    public String login(User user, Model model, HttpServletRequest request){
        Object flag = request.getSession().getAttribute("login");
        if (null == flag){
            flag = model.getAttribute("user");
            if (null == flag){
                model.addAttribute("user", user);
            }
            return "login";
        } else {
            return "redirect:/todo/list";
        }
    }

    @PostMapping("/checklogin")
    public String checkLogin(User user, HttpServletRequest request){
        if (user.getUsername().equals("test0101") && user.getPassword().equals("Dec1213")){
            request.getSession().setAttribute("login",1);
            return "redirect:/todo/list";
        }
        else{
            return "redirect:/login";
        }
    }

    @GetMapping("/checklogin")
    public String directCheckLogin(HttpServletRequest request){
        if (null == request.getSession().getAttribute("login")){
            return "redirect:/login";
        } else{
            return "redirect:/todo/list";
        }
    }

    @GetMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("login");
        return "redirect:/login";
    }
}