package com.example.restaurant;


import org.springframework.web.bind.annotation.*;
import org.json.*;


import java.util.List;

@RestController
public class RestaurantRestController {

    private RestaurantService restaurantService;

    public RestaurantRestController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() throws Exception {

        return restaurantService.getRestaurants();

    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurantToCreate) {
        return restaurantService.createRestaurant(restaurantToCreate);
    }
    @PostMapping("/restaurants/{restaurantId}/tables")
    public void assignClientsOnRestaurant(@PathVariable String restaurantId, @RequestBody String jsonString) throws Exception {
        JSONObject json = new JSONObject(jsonString);
        int clients = json.getInt("clients");
        restaurantService.assignClientsOnRestaurant(restaurantId, clients);

    }

    @GetMapping("/restaurants/{restaurantId}/tables/{tableId}")

    public Table getTable(@PathVariable String restaurantId, @PathVariable String tableId) throws Exception {

        return restaurantService.getTable(restaurantId, tableId);
    }

    @DeleteMapping("/restaurants/{restaurantId}/tables/{tableId}")
    public void removeOneTable(@PathVariable String restaurantId, @PathVariable String tableId) throws Exception {

        restaurantService.removeTable(restaurantId, tableId);
    }
    @GetMapping("/restaurants/{restaurantId}/tables")

    public List<Table> getTablesOfRestaurant(@PathVariable String restaurantId) throws Exception {

        return restaurantService.getTablesOfRestaurant(restaurantId);
    }

    @DeleteMapping("/restaurants/{restaurantId}/tables")
    public void removeAllTables(@PathVariable String restaurantId) throws Exception {

        restaurantService.removeAllTables(restaurantId);
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurant(@PathVariable String restaurantId) throws Exception {

        return restaurantService.getRestaurant(restaurantId);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void removeRestaurant(@PathVariable String restaurantId){restaurantService.removeRestaurant(restaurantId);}

    @DeleteMapping("/restaurants")
    public void removeAllRestaurant() {restaurantService.removeAllRestaurant();}

    @PutMapping("/restaurants/{restaurantId}")
    public void updateRestaurant(@RequestBody Restaurant restaurantToUpdate, @PathVariable String restaurantId) throws Exception {

      restaurantService.updateRestaurant(restaurantToUpdate,restaurantId );
    }

}
