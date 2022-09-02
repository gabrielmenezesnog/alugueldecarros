package model;

public class InvoiceModel {
  private Double basicPayment;
  private Double tax;

  public InvoiceModel() {
  }

  public InvoiceModel(double basicPayment, double tax) {
    this.basicPayment = basicPayment;
    this.tax = tax;
  }

  public double getBasicPayment() {
    return basicPayment;
  }

  public void setBasicPayment(double basicPayment) {
    this.basicPayment = basicPayment;
  }

  public double getTax() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax = tax;
  }

  public double totalPayment() {
    return getBasicPayment() + getTax();
  }

}