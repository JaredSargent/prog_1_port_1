package automobiles;

import java.util.ArrayList;
import java.util.List;

public class Automobiles {

	public static void main(String[] args) {
	    Automobile automobile = new Automobile();

	    // Adding vehicles
	    System.out.println(automobile.addVehicle("Toyota", "Corolla", "Blue", 2022));
	    System.out.println(automobile.addVehicle("Honda", "Civic", "Red", 2020));
	    System.out.println(automobile.addVehicle("Mitsubishi", "Evolution FE", "Rally Red", 2015)); // Added new vehicle

	    // Displaying vehicles
	    System.out.println(automobile.displayVehicles());

	    // Searching for a vehicle
	    System.out.println(automobile.searchVehicle("Toyota", "Corolla", 2022));

	    // Updating a vehicle
	    System.out.println(automobile.updateVehicle("Honda", "Civic", "Red", 2020, "Black"));

	    // Displaying updated vehicles
	    System.out.println(automobile.displayVehicles());

	    // Removing a vehicle
	    System.out.println(automobile.removeVehicle("Toyota", "Corolla", "Blue", 2022));

	    // Displaying remaining vehicles
	    System.out.println(automobile.displayVehicles());
	}
}

class Automobile {

    private List<String> vehicleInventory = new ArrayList<>();

    // Method to add a vehicle
    public String addVehicle(String autoMake, String autoModel, String autoColor, int autoYear) {
        String vehicle = String.format("Make: %s, Model: %s, Year: %d, Color: %s", autoMake, autoModel, autoYear, autoColor);
        vehicleInventory.add(vehicle);
        return "Vehicle added successfully: " + vehicle;
    }

    // Method to remove a vehicle
    public String removeVehicle(String autoMake, String autoModel, String autoColor, int autoYear) {
        String vehicle = String.format("Make: %s, Model: %s, Year: %d, Color: %s", autoMake, autoModel, autoYear, autoColor);
        if (vehicleInventory.remove(vehicle)) {
            return "Vehicle removed successfully: " + vehicle;
        } else {
            return "Vehicle not found: " + vehicle;
        }
    }

    // Method to update vehicle details
    public String updateVehicle(String autoMake, String autoModel, String autoColor, int autoYear, String newAutoColor) {
        String oldVehicle = String.format("Make: %s, Model: %s, Year: %d, Color: %s", autoMake, autoModel, autoYear, autoColor);
        if (vehicleInventory.contains(oldVehicle)) {
            vehicleInventory.remove(oldVehicle);
            String newVehicle = String.format("Make: %s, Model: %s, Year: %d, Color: %s", autoMake, autoModel, autoYear, newAutoColor);
            vehicleInventory.add(newVehicle);
            return "Vehicle updated successfully: " + newVehicle;
        } else {
            return "Vehicle not found: " + oldVehicle;
        }
    }

    // Method to search for a vehicle
    public String searchVehicle(String autoMake, String autoModel, int autoYear) {
        for (String vehicle : vehicleInventory) {
            if (vehicle.contains(String.format("Make: %s, Model: %s, Year: %d", autoMake, autoModel, autoYear))) {
                return "Vehicle found: " + vehicle;
            }
        }
        return "No matching vehicle found.";
    }

    // Method to display all vehicles
    public String displayVehicles() {
        if (vehicleInventory.isEmpty()) {
            return "No vehicles in inventory.";
        }
        StringBuilder inventory = new StringBuilder("Displaying all vehicles:\n");
        for (int i = 0; i < vehicleInventory.size(); i++) {
            inventory.append(i + 1).append(". ").append(vehicleInventory.get(i)).append("\n");
        }
        return inventory.toString();
    }
}
