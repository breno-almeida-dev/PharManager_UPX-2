package dao;

import model.Usuario;

import java.sql.*;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean cadastrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario (username, senha) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }
    }

    public Usuario loginUsuario(String username, String senha) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE username = ? AND senha = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setUsuario(rs.getString("username"));
                    usuario.setSenha(rs.getString("senha"));
                    return usuario;
                }
            }
        }
        return null;
    }
}
