
// Header files section
#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

// pre-processor statements to set the tax rate,
// cost of insurance, and cost of utilities
#define PROPERTY_TAX_RATE_PER_YEAR 1.25
#define COST_OF_UTILITIES_PER_MONTH 300.00
#define COST_OF_INSURANCE_PER_YEAR 550.00

// function prototypes

// function to input all data
void inputData(double& sellingPrice, double& interestRate, int& durationOfLoan);

// function to handle all computations
void handleAllComputations(double sellingPrice, double interestRate,
    int durationOfLoan, double downPaymentRate, double& downPayment,
    double& amountOfLoan, double& mortgagePayment,
    double& propertyTax, double& costOfInsurance, double& totalMonthlyHouseCost);

// function to compute the down payment
double calculateDownPayment(double sellingPrice, double downPaymentRate);

// function to compute the amount of loan
double calculateAmountOfLoan(double sellingPrice, double downPayment);

// function to compute the mortgage payment
double calculateMortgagePayment(double amountOfLoan, double interestRate, int durationOfLoan);

// function to output the results
void outputResults(double sellingPrice, double downPayment, double amountOfLoan,
    double interestRate, int durationOfLoan, double mortgagePayment,
    double propertyTax, double costOfInsurance, double totalMonthlyHouseCost);

// start main function
int main() {
    // create a a non-global memory constant
	// left this because i couldn't help myself
	
    const double DOWN_PAYMENT_RATE = 20.00;

    // declare the required variables
    double sellingPrice = 0.0;
    double interestRate = 0.0;
    int durationOfLoan = 0;
    double downPayment = 0.0;
    double amountOfLoan = 0.0;
    double mortgagePayment = 0.0;
    double propertyTax = 0.0;
    double costOfInsurance = 0.0;
    double totalMonthlyHouseCost = 0.0;

    // call the input function
    inputData(sellingPrice, interestRate, durationOfLoan);

    // call the handleAllComputations function
    handleAllComputations(sellingPrice, interestRate, durationOfLoan, DOWN_PAYMENT_RATE, downPayment, amountOfLoan, mortgagePayment, propertyTax, costOfInsurance, totalMonthlyHouseCost);

    // call the outputResults function
    outputResults(sellingPrice, downPayment, amountOfLoan, interestRate, durationOfLoan, mortgagePayment, propertyTax, costOfInsurance, totalMonthlyHouseCost);
  
    return 0;
} // end of main function

// *******if you get lost reference the int main to code. everything in int main needs to be use or the code won't work******

// this is where user enters the numbers
void inputData(double& sellingPrice, double& interestRate, int& durationOfLoan) {
    // prompt the user for the selling price
    cout << "Enter the selling price: $";
    cin >> sellingPrice;

    // prompt the user for the rate of interest
    cout << "Enter the rate of interest: ";
    cin >> interestRate;

    // prompt the user for the number of years for the loan
    cout << "Enter the number of years for the loan: ";
    cin >> durationOfLoan;

} // end of inputData function

// handleAllComputations function implementation
void handleAllComputations(double sellingPrice, double interestRate, int durationOfLoan, double downPaymentRate, double& downPayment, double& amountOfLoan, double& mortgagePayment, double& propertyTax, double& costOfInsurance, double& totalMonthlyHouseCost) {
  // code here
  // *** this is where all the code goes but use all the variables and functions
  
} // end of handleAllComputations function

// calculateDownPayment function implementation
double calculateDownPayment(double sellingPrice, double downPaymentRate) {
    return sellingPrice * downPaymentRate / 100.0;

} // end of calculateDownPayment function

// calculateAmountOfLoan function implementation
double calculateAmountOfLoan(double sellingPrice, double downPayment) {
   //**code here**
   //**hint its [return] something line
} // end of calculateAmountOfLoan function

// calculateMortgagePayment function implementation
double calculateMortgagePayment(double amountOfLoan, double interestRate, int durationOfLoan) {

// ***code here***
// code for calculation

    return mortgagePayment;
} // end of calculateMortgagePayment function

// outputResults function implementation
// this is making the output look presentable
void outputResults(double sellingPrice, double downPayment, double amountOfLoan,
    double interestRate, int durationOfLoan, double mortgagePayment,
    double propertyTax, double costOfInsurance, double totalMonthlyHouseCost) {
    cout << fixed << setprecision(2);
    cout << endl << "MONTHLY COST OF HOUSE" << endl << endl;
    cout << left << setw(30) << "SELLING PRICE" << "$" << right << setw(9) << sellingPrice << endl;
    cout << left << setw(30) << "DOWN PAYMENT" << right << setw(10) << downPayment << endl;
    cout << left << setw(30) << "AMOUNT OF LOAN" << right << setw(10) << amountOfLoan << endl;
    cout << left << setw(30) << "INTEREST RATE" << right << setw(10) << interestRate << "%" << endl;
    cout << left << setw(30) << "TAX RATE" << right << setw(10) << PROPERTY_TAX_RATE_PER_YEAR << "%" << endl;
    cout << left << setw(30) << "DURATION OF LOAN (YEARS)" << right << setw(10) << durationOfLoan << endl;
    
    cout << endl << "MONTHLY PAYMENT" << endl;
    cout << setw(5) << "" << left << setw(25) << "MORTGAGE" << right << setw(10) << mortgagePayment << endl;
    cout << setw(5) << "" << left << setw(25) << "UTILITIES" << right << setw(10) << COST_OF_UTILITIES_PER_MONTH << endl;
    cout << setw(5) << "" << left << setw(25) << "PROPERTY TAXES" << right << setw(10) << propertyTax << endl;
    cout << setw(5) << "" << left << setw(25) << "INSURANCE" << right << setw(10) << costOfInsurance << endl;
    cout << left << setw(30) << "" << "__________" << endl;

    cout << setw(30) << "" << "$" << right << setw(9) << setprecision(2) << totalMonthlyHouseCost << endl;

} // end of outputResults function
