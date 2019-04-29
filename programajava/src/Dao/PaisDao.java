package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PaisDao {

    public static boolean inserir(String sigla, String nome) {
        String sql = "INSERT INTO pais (sigla, nome) VALUES (?, ?)";
        try {
            PreparedStatement ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, sigla);
            ps.setString(2, nome);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        boolean resultado = inserir("BR", "Brasil");
        if (resultado){
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
