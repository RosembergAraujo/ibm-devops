package ibm.berg.ibm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ibm.berg.ibm.Utils.Util;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.SpringApplication;


@SpringBootApplication
public class IbmBergNameApplication {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

		Util.ClearScreen();

		System.out.println("===== [ Turma 2 Java IBM ] =======");

		List<String> names = new ArrayList<>();
		for(int i=1; i<=5; i++){
			System.out.print("Digite  o "+ i +" nome: ");
			names.add(reader.readLine());
		}

		System.out.println("\nOs nomes digitados foram: \n");

		for (var name : names) {
			System.out.println(" - "+name);
		}

		// SpringApplication.run(IbmBergNameApplication.class, args);
	}

}
