package ExamPreparation.VetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }
    public Pet getPet(String name, String owner) {
        return data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner)).findFirst().get();
    }
    public Pet getOldestPet() {
        return data.stream().sorted(((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge()))).findFirst().get();
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
        for (Pet pet : data) {
            sb.append(System.lineSeparator());
            sb.append(pet.getName() + " " + pet.getOwner());
        }
        return sb.toString();
    }
}
