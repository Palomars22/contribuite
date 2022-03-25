
public class TaxPayer {

	private Double salaryIncome, serviceIncome, capitalIncome, heathSpending, educationSpending;

	public TaxPayer(Double salaryIncome, Double serviceIncome, Double capitalIncome, Double heathSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.heathSpending = heathSpending;
		this.educationSpending = educationSpending;
	}

	public TaxPayer() {
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServiceIncome() {
		return serviceIncome;
	}

	public void setServiceIncome(Double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHeathSpending() {
		return heathSpending;
	}

	public void setHeathSpending(Double heathSpending) {
		this.heathSpending = heathSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double imposto = 0;
		if (salaryIncome < 30000) {
			imposto = salaryIncome;
		} else if (salaryIncome > 30000 && salaryIncome < 50000) {
			imposto = salaryIncome * 0.10;
		} else if (salaryIncome > 50000) {
			imposto = salaryIncome * 0.20;
		}
		return imposto;

	}

	public double servicesTax() {
		double impostoSer = 0;

		if (serviceIncome > 0) {
			impostoSer = serviceIncome * 0.15;
		}

		return impostoSer;
	}

	public double capitalTax() {
		double impostoCapital = 0;
		if (capitalIncome > 0) {
			impostoCapital = capitalIncome * 0.20;
		}

		return impostoCapital;
	}

	public double grossTax() {
		double soma = capitalTax() + salaryTax() + servicesTax();
		return soma;
	}

	public double taxRebate() {
		double gastoD = 0;
		double impostoFinal = 0;
		double sal = salaryTax();
		double cap = capitalTax();
		double ser = servicesTax();
		double abater = 0;
		double bruto = 0;

		gastoD = heathSpending + educationSpending;
		bruto = sal + cap + ser;
		abater = heathSpending + educationSpending;
		if (abater > 0) {
			abater = bruto * 0.30;

			if (abater > gastoD) {
				abater = gastoD;
			}

		}

		impostoFinal = bruto - abater;
		
		return abater;
	}

	public double netTax() {
	    double brut=grossTax();
	    double abt=taxRebate();
		double liquido=brut-abt;
		return liquido;
	}

}
