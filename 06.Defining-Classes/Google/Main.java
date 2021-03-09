package DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Google> googleList = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            String[] params = input.split("\\s+");
            if (getPersonId(googleList, params[0]) == -1) {
                Google newPerson = new Google(params[0]);
                googleList.add(newPerson);
            }
            int id = getPersonId(googleList, params[0]);
            Google currPerson = googleList.get(id);
            switch (params[1]) {
                case "company":
                    currPerson.setCompany(params[2], params[3], Double.parseDouble(params[4]));
                    break;

                case "pokemon":
                    currPerson.addPokemon(params[2], params[3]);
                    break;

                case "parents":
                    currPerson.addParent(params[2], params[3]);
                    break;

                case "children":
                    currPerson.addChildren(params[2], params[3]);
                    break;

                case "car":
                    currPerson.getCar().setModel(params[2]);
                    currPerson.getCar().setSpeed(Integer.parseInt(params[3]));
                    break;

            }
            input = scan.nextLine();
        }
        input = scan.nextLine();
        googleList.get(getPersonId(googleList, input)).printPerson();
    }

    public static int getPersonId (List<Google> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPersonName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}
