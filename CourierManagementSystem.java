import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourierManagementSystem {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add Courier");
            System.out.println("2. Update Courier Status");
            System.out.println("3. Track Courier");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.println("Enter tracking ID:");
                    String trackingId = scanner.nextLine();
                    
                    System.out.println("Enter description:");
                    String description = scanner.nextLine();
                    
                    couriers.put(trackingId, new Courier(trackingId, description));
                    System.out.println("Courier added successfully!");
                    break;
                    
                case 2:
                    System.out.println("Enter tracking ID:");
                    trackingId = scanner.nextLine();
                    
                    Courier courier = couriers.get(trackingId);
                    
                    if (courier != null) {
                        System.out.println("Enter new status:");
                        String status = scanner.nextLine();
                        courier.setStatus(status);
                        System.out.println("Status updated successfully!");
                    } else {
                        System.out.println("Courier not found!");
                    }
                    break;
                    
                case 3:
                    System.out.println("Enter tracking ID:");
                    trackingId = scanner.nextLine();
                    
                    courier = couriers.get(trackingId);
                    if (courier != null) {
                        System.out.println(courier);
                    } else {
                        System.out.println("Courier not found!");
                    }
                    break;
                    
                case 4:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

class Courier {
    private String trackingId;
    private String description;
    private String status;
    
    public Courier(String trackingId, String description) {
        this.trackingId = trackingId;
        this.description = description;
        this.status = "Pending";
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Courier [trackingId=" + trackingId + ", description=" + description + ", status=" + status + "]";
    }
}