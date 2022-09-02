import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.CarRentalModel;
import model.VehicleModel;
import services.BrazilTaxService;
import services.RentalService;

public class App {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        Double pricePerDay = 130.00;
        Double pricePerHour = 10.00;

        System.out.println("Enter rental data: ");
        System.out.print("Car model: ");
        String vehicle = sc.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        Date start = (Date) format.parse(sc.nextLine());
        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        Date finish = (Date) format.parse(sc.nextLine());

        CarRentalModel carRental = new CarRentalModel(start, finish, new VehicleModel(vehicle));

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("INVOICE:");
        System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().totalPayment()));

        sc.close();
    }
}
