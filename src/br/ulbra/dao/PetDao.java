
package br.ulbra.dao;

import br.ulbra.entity.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Klein
 */
public class PetDao {
    Connection con;
 
    public PetDao() throws SQLException {
        con = ConnectionFactory.getConnection();
    }
    public void create(Pet p) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO pet (nomepet, raca, anoNascimento, sexo, corPelo) VALUES (?,?,?,?,?)");

            stmt.setString(1, p.getNomePet());
            stmt.setString(2, p.getRacaPet());
            stmt.setInt   (3, p.getAnoNascimentoPet()); 
            stmt.setString(4, p.getSexoPet());
            stmt.setString(5, p.getCorPeloPet());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }


}
