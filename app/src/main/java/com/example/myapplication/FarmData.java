package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FarmData {
    public static List<Farm> getFarms() {
        List<Farm> farms = new ArrayList<>();

        farms.add(new Farm(
                "Orchard Farm",
                "Fresh fruit and veggies from the valley!",
                49.8801,
                -119.4436,
                "orchard_farm", // This should match your image name in res/drawable
                Arrays.asList(new Produce("Apples", 2.99), new Produce("Carrots", 1.99))
        ));

        farms.add(new Farm(
                "Green Valley Farm",
                "Fresh fruit and veggies from the valley!",
                49.9394,
                -119.3948,
                "green_valley_farm", // This should match your image name in res/drawable
                Arrays.asList(new Produce("Apples", 2.99), new Produce("Carrots", 1.99))
        ));

        farms.add(new Farm(
                "Gamu Plantations",
                "Fresh fruit and veggies from the valley!",
                49.9394,
                -119.3947,
                "gamu_plantations", // This should match your image name in res/drawable
                Arrays.asList(new Produce("Apples", 2.99), new Produce("Carrots", 1.99))
        ));

        farms.add(new Farm(
                "Zaki Holds",
                "Fresh fruit and veggies from the valley!",
                49.9394,
                -119.3938,
                "zaki_holds", // This should match your image name in res/drawable
                Arrays.asList(new Produce("Apples", 2.99), new Produce("Carrots", 1.99))
        ));

        farms.add(new Farm(
                "Keegan Ranches",
                "Fresh fruit and veggies from the valley!",
                49.9394,
                -119.3944,
                "keegan_ranches", // This should match your image name in res/drawable
                Arrays.asList(new Produce("Apples", 2.99), new Produce("Carrots", 1.99))
        ));

        farms.add(new Farm(
                "Gabi Croplands",
                "Fresh fruit and veggies from the valley!",
                49.9394,
                -119.3940,
                "gabi_croplands", // This should match your image name in res/drawable
                Arrays.asList(new Produce("Apples", 2.99), new Produce("Carrots", 1.99))
        ));


        return farms;
    }
}

