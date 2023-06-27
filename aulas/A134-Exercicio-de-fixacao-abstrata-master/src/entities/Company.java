package entities;

public class Company extends TaxPayer {
    
    private int numberOfEmployees;

    public Company() {
    }

    public Company(String name, Double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
    
    
    @Override
    public final double tax() {
        double sum = 0.0;
        if(numberOfEmployees >= 25){
            sum = getAnualIncome() * 0.14;
            
        }else{
            sum = getAnualIncome() * 0.16;
            
        }
        return sum;
    }
    
    
    
}
