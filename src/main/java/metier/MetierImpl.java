package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue{
    
    public List<Universite> getUniversitesParMotCle(String mc) {
        List<Universite> universites = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM UNIVERSITES WHERE NOM_UNI LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Universite u = new Universite(
                    rs.getString("NOM_UNI"),
                    rs.getString("ADRESSE_UNI"),
                    rs.getString("EMAIL"),
                    rs.getDouble("NB_ETUDIANTS")
                );
                u.setIdUni(rs.getLong("ID_UNI"));
                universites.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return universites;
    }

    public void addUniversite(Universite u) {
        Connection conn = SingletonConnection.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO UNIVERSITES (NOM_UNI, ADRESSE_UNI, EMAIL, NB_ETUDIANTS) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, u.getNomUni());
            ps.setString(2, u.getAdresseUni());
            ps.setString(3, u.getEmail());
            ps.setDouble(4, u.getNbEtudiants());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
