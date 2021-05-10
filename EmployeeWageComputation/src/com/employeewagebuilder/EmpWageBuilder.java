package com.employeewagebuilder;
import java.util.Scanner;

/**
 * EmpWageBuilder class implements interface methods.
 * So all methods should be Public.
 * @author User
 *
 */

public class EmpWageBuilder implements EmpWageInterface {
	/**
	 * Created an integer variable assigned 0.
	 */
    private int numOfCompany = 0;
    /**
     * Creating an array of class CompanyEmpWage.
     */
    private CompanyEmpWage[] companyEmpWageArray;

    /**
     * Inside the constructor it's taking the size of that array to 5.
     */
    public EmpWageBuilder(int n) {
        companyEmpWageArray = new CompanyEmpWage[n];
    }
    /**
     * this method taking these parameters and adding the company employee wage to that array.
     * @param company
     * @param empRatePerHr
     * @param noOfWorkingDays
     * @param maxHrsPerMonth
     */

    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHr, noOfWorkingDays,maxHrsPerMonth);
        numOfCompany++;
    }
    /**
     * this method will iterate till the size of numofcompany.
     * internally it's calling setTotalEmpWage method by passing integer as parameter.
     */

    public void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }

    /**
     * This method will compute the Employee wage.
     * Taking the object of CompanyEmpWage class as a parameter.
     * @param companyEmpWage
     * @return
     */
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        // Variables
        int partTimeEmpHr=4;
        int empRatePerHr = 20;
        int fullTimeEmpHrs = 8;
        int empWage=0,totalMonthlyWage=0;
        int totalWorkingHrs=0,totalWorkingDays=0;

        while (totalWorkingDays < companyEmpWage.noOfWorkingDays && totalWorkingHrs < companyEmpWage.maxHrsPerMonth) {
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
            
                case 0:
                    System.out.println("Employee is absent");
                    break;

                case 1:
                    System.out.println("Employee is Present");
                    empWage = Math.multiplyExact(fullTimeEmpHrs, empRatePerHr);
                    System.out.println("Employee Daily Wage is :" + empWage);
                    totalWorkingHrs = totalWorkingHrs + 8;
                    totalWorkingDays = totalWorkingDays++;
                    break;
                case 2:
                    System.out.println("Employee is Present but Half-Time");
                    empWage = Math.multiplyExact(partTimeEmpHr, empRatePerHr);
                    System.out.println("Employee's Part-Time Wage is :" + empWage);
                    totalWorkingHrs = totalWorkingHrs + 4;
                    totalWorkingDays = totalWorkingDays++;
                    break;
            }
            totalMonthlyWage = totalMonthlyWage + empWage;
        }
        return totalWorkingHrs * companyEmpWage.empRatePerHr;
    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program...");

        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter No. of Companies");
        num = scanner.nextInt();
        /**
         * here i have created an object of empwagebuilder class using EmpWageInterface.
         * Interface can store values of subclass.
         * taking num as a parameter for the constructor.
         */
        EmpWageInterface empWageBuilder = new EmpWageBuilder(num);
        /**
         * this for loop will iterate till size of num given as input.
         * it will take input and store in addCompanyEmpWage method.
         */
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Company Details as given:");
            System.out.println("Enter your Company name: ");
            String CompanyName=scanner.next();
            System.out.println("Enter your Employee rate per hour: ");
            int emprate=scanner.nextInt();
            System.out.println("Enter your No. of Working Days: ");
            int workdays=scanner.nextInt();
            System.out.println("Enter your Max hours per Month: ");
            int maxHrs=scanner.nextInt();
            
            empWageBuilder.addCompanyEmpWage(CompanyName,emprate,workdays,maxHrs);
        }
        System.out.println("");
        empWageBuilder.computeEmpWage();
	}

}
