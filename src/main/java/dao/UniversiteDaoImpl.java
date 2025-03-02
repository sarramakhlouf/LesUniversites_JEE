package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.Universite;

public class UniversiteDaoImpl implements IUniversiteDao {
	@Override
	public Universite save(Universite u) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO UNIVERSITES (NOM_UNI, ADRESSE_UNI, EMAIL, NB_ETUDIANTS) VALUES(?, ?, ?, ?)");
			ps.setString(1, u.getNomUni());
			ps.setString(2, u.getAdresseUni());
			ps.setString(3, u.getEmail());
			ps.setDouble(4, u.getNbEtudiants());
			ps.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_UNI) as MAX_ID FROM UNIVERSITES");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				u.setIdUni(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Universite> universitesParMC(String mc) {
		List<Universite> universites = new ArrayList<>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM UNIVERSITES WHERE NOM_UNI LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Universite u = new Universite(mc, mc, mc, 0);
				u.setIdUni(rs.getLong("ID_UNI"));
				u.setNomUni(rs.getString("NOM_UNI"));
				u.setAdresseUni(rs.getString("ADRESSE_UNI"));
				u.setEmail(rs.getString("EMAIL"));
				u.setNbEtudiants(rs.getDouble("NB_ETUDIANTS"));
				universites.add(u);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return universites;
	}

	@Override
	public Universite getUniversite(Long id) {
		Connection conn = SingletonConnection.getConnection();
		Universite u = new Universite(null, null, null, id);
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM UNIVERSITES WHERE ID_UNI = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setIdUni(rs.getLong("ID_UNI"));
				u.setNomUni(rs.getString("NOM_UNI"));
				u.setAdresseUni(rs.getString("ADRESSE_UNI"));
				u.setEmail(rs.getString("EMAIL"));
				u.setNbEtudiants(rs.getDouble("NB_ETUDIANTS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}

	@Override
	public Universite updateUniversite(Universite u) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE UNIVERSITES SET NOM_UNI=?, ADRESSE_UNI=?, EMAIL=?, NB_ETUDIANTS=? WHERE ID_UNI=?");
			ps.setString(1, u.getNomUni());
			ps.setString(2, u.getAdresseUni());
			ps.setString(3, u.getEmail());
			ps.setDouble(4, u.getNbEtudiants());
			ps.setLong(5, u.getIdUni());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void deleteUniversite(Long id) {
		Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM UNIVERSITES WHERE ID_UNI = ?");
		ps.setLong(1, id);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
