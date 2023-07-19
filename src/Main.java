import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Liskov substitution principle - наследники класса Product полностью играют роль предка
        Product[] productsStock = {new Board().setName("Деревянный щит 2Х2 метра").setPrice(1500),
                                   new Нammer().setName("Молоток").setPrice(700),
                                   new Puncher().setName("Перфоратор").setPrice(7500)};
        Product[] prodBasket = {new Board(),new Нammer(), new Puncher()};

         //принцип DRY - повторяющийся вывод списка продуктов делю логически на разные операции
        printProducts(productsStock, "Список товаров для оприходования: ");
        Scanner scanner = new Scanner(System.in);
        // Добавим товар на склад
        while (true) {
            System.out.println("Введите номер товара и количество или введите end ");
            String input = scanner.nextLine();
            if ("end".equals(input)) break;
            String[] parts = input.split(" ");
            int numProd = Integer.parseInt(parts[0]) - 1;
            productsStock[numProd].setCount(Integer.parseInt(parts[1]));
        }
        printProducts(productsStock, "Список товаров для покупки: ");
        // Заполняем свою покупательскую корзину
        while (true) {
            System.out.println("Введите номер товара и количество или введите end ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
                String[] parts = input.split(" ");
                int numProd = Integer.parseInt(parts[0]) - 1;
                prodBasket[numProd].setName(productsStock[numProd].getName());
                prodBasket[numProd].setPrice(productsStock[numProd].getPrice());
                prodBasket[numProd].setCount(Integer.parseInt(parts[1]));
                productsStock[numProd].setCount(-Integer.parseInt(parts[1]));

        }

        printBasketStock(productsStock, "Ваш склад: ");
        printBasketStock(prodBasket, "Ваша корзина: ");

        printProducts(prodBasket, "Список товаров для возврата: ");

        // Организуем возврат из потребительской корзины
        while (true) {
            System.out.println("Введите номер товара и количество или введите end ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            int numProd = Integer.parseInt(parts[0]) - 1;
            prodBasket[numProd].setCount(-Integer.parseInt(parts[1]));
            productsStock[numProd].setCount(Integer.parseInt(parts[1]));

        }

        printBasketStock(productsStock, "Ваш склад: ");
        printBasketStock(prodBasket, "Ваша корзина: ");
    }

    private static void printProducts(Product[] products, String info) {
        System.out.println(info);
        for (int i = 0; i < products.length; i++) {// не использую в цикле числа профилактика магических цифр
            if (products[i].getName() != null) {
                System.out.println(String.valueOf(i+1)+". "+products[i] + " количество= " + products[i].getCount() + " шт."
                        + " цена= " + products[i].getPrice());
            }
        }
    }

    private static void printBasketStock(Product[] products, String info) {
        int costProducts = 0;
        System.out.println(info);
        int i=0;
        for (Product product : products) {
            if (product.getCount() != 0) {
                costProducts += product.getCount() * product.getPrice();
                System.out.println(String.valueOf(i+1)+". "+product + " количество= " + product.getCount() + " шт."
                        + " цена= " + product.getPrice()
                        + " стоимость= " + product.getCount() * product.getPrice());
                i++;
            }
        }
        System.out.println("Итого: " + costProducts);
    }
}
