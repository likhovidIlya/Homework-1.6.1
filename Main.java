import java.util.Scanner;
import static java.lang.Integer.parseInt;

class Main {


    public static void main(String[] args) {

        Product[] products = {new Product(29, " Хлеб "), new Product(1000, " Кокос "), new Product(60, " Молоко ")};

        int[] sum = new int[]{0, 0, 0};
        int[] count = new int[]{0, 0, 0};

        int productNumber = 0;
        int productCount = 0;
        int sumProducts = 0;

        for (int i = 0; i < products.length; i++)
            System.out.println((i + 1) + ". " + products[i].name);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите товар и количество (через пробел) или введите `end` для подсчета");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println(" ");
                System.out.println("Ваша корзина:");
                System.out.println("____________________________________________________________________");
                System.out.printf("%s %9s %6s %s\n", "Наименование товара | ", "Количество | ", "Цена/за.ед | ", "Общая " +
                        "стоимость");
                System.out.println("____________________________________________________________________");

                for (int i = 0; i < 3; i++) {
                    if (count[i] != 0) {
                        System.out.printf("%s %19s %15s %14s\n", products[i].name, count[i], products[i].price,
                                sum[i]);
                    }
                    sumProducts += sum[i];
                }
                System.out.println("____________________________________________________________________");
                System.out.printf("%57s %d", "Итого: ", sumProducts);
                System.out.println(" ");
                System.out.println("Программа завершена.");
                break;
            }try {
                String[] parts = input.split(" ");
                String a = parts[0];
                productNumber = Integer.parseInt(a) - 1;
                String b = parts[1];
                productCount = Integer.parseInt(b);

                sum[productNumber] = products[productNumber].price * productCount;
                count[productNumber] = productCount;

            }
            catch (NumberFormatException e) {
                System.out.println("Введите целое число");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Введите номер товара от 1 до 3 и кол-во через пробел");
                continue;
            }
        }
        }
    }

