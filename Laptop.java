import java.util.*;

public class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    

    public static void filterLaptops(Set<Laptop> laptops, Map<String, String> filters) {
        for (Laptop laptop : laptops) {
            boolean passedFilter = true;
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                switch (entry.getKey()) {
                    case "ram":
                        if (laptop.getRam() < Integer.parseInt(entry.getValue())) {
                            passedFilter = false;
                        }
                        break;
                    case "storage":
                        if (laptop.getStorage() < Integer.parseInt(entry.getValue())) {
                            passedFilter = false;
                        }
                        break;
                    case "os":
                        if (!laptop.getOs().equals(entry.getValue())) {
                            passedFilter = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equals(entry.getValue())) {
                            passedFilter = false;
                        }
                        break;
                }
            }
            if (passedFilter == true) {
                System.out.println("Ноутбук " + laptop.getBrand() + " проходит по условиям фильтра.");
            }
        }
    }
    
}

