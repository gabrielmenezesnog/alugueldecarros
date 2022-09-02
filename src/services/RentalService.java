package services;

import model.CarRentalModel;
import model.InvoiceModel;

public class RentalService {
  private Double pricePerHour;
  private Double pricePerDay;
  private TaxService defaultTax;

  public RentalService() {
  }

  public RentalService(Double pricePerHour, Double pricePerDay, TaxService defaultTax) {
    this.pricePerHour = pricePerHour;
    this.pricePerDay = pricePerDay;
    this.defaultTax = defaultTax;
  }

  public Double getPricePerHour() {
    return pricePerHour;
  }

  public void setPricePerHour(Double pricePerHour) {
    this.pricePerHour = pricePerHour;
  }

  public Double getPricePerDay() {
    return pricePerDay;
  }

  public void setPricePerDay(Double pricePerDay) {
    this.pricePerDay = pricePerDay;
  }

  public TaxService getdefaultTax() {
    return defaultTax;
  }

  public void setdefaultTax(TaxService defaultTax) {
    this.defaultTax = defaultTax;
  }

  public void processInvoice(CarRentalModel carRental) {
    // momento em que o tempo de aluguel começou a correr
    long t1 = carRental.getStart().getTime();

    // momento em que o tempo de aluguel terminou
    long t2 = carRental.getFinish().getTime();

    // calculando diferença de tempo em horas
    double hours = (double) (t2 - t1) / 1000 / 60 / 60;
    double basicPayment;
    if (hours <= 12.0) {
      // arredondando horas para cima
      // em caso de horas quebradas
      basicPayment = Math.ceil(hours) * pricePerHour;
    } else {
      basicPayment = Math.ceil(hours / 24) * pricePerDay;
    }

    double tax = defaultTax.tax(basicPayment);

    carRental.setInvoice(new InvoiceModel(basicPayment, tax));
  }
}
