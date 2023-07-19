public class Нammer extends Product implements Instrument{
    //Open Closed Principle - имплементируя интерфейс Instrument  мы добавляем
    // классу функциональности, не изменяя его код

     //Single Responsibility Principle - класс Нammer описывает только молоток, а не все инструменты

    @Override
    public String build() {
        return "умеет забивать гвозди";
    }
}
