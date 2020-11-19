package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer,Location> locations = new HashMap<Integer,Location>();

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);

        locations.put(0, new Location(0,"You are in front of the computer in your room"));
        locations.put(1, new Location(1,"You are standing on the end of the road next to a small brick building"));
        locations.put(2, new Location(2,"You are on the top of a hill"));
        locations.put(3, new Location(3,"You are in a valley beside a stream"));
        locations.put(4, new Location(4,"You are in the forest"));
        locations.put(5, new Location(4,"You are inside of the building, power is off, windows are closed"));

        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("N",5);

        locations.get(2).addExit("N",5);

        locations.get(3).addExit("W",1);

        locations.get(4).addExit("N",1);
        locations.get(4).addExit("W",2);

        locations.get(5).addExit("S",1);
        locations.get(5).addExit("W",2);


        int loc=1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){
                break;
            }

            Map<String ,Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits: ");

            for (String exit: exits.keySet()){
                System.out.printf(exit + ", ");
            }
            System.out.println();

            String direction = skan.nextLine().toUpperCase();
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else {
                System.out.println("Can not go there");
            }

            if (!locations.containsKey(loc)){
                System.out.println("Can not to there");
            }
        }
    }





















}


