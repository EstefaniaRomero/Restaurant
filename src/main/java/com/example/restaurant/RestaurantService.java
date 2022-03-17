package com.example.restaurant;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RestaurantService {
    private List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant createRestaurant(Restaurant restaurantToCreate) {
        restaurants.add(restaurantToCreate);
        return restaurantToCreate;
    }

    public void assignClientsOnRestaurant(String restaurantId, int clients) throws Exception {
        Restaurant restaurant = findRestaurant(restaurantId);
        restaurant.addClients(clients);
    }

    private Restaurant findRestaurant(String restaurantId) throws Exception {
        for (Restaurant restaurant : new ArrayList<>(restaurants)) {
            if (restaurant.getId().equals(restaurantId)) {
                return restaurant;
            }
        }
        throw new Exception("Not found");
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
    public Restaurant getRestaurant( String restaurantId) throws Exception {

        for (Restaurant restaurant:restaurants) {
            if ((restaurant.getId()).equals(restaurantId)) {
                return restaurant;
            }
        }
        throw new Exception();
    }

    public List<Table> getTablesOfRestaurant(String restaurantId) throws Exception {

        Restaurant restaurant = findRestaurant(restaurantId);
        return restaurant.getTables();
    }

    public Table getTable(String restaurantId, String tableId) throws Exception {

        Restaurant restaurant = findRestaurant(restaurantId);
        return restaurant.getOneTable(tableId);
    }

    public void removeTable(String restaurantId, String tableId) throws Exception {

        Restaurant restaurant = findRestaurant(restaurantId);
        restaurant.deleteOneTable(tableId);
    }

    public void removeAllTables(String restaurantId) throws Exception {

        Restaurant restaurant = findRestaurant(restaurantId);
        restaurant.deleteTables();
    }

    public void removeRestaurant(String restaurantId) {

        for (Restaurant restaurant : new ArrayList<>(restaurants)) {
            if (restaurant.getId().equals(restaurantId)) {
                restaurants.remove(restaurant);
            }
        }
    }

    public void removeAllRestaurant() {

        restaurants.clear();
    }

    public void updateRestaurant(Restaurant restaurantToUpdate, String restaurantId) throws Exception {
        for (Restaurant restaurant : new ArrayList<>(restaurants)) {
            if (restaurant.getId().equals(restaurantId)) {
                restaurant.setId(restaurantToUpdate.getId());
                restaurant.setType(restaurantToUpdate.getType());

                return;
            }
        }
        throw new Exception("Not found");
    }
}