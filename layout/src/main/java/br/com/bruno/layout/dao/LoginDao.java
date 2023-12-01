package br.com.bruno.layout.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import br.com.bruno.layout.model.Login;

@Component

public class LoginDao {
    @Autowired
    JdbcTemplate db;

    public void salvar(Login login) {
        String sql = "INSERT INTO tb_login (usuario, senha) VALUES (?, ?)";
        db.update(sql, new Object[] { login.getUsername(), login.getPassword() });
    }

    public Login getLogin(String user) {
        String sql = "SELECT usuario, senha FROM tb_login WHERE usuario = ?";
        List<Login> logins = db.query(
                sql,
                (res, rowNum) -> new Login(
                        res.getString("usuario"),
                        res.getString("senha")),
                user);
    
        return logins.isEmpty() ? null : logins.get(0);
    }
    
}