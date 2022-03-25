import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Quantos contribuintes você vai digitar?");
		int qtd = sc.nextInt();

		double salario, medico, educ, capital, servico;

		List<TaxPayer> list = new ArrayList<>();
		for (int i = 0; i < qtd; i++) {

			System.out.println("*********************************************************");
			System.out.println("Renda anual com salario");
			salario = sc.nextDouble();
			System.out.println("Renda anual com prestacao de servicos");
			servico = sc.nextDouble();
			System.out.println("Renda anual com ganho de capital");
			capital = sc.nextDouble();
			System.out.println("Gastos medicos");
			medico = sc.nextDouble();
			System.out.println("Gastos educacionais");
			educ = sc.nextDouble();
			System.out.println("*********************************************************");
			TaxPayer ta = new TaxPayer(salario, servico, capital, medico, educ);
			list.add(ta);

		}
		for (TaxPayer t : list) {
			System.out.println("_________________________________________");
			System.out.println("Resumo do º contrinuinte :");
			System.out.println("_________________________________________");

			System.out.printf(String.format("Total Bruto : %.2f%n", t.grossTax()));
			System.out.printf(String.format("Abatimento :%.2f%n ", t.taxRebate()));
			System.out.printf(String.format("Imposto devido :%.2f%n ", t.netTax()));
		}
		sc.close();
	}

}
