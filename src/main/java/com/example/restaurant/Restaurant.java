package com.example.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurant {
    private static final int MAX_CAPACITY = 24;
    private static final int MAX_NUMBER_CLIENTS_OF_TABLES = 6;
    private String name;
    private String id = UUID.randomUUID().toString();
    private int type;
    private static final int PIZZA = 1;
    private static final int KEBAB = 2;
    private static final int CHINO = 3;

    private List<Table> tables = new ArrayList<>();

    public Restaurant() {


    }

    public Restaurant(String name, int type) throws Exception {
        checkName(name);
        checkType(type);
        this.name = name;
        this.type = type;

    }

    public Table getOneTable(String id) throws Exception {

        for (Table currentTable : tables) {

            if (currentTable.getId().equals(id)) {
                return currentTable;
            }

        }
        throw new Exception("Not Found");

    }

    public void deleteOneTable(String tableId) throws Exception {

        for (Table currentTable : new ArrayList<>(tables)) {

            if (currentTable.getId().equals(tableId)) {
                tables.remove(currentTable);
                return;
            }

        }
        throw new Exception("Not Found");
    }

    public void deleteTables() {

        tables.clear();
    }

    private void checkType(int type) throws Exception {
        if (type != PIZZA && type != CHINO && type != KEBAB) {
            throw new Exception();
        }
    }

    private void checkName(String name) throws Exception {
        if (name.equals("")) throw new Exception();
    }

   public int getCurrentSeatings() {
        int result = 0;
        for (Table table : tables) {
            result += table.getCurrentSeatings();
        }
        return result;
    }

    public int getRemainingSeats() {
        return MAX_CAPACITY - getCurrentSeatings();
    }

    //mientras queden clientes pendientes de asignar a una mesa
    // y queden mesas disponibles
    //1.crear una nueva mesa
    //2. Asignar los clientes pendientes a esa nueva mesa
    //3. Actualizar el número de clientes pendientes de asignar


    public void addClients(int numOfPeople) throws Exception {
        checkPeopleCanEnter(numOfPeople);

        List<Table> assignedTables = new ArrayList<>();

        while (numOfPeople > 0 && remaingTables()) {

            Table table = new Table();
            assignedTables.add(table);

            if (numOfPeople > MAX_NUMBER_CLIENTS_OF_TABLES) {

                numOfPeople = numOfPeople - MAX_NUMBER_CLIENTS_OF_TABLES;
                table.addClients(MAX_NUMBER_CLIENTS_OF_TABLES);

            } else { table.addClients(numOfPeople);
                     numOfPeople = 0; }

        }

        if (numOfPeople == 0) {
            tables.addAll(assignedTables);
        } else {
            throw new Exception("No quedan mesas");
        }


    }

    private boolean remaingTables() {
        return tables.size() < MAX_NUMBER_CLIENTS_OF_TABLES;
    }


    public List<Table> getTables() {
        return tables;
    }

    private void checkPeopleCanEnter(int numOfPeople) throws Exception {
        if ((this.getCurrentSeatings() + numOfPeople) > MAX_CAPACITY)
            throw new Exception("Massa gent");
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public String printTablesStatus() {
        String result = "";
        int i = 1;
        for (Table table : tables) {
            result += "Mesa " + i + " :" + table.getCurrentSeatings() + " personas \n";
            i++;
        }
        return result;
    }

    public void removeTableOnIndex(int pos) throws Exception {
        if (this.tables.isEmpty() || pos > this.tables.size()) {
            throw new Exception();
        }
        this.tables.remove(pos);
    }
    public int getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
}

