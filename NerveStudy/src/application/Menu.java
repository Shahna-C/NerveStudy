package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.NerveDao;
import dao.StudyDao;
import entity.Nerve;
import entity.Study;

public class Menu {
	
	private NerveDao nerveDao = new NerveDao();
	private StudyDao studyDao = new StudyDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList
			("Display Studies", 
			 "Display a Study", 
			 "Create a Study", 
			 "Delete a Study",
			 "Create Study Nerve", 
			 "Delete Study Nerve");
 
	public void start() {
		String selection = "";
		do {
			printMenu();
			selection = scanner.nextLine();
			
		try {	
			
			if (selection.equals("1")) {
				displayStudies();
			} else if (selection.equals("2")) {
				displayStudy();
			} else if (selection.equals("3")) {
				createStudy();
			} else if (selection.equals("4")) {
				deleteStudy();
			} else if (selection.equals("5")) {
				createNerve();
			} else if (selection.equals("6")) {
				deleteNerve();
			}
			
		} catch	(SQLException e) {
			e.printStackTrace();
		}
			
			System.out.println("Press enter to continue...");
			scanner.hasNextLine();
		} while (!selection.contentEquals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select and Option:\n------------------------");
		for ( int  i = 0; i <  options.size(); i++) {
			System.out.println(i + 1 +" ) " + options.get(i));
		}
	}
	
	private void displayStudies() throws SQLException {
		List<Study> studies = studyDao.getStudies();
		for (Study study : studies) {
			System.out.println(study.getStudyId() + " : " + study.getName());
		}
	}
	
	private void displayStudy() throws SQLException {
		System.out.println("Enter study id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Study study = studyDao.getStudyById(id);
		System.out.println(study.getStudyId() + " : " + study.getName());
		for (Nerve nerve : study.getNerves()) {
			System.out.println("\tNerveId: " + nerve.getNerveId() + " - Muscle: " + nerve.getMuscle() + "- Type: " + nerve.getType());
		}
	}
	
	private void createStudy() throws SQLException {
		System.out.println("Enter new study name: ");
		String studyName = scanner.nextLine();
		studyDao.createNewStudy(studyName);
		
	}
	
	private void deleteStudy() throws SQLException {
		System.out.println("Enter study id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		studyDao.DeleteStudyById(id);
	}
	
	private void createNerve() throws SQLException {
		System.out.println("Enter muscle of new nerve: ");
		String muscle = scanner.nextLine();
		System.out.println("Enter type of new nerve: ");
		String type = scanner.nextLine();
		System.out.println("Enter study id of new nerve");
		int studyId = Integer.parseInt(scanner.nextLine());
		nerveDao.createNewNerve(muscle, type, studyId);
	}
	
	private void deleteNerve() throws SQLException {
		System.out.println(" Enter nerve id to delete:  ");
		int id = Integer.parseInt(scanner.nextLine());
		nerveDao.deleteNerveById(id);
	}

}
