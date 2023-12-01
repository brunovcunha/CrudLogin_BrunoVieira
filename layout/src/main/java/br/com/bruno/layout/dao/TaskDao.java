package br.com.bruno.layout.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import br.com.bruno.layout.model.Task;

import java.util.List;

@Component
public class TaskDao {
    private final JdbcTemplate jdbcTemplate;

    public TaskDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> getTasks() {
        String sql = "SELECT id, nome, cargo, data_contratacao FROM tb_Funcionario";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Task.class));
    }

    public Task getTaskById(Long id) {
        String sql = "SELECT id, nome, cargo, data_contratacao FROM tb_Funcionario WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Task.class));
    }

    public void createTask(Task task) {
        String sql = "INSERT INTO tb_Funcionario (nome, cargo, data_contratacao) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, task.getNome(), task.getCargo(), task.getData_contratacao());
    }

    public void updateTask(Task task) {
        String sql = "UPDATE tb_Funcionario SET nome = ?, cargo = ?, data_contratacao = ? WHERE id = ?";
        jdbcTemplate.update(sql, task.getNome(), task.getCargo(), task.getData_contratacao(), task.getId());
    }

    public void deleteTask(Long id) {
        String sql = "DELETE FROM tb_Funcionario WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
