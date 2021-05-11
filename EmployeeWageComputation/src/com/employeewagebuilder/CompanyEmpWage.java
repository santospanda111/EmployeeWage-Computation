package com.employeewagebuilder;

public class CompanyEmpWage {
    public final String company;
    public final int empRatePerHr;
    public final int noOfWorkingDays;
    public final int maxHrsPerMonth;
    public int totalEmpWage;
    public int dailyWage[]; //added dailywage

    /**
     * Constructor having Parameters.
     * @param company
     * @param empRatePerHr
     * @param noOfWorkingDays
     * @param maxHrsPerMonth
     */
    public CompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        this.company = company;
        this.empRatePerHr = empRatePerHr;
        this.noOfWorkingDays = noOfWorkingDays;
        this.maxHrsPerMonth = maxHrsPerMonth;
    }
    /**
     * this method will take totalEmpwage as a parameter and initiate that.
     * @param totalEmpWage
     */
    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }
    /**
     * Inside this  method for loop will iterate till the size of dailywage array.
     * print the result with the following message.
     */
    public void printDailyWage(){
        for (int i=0;i<dailyWage.length;i++){
            System.out.println("Day "+(i+1)+"\t Wage = "+dailyWage[i]);
        }
    }
    /**
     * THis is an override method which will print the following message.
     */
    @Override
    public String toString() {
        return "Total Emp Wage for Company:" + company + " is: " + totalEmpWage + "\n";
	}

}
