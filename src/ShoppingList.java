import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoppingList
{
    public static void main(String[] args)
    {
        ShoppingList myList = new ShoppingList();
        myList.run();
    }

    private void run()
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> shoppingList = new ArrayList<>();

        boolean wishToExit = false;

        System.out.println("CREATE A SHOPPING LIST");
        System.out.println("You can 'add', 'print', 'remove' or 'clear' items.");
        System.out.println("When you no longer wish to change your list, type 'exit'");

        do
        {
            System.out.print("Enter a command: ");
            String commandEntered = in.nextLine();

            String words[] = commandEntered.split(" ");

            String command = words[0];
            command = command.toUpperCase();


            switch (command)
            {
                case "ADD":
                    shoppingList.add(words[1]);
                    System.out.println(shoppingList + " added to shopping list!");
                    break;
                case "PRINT":
                    printList(shoppingList);
                    break;
                case "REMOVE":
                    removeItem(words[1], shoppingList);
                    System.out.println("Index " + words[1] + " removed");
                    break;
                case "CLEAR":
                    shoppingList.clear();
                    System.out.println("List Cleared");
                    break;
                case "SORT":
                    Collections.sort(shoppingList);
                    break;
                case "FIND":
                    findItem(words[1], shoppingList);
                    break;
                case "EXIT":
                    wishToExit = true;
                    System.out.println("BYE GIRL");
                    break;

            }
        } while (!wishToExit);

    }

    private void printList(ArrayList<String> shoppingList)
    {
        int index = 0;
        for (String list : shoppingList)
        {
            System.out.println(index + ":" + list);
            index++;
        }

    }

    private void removeItem(String itemNumber, ArrayList<String> shoppingList )
    {
        int indexNumber = Integer.parseInt(itemNumber);
        shoppingList.remove(indexNumber);
    }

    private void findItem(String item, ArrayList<String> shoppingList)
    {
        boolean containsItem = shoppingList.contains(item);

        if(containsItem)
        {
            System.out.println("Found it!");
        }
        else
        {
            System.out.println("No such item!");
        }
    }
}
