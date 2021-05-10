package com.employeewagebuilder;

public class CompanyEmpWage {
	
    /**
     * Put the while loop inside a method.
     * This while loop will iterate till working days is 20 and Total working hrs is 100.
     * calculate the monthly wage of Employee.
     */
	/**
	 * Created a method having these parameters through which it will calculate.
	 * @param company
	 * @param empRatePerHr
	 * @param numOfWorkingDays
	 * @param maxHoursPerMonth
	 */
   static void calculateTotalwage(String company, int empRatePerHr, int numOfWorkingDays, int maxHoursPerMonth) {
	    int partTimeEmpHr=4;
	    int fullTimeEmpHrs = 8;
	    int empWage=0,totalMonthlyWage=0;
	    int totalWorkingHrs=0,totalWorkingDays=0;
        while (totalWorkingDays < numOfWorkingDays && totalWorkingHrs < maxHoursPerMonth) {
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
        System.out.println("Company name: "+company);
        System.out.println("Employee Monthly Wage is :" + totalMonthlyWage);
    }
    /**
     * Here this method will take the parameters as input.
     * @param args
     */
    public static void main(String [] args) {
        System.out.println("Welcome To Employee wage Computation Program");
		calculateTotalwage("DMart", 20, 20, 100);
		calculateTotalwage("Reliance", 30, 15, 150);
	}

}
