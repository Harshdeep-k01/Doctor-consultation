

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import BookAppointment.BookAppointment;
import DatabaseService.DBConnection;
import Doctor.Doctor;
import Patient.Patient;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		try (Connection connection = DBConnection.getConnection()) {
			Patient patient = new Patient(connection);
			Doctor doctor = new Doctor(connection);
			BookAppointment appointment = new BookAppointment(connection, patient, doctor);

			while (true) {
				System.out.println("=== Hospital Management System ===");
				System.out.println("1. Add Patient");
				System.out.println("2. Add Doctor");
				System.out.println("3. View Patients");
				System.out.println("4. View Doctors");
				System.out.println("5. Book Appointment");
				System.out.println("6. Exit");

				System.out.println("Enter your choice: ");

				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					patient.addPatient();
					break;
				case 2:
					doctor.addDoctor();
					break;
				case 3:
					patient.viewPatients();
					break;
				case 4:
					doctor.viewDoctors();
					break;
				case 5:
					appointment.bookAppointment();
					break;
				case 6:
					sc.close();
					return;
				default:
					System.out.println("Please enter valid choice.");
					break;
				}

			}

		}
	}
}