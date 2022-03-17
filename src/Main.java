import java.util.Scanner;

public class Main {

    private static final int ADD_PEOPLE = 1;
    private static final int REMOVE_PEOPLE = 2;

    public static void main(String[] args) throws Exception {
        Restaurant restaurant = createRestaurant();
        int option = chooseOption();
        managePeopleOnRestaurant(restaurant, option);
    }

    private static void managePeopleOnRestaurant(Restaurant restaurant, int option) throws Exception {
        if (option == ADD_PEOPLE) {
            addPeopleToRestaurant(restaurant);
        }
        if (option == REMOVE_PEOPLE) {
            removePeopleFromRestaurant(restaurant);
        }
    }

    private static int chooseOption() {
        System.out.println("¿Quieres añadir o eliminar clientes? 1 - Añadir 2 - eliminar");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void removePeopleFromRestaurant(Restaurant restaurant) throws Exception {
        while (restaurant.getCurrentSeatings() > 0 && askUserIfWantsToRemoveClient()) {
            removeTableOnRestaurant(restaurant);
            showHowManyPeopleIsOnRestauntant(restaurant);
        }
    }

    private static void removeTableOnRestaurant(Restaurant restaurant) throws Exception {
        int pos = askWhichTableWantsToRemove();
        restaurant.removeTableOnIndex(pos - 1);
    }

    private static int askWhichTableWantsToRemove() {
        System.out.println("¿Qué mesa quieres eliminar?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void addPeopleToRestaurant(Restaurant restaurant) throws Exception {
        while (restaurant.getRemainingSeats() > 0 && askUserIfWantsToEnterClient()) {
            assignPeopleToRestaurant(restaurant);
            showHowManyPeopleIsOnRestauntant(restaurant);
        }
    }

    private static boolean askUserIfWantsToEnterClient() {
        System.out.println("Vols afegir més clients? (S/N)");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().equalsIgnoreCase("S");
    }

    private static boolean askUserIfWantsToRemoveClient() {
        System.out.println("Vols eliminar més clients? (S/N)");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().equalsIgnoreCase("S");
    }

    private static void showHowManyPeopleIsOnRestauntant(Restaurant restaurant) {
        System.out.println("Quedan " + restaurant.getRemainingSeats() + " llocs de " + restaurant.getMaxCapacity() + " disponibles, " +
                "en el restaurant " + restaurant.getName());

        System.out.println("Mesas: \n" + restaurant.printTablesStatus());
    }

    private static void assignPeopleToRestaurant(Restaurant restaurant) throws Exception {
        int numOfPeople = askForHowManyPeopleToEnter();
        restaurant.addClients(numOfPeople);
    }

    private static int askForHowManyPeopleToEnter() {
        System.out.println("¿Cuantas personas van a entrar?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static Restaurant createRestaurant() throws Exception {
        String name = askForRestaurantName();
        int type = askForTypeOfRestaurant();
        return new Restaurant(name, type);
    }

    public static String askForRestaurantName() {
        System.out.println("Nombre del restaurante: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int askForTypeOfRestaurant() {
        System.out.println("Tipo de restaurante (Pizza - 1, Chino - 2, Kebab - 3):");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
