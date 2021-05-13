package com.employeewagebuilder;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * EmpWageBuilder class implements interface methods.
 * So all methods should be Public.
 * @author User
 *
 */

public class EmpWageBuilder implements EmpWageInterface {
	
    /**
     * Creating an Arraylist of class CompanyEmpWage named companyEmpWageList.
     * Added hashmap to store values in key value pair and to get the value by using key.
     */
   
    private ArrayList<CompanyEmpWage> companyEmpWageList;
    private HashMap<String,CompanyEmpWage> companyToEmpWage;

    public EmpWageBuilder()
    {
        companyEmpWageList = new ArrayList<>();
        companyToEmpWage = new HashMap<>();
        
    }

    /**
     * this method taking these parameters and adding the company employee wage to that arraylist.
     * @param company
     * @param empRatePerHr
     * @param noOfWorkingDays
     * @param maxHrsPerMonth
     */

    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
    	CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, noOfWorkingDays,maxHrsPerMonth);
    	companyEmpWageList.add(companyEmpWage);
    	/**
    	 * here the hashmap will put all the datas as key(Company name) value(CompanyEmpWage) pairs.
    	 */
    	companyToEmpWage.put(company,companyEmpWage);
    }
    /**
     * this method will iterate till the size of the arraylist.
     * internally it's calling setTotalEmpWage method by passing integer as parameter.
     * It's calling printDailywage.
     */

    public void computeEmpWage() {

        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            companyEmpWage.printDailyWage();
            System.out.println(companyEmpWage);
        }
    }
    /**
     * This method will compute the Employee wage.
     * Taking the object of CompanyEmpWage class as a parameter.
     * 
     * @param companyEmpWage
     * @return
     */
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        // Variables
        int partTimeEmpHr=4;
        int fullTimeEmpHrs = 8;
        int totalWorkingHrs=0,totalWorkingDays=0;
        companyEmpWage.dailyWage = new int[companyEmpWage.noOfWorkingDays];

        while (totalWorkingDays < companyEmpWage.noOfWorkingDays && totalWorkingHrs < companyEmpWage.maxHrsPerMonth) {
        	totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
            
                case 0:
                    System.out.println("Employee is absent");
                   
                    break;

                case 1:
                    System.out.println("Employee is Present");
                    totalWorkingHrs = totalWorkingHrs + 8;
                    break;
                case 2:
                    System.out.println("Employee is Present but Half-Time");
                    totalWorkingHrs = totalWorkingHrs + 4;              
                    break;
            }
            companyEmpWage.dailyWage[totalWorkingDays-1] = totalWorkingHrs * companyEmpWage.empRatePerHr;
        }
        return totalWorkingHrs * companyEmpWage.empRatePerHr;
    }
    /**
     * this method will take company name as a parameter.
     * According to the company name it will get the total emp wage.
     */
    public int getTotalWage(String companyname){
        return companyToEmpWage.get(companyname).totalEmpWage;
    }

    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program...");

        int num;
        Scanner scanner = new Scanner(System.in);;
        System.out.println("Enter the No. of Company to Compute: ");
        num=scanner.nextInt();
        /**
         * here i have created an object of empwagebuilder class using EmpWageInterface.
         * Interface can store values of subclass.
         */
        EmpWageInterface empWageBuilder = new EmpWageBuilder();
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
        /**
         * This will take Company name as user input and give output the total emp-wage.
         */
        System.out.println("Enter Company Name: ");
        System.out.println("Employee Wage: "+empWageBuilder.getTotalWage(scanner.next()));

	}

}
