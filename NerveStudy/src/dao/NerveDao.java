package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Nerve;

public class NerveDao {
	
	
	
	private Connection connection;
	private final String GET_NERVES_BY_STUDY_ID_QUERY = "SELECT * FROM nerve WHERE study_id = ?";
	private final String DELETE_NERVES_BY_STUDY_ID_QUERY = "DELETE FROM nerve WHERE study_id = ?";
	private final String CREATE_NEW_NERVE_QUERY = "INSERT INTO nerve(muscle, type, study_id) VALUES(?,?,?)";
	private final String DELETE_NEW_NERVE_BY_ID_QUERY = "DELETE FROM nerve WHERE id = ? ";
	
	public NerveDao() {
		connection = DBConnection.getConnection();
	}

	public List<Nerve> getNervesByStudyId(int studyId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_NERVES_BY_STUDY_ID_QUERY);
		ps.setInt(1, studyId);
		ResultSet rs = ps.executeQuery();
		List<Nerve> nerves = new ArrayList<Nerve>();
		
		while (rs.next()) {
			nerves.add(new Nerve(rs.getString(1), rs.getString(2), rs.getInt(3)));
		}
		
		return nerves;
	}
    
	public void createNewNerve(String muscle, String type, int studyId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_NERVE_QUERY);
		ps.setString(1, muscle);
		ps.setString(2, type);
		ps.setInt(3, studyId);
		ps.executeUpdate();
	}
	
	
	public void deleteNervesByStudyId(int studyId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_NERVES_BY_STUDY_ID_QUERY);
		ps.setInt(1, studyId);
		ps.executeUpdate();
		
	}
	
	public void deleteNerveById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_NEW_NERVE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}
