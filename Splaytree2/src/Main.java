import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SplayTree splayTree = new SplayTree();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do{
            System.out.println("\n---MENU---");
            System.out.println("1.Insert");
            System.out.println("2.Remove");
            System.out.println("3.Search");
            System.out.println("4.In-order");
            System.out.println("5.Pre-order");
            System.out.println("6.Post-order");
            System.out.println("0.Exit");
            opcao= scanner.nextInt();
            switch(opcao){
                case 1:
                    int value;
                    System.out.println("Type the value(int): ");
                    value= scanner.nextInt();
                    splayTree.insertValue(value);
                    break;
                case 2:
                    int value2;
                    System.out.println("Type the value(int): ");
                    value2= scanner.nextInt();
                    splayTree.removeValue(value2);
                    break;
                case 3:
                    int value3;
                    System.out.println("Type the value(int): ");
                    value3= scanner.nextInt();
                    splayTree.search(value3);
                    break;
                case 4:
                    splayTree.printInOrder();
                    break;
                case 5:
                    splayTree.printpreOrder();
                    break;
                case 6:
                    splayTree.printpostOrder();
                    break;
                case 0:
                    System.out.println("End");
                    break;
                default:
                    System.out.println("Invalid");
            }
        }while(opcao!=0);
    }
}
