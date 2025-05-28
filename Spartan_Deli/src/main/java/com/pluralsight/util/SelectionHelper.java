package com.pluralsight.util;

public class SelectionHelper {

    public static String getBreadName(int choice){
        return switch (choice){
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "White";
        };
    }

    public static String getMeatsdName(int choice){
        return switch (choice){
            case 1 -> "Steak";
            case 2 -> "Ham";
            case 3 -> "Salami";
            case 4 -> "Roast Beef";
            case 5 -> "Chicken";
            case 6 -> "Bacon";
            default -> "None";
        };
    }

    public static String getCheeseName(int choice){
        return switch (choice){
            case 1 -> "American";
            case 2 -> "Provolone";
            case 3 -> "Cheddar";
            case 4 -> "Swiss";
            default -> "None";
        };
    }

    public static String getRegularToppongsName(int choice){
        return switch (choice){
            case 1 -> "Lettuce";
            case 2 -> "Peppers";
            case 3 -> "Onions";
            case 4 -> "Tomatoes";
            case 5 -> "Jalapenos";
            case 6 -> "Cucumbers";
            case 7 -> "Pickles";
            case 9 -> "Guacamole";
            case 10 -> "Mushrooms";
            default -> "None";
        };
    }

    public static String getSauceName(int choice){
        return switch (choice){
            case 1 -> "Mayo";
            case 2 -> "Mustard";
            case 3 -> "Ketchup";
            case 4 -> "Ranch";
            case 5 -> "Thousand Islands";
            case 6 -> "Vinaigrette";
            default -> "None";
        };
    }

    public static String getDrinkName(int choice){
        return switch (choice){
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "None";
        };
    }


    public static String getSidesName(int choice){
        return switch (choice){
            case 1 -> "Au Jus";
            case 2 -> "Sauce";
            default -> "None";
        };
    }

    public static boolean yesNo(int choice){
        return switch (choice){
            case 1 -> true;
            case 2 -> false;
            default -> true;
        };
    }
}

