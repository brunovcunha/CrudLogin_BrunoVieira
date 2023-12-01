package br.com.bruno.layout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.bruno.layout.dao.LoginDao;
import br.com.bruno.layout.model.Login;

@Service
public class LoginService {
    
    @Autowired
    private LoginDao loginDao;

    public void save(Login login) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(login.getPassword());
        login.setPassword(encodedPassword);
        loginDao.salvar(login);
    }
    

    public boolean verificaSenha(Login loginDigitado) {
        Login loginExistente = loginDao.getLogin(loginDigitado.getUsername());
    
        if (loginExistente != null) {
            return loginDigitado.getPassword().equals(loginExistente.getPassword());
        }
    
        return false;
    }
    


}
