package dao;

import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    public boolean validarLogin(String login, String senha) {
        Connection conn = Conexao.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT id, nome, login, senha, email FROM usuario WHERE login = ? AND senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        Connection conn = Conexao.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuario(nome, login, senha, email) VALUES (?, ?, ?, ?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getEmail());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

