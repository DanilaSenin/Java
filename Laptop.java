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
    
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Lenovo", 8, 512, "Windows 10", "Silver"));
        laptops.add(new Laptop("Dell", 16, 1000, "Windows 10", "Black"));
        laptops.add(new Laptop("HP", 8, 256, "Windows 10", "White"));
    
        Map<String, String> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Введите цифру, соответствующую необходимому критерию:\n1 - ОЗУ\n2 - Объем ЖД\n3 - Операционная система\n4 - Цвет");
        int criterion = scanner.nextInt();
    
        switch (criterion) {
            case 1:
                System.out.println("Введите минимальное значение RAM:");
                int minRam = scanner.nextInt();
                filters.put("ram", String.valueOf(minRam));
                break;
            case 2:
                System.out.println("Введите минимальный объем хранения:");
                int minStorage = scanner.nextInt();
                filters.put("storage", String.valueOf(minStorage));
                break;
            case 3:
                System.out.println("Введите желаемую операционную систему:");
                String os = scanner.next();
                filters.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filters.put("color", color);
                break;
            default:
                System.out.println("Некорректный ввод.");
        }
    
        filterLaptops(laptops, filters);
    }
}

