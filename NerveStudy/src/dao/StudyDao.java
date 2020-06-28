package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Study;

public class StudyDao {
	
	private Connection connection;
	
	private final String GET_STUDIES_QUERY = "SELECT * FROM study";
	private final String GET_STUDY_BY_ID_QUERY = "SELECT * FROM study WHERE id = ?";
	private final String CREATE_NEW_STUDY_QUERY = "INSERT INTO study(name) VALUES(?) ";
	private final String DELETE_STUDY_BY_ID_QUERY = "DELETE FROM study WHERE id = ?";
	private NerveDao nerveDao;
	

	public StudyDao() {
		connection = DBConnection.getConnection();
		nerveDao = new NerveDao();
	}
	
	public List<Study> getStudies() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_STUDIES_QUERY).executeQuery();
		List<Study> studies = new ArrayList<Study>();
		while (rs.next()) {
			studies.add(populateStudy(rs.getInt(1), rs.getString(2)));
		}
		return studies;
	}
	
	public Study getStudyById(int id) throws SQLException {
		PreparedStatement  ps = connection.prepareStatement(GET_STUDY_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateStudy(rs.getInt(1), rs.getString(2));
	}
	
	public void createNewStudy(String studyName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_STUDY_QUERY);
		ps.setString(1, studyName);
		ps.executeUpdate();
		
	}
	
	public void DeleteStudyById(int id) throws SQLException {
		nerveDao.deleteNervesByStudyId(id);
		PreparedStatement ps = connection.prepareStatement(DELETE_STUDY_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Study populateStudy(int id, String name) throws SQLException {
		return new Study(id, name, nerveDao.getNervesByStudyId(id));
	}
	
	
  }
