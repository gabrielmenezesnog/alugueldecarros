package model;

import java.util.Date;

public class CarRentalModel {
  private Date start;
  private Date finish;
  private VehicleModel vehicle;
  private InvoiceModel invoice;

  public CarRentalModel() {
  }

  public CarRentalModel(Date start, Date finish, VehicleModel vehicle) {
    this.start = start;
    this.finish = finish;
    this.vehicle = vehicle;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getFinish() {
    return finish;
  }

  public void setFinish(Date finish) {
    this.finish = finish;
  }

  public VehicleModel getVehicle() {
    return vehicle;
  }

  public void setVehicle(VehicleModel vehicle) {
    this.vehicle = vehicle;
  }

  public InvoiceModel getInvoice() {
    return invoice;
  }

  public void setInvoice(InvoiceModel invoice) {
    this.invoice = invoice;
  }

}
