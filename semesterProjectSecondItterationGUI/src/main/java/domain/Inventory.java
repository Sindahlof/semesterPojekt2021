package domain;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<PlaceableObject> inventory;

    //No arg constructor to initialise PlaceableObject Arraylist inventory.
    Inventory() {
        this.inventory = new ArrayList<>();
    }

    // A getter for inventory
    public ArrayList<PlaceableObject> getInventory() {
        return this.inventory;
    }

    // Method to add items to the inventory
    public void addItem(PlaceableObject placeableObject) {
        this.inventory.add(placeableObject);
    }

    public String inventoryChecker(){
        return ("You have the following item(s) in your inventory:");
    }
    public String contentsOfInventory(PlaceableObject placeableObject){
        return (placeableObject.getObjectName() + ", ");
    }
    public String inventoryCheckerEmpty(){
        return ("There are no items in your inventory.");
    }

    //Method to print the contents of inventory
    public String inventoryHandler() {
        String inventory;
        if (!(this.inventory.isEmpty())) { //Obv. checks if the inventory is empty first
            inventory = inventoryChecker() + "\n";
            for (PlaceableObject placeableObject : this.inventory) { // Goes through all the objects in the inventory and prints it
                return inventory + contentsOfInventory(placeableObject);
            }
        } else {
            inventory = inventoryCheckerEmpty();
            return inventory;
        }
        return "";
    }

    public void inspectObjects(Command command) { //Method used to inspect an object in your inventory
        if (!(command.hasSecondWord())) { //Checks if you have specified which object you would like to inspect
            System.out.println("Inspect what object?");
            return;
        } else {
            for (PlaceableObject placeableObject : this.inventory) { //Goes through the inventory to find the item you would like to inspect
                if (placeableObject.getObjectName().equalsIgnoreCase(command.getSecondWord())) {
                    placeableObject.print();
                    return;
                }
            }
        }
        System.out.println("You dont have that item in your inventory");
    }

    public boolean collectedAllWindmillParts() { //Method used to check if you have all the windmill parts in your inventory
        int collectiveId = 0;

        for (PlaceableObject placeableObject : this.inventory) {//Goes through the inventory to find the windmill parts
            if (placeableObject instanceof WindMillPart) {
                collectiveId += ((WindMillPart) placeableObject).getId();
            }
        }
        if (collectiveId >= 21) {
            return true;
        }
        return false;
    }
}
/*
    public void printInventory() {
        if (!(this.inventory.isEmpty())) { //Obv. checks if the inventory is empty first
            return this.inventoryChecker();
            for (PlaceableObject placeableObject : this.inventory) { // Goes through all the objects in the inventory and prints it
                return this.contentsOfInventory();
            }
            System.out.println();
        } else {
            System.out.println("There are no items in your inventory.");
        }
    }*/