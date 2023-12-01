package br.com.bruno.layout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bruno.layout.model.Login;
import br.com.bruno.layout.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TaskController taskController;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("newUser")
    public String salvarLogin(Login login, Model model) {
        loginService.salvar(login);
        return "login";
    }

    @PostMapping("login")
    public String login(Login login, Model model) {
        if (loginService.verificaSenha(login)) {
            return "redirect:/create";
        } else {
            model.addAttribute("loginError", "Senha ou usuário inválidos, tente novamente.");
        return "login";
        }
    }
}
