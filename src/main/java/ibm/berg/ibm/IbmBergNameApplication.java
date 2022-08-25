package ibm.berg.ibm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.SpringApplication;

import Models.Student;
import ibm.berg.ibm.Utils.Util;

@SpringBootApplication
public class IbmBergNameApplication {
	private static List<Student> students = new ArrayList<Student>();

	public static void main(String[] args) throws IOException, InterruptedException {
		// students.add(new Student("Jose"));
		// var s = new Student("Mario");
		// s.AddNewGrade("Historia", 19);
		// students.add(s);
		// for (Student student : students) {
		// 	System.out.println(student);
		// }
		MainMenu();

		// SpringApplication.run(IbmBergNameApplication.class, args);
	}

	private static void MainMenu() throws IOException, InterruptedException {

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		Util.ClearScreen();

		var plural = students.size() == 1 ? "" : "s";

		System.out.println("===== [ Turma 2 Java IBM |> (" + students.size() + ") estudante" + plural + " já cadastrado" + plural + ".  ] =======\n");
		System.out.print(
				"Opções :\n\n[1] Cadastro Aluno.\n[2] Atribuir notas.\n[3] Visualizar Alunos.\n\n[0] Para Sair.\n\n=> ");

		try {
			var choice = Integer.parseInt(reader.readLine());
			switch (choice) {
				case 1:
					StudentRegistration(reader);
					break;
				case 2:
					SetGrades(reader);
					break;
				case 3:
					ViewStudent(reader);
					break;
				case 0:
					Util.SendMessage("Finalizando...", 2000);
					System.exit(0);
					break;

				default:
					Util.SendMessage("Opção Invalida!", 3000);
					MainMenu();
					break;
			}
		} catch (Exception e) {
			Util.SendMessage("Erro!", 3000);
			MainMenu();
		}

	}

	private static void ViewStudent(BufferedReader reader) throws IOException, InterruptedException {

		var plural = students.size() == 1 ? "" : "s";

		System.out.println(
				"===== [ Exibindo Estudantes |> (" + students.size() + ") estudante" + plural + " já cadastrado" + plural + ".  ] =======\n\n");
		Util.ClearScreen();
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("\n\nPressione qualquer tecla para retornar ao menu inicial...");
		reader.readLine();
		MainMenu();
	}

	private static void SetGrades(BufferedReader reader) throws InterruptedException, IOException {
		Util.ClearScreen();
		if (students.size() == 0){
			Util.SendMessage("Cadastre um estudante primeiro!!");
			MainMenu();
		}
		var plural = students.size() == 1 ? "" : "s";

		System.out.println(
				"===== [ Atribuindo nota |> (" + students.size() + ") estudante" + plural + " já cadastrado" + plural + ".  ] =======\n\n");
		System.out.println("Selecione o Aluno a ter notas atribuidas.");
		var counter = 0;
		for (Student student : students) {
			System.out.println("["+counter+"] " + student.getName());
			counter += 1;
		}
		System.out.print("\n=> ");

		try {
			var choice = Integer.parseInt(reader.readLine());
			System.out.print("\nQual o nome da materia da nota que deseja adicionar para "+ students.get(choice).getName() +": ");
			var subject = reader.readLine();
			System.out.print("E a nota é: ");
			var grade = Float.parseFloat(reader.readLine());

			students.get(choice).AddNewGrade(subject, grade);
			Util.SendMessage("Nota adicionada");
			MainMenu();
		} catch (Exception e) {
			Util.SendMessage("Erro!", 3000);
		}
	}

	private static void StudentRegistration(BufferedReader reader) throws InterruptedException {
		Util.ClearScreen();

		var plural = students.size() == 1 ? "" : "s";

		System.out.println(
				"===== [ Cadastro Estudantes |> (" + students.size() + ") estudante" + plural + " já cadastrado" + plural + ".  ] =======\n");

		System.out.print("\nDigite \"0\" para retornar ao menu principal.\n\nNome do estudante a ser cadastrado: ");

		try {
			var name = reader.readLine();
			if (name.equals("0") || name.equals("\"0\""))
				MainMenu();
			students.add(new Student(name));
			Util.SendMessage("\n\"" + name + "\" Adicionado a lista de estudantes.", 800);
			MainMenu();
		} catch (Exception e) {
			Util.SendMessage("Erro!", 3000);
			StudentRegistration(reader);
		}
	}
}
