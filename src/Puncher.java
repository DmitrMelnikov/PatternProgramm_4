public class Puncher extends Product implements Instrument, Device{


    //Interface Segregation Principle - применяем разные интерфейсы вместо одного большого
    //Dependency Inversion Principle - разделив интерфейсы мы не зависим от их общей функциональности

    @Override
    public String electric() {
        return "работает от 220В";
    }

    @Override
    public String build() {
        return "долбит поверхности";
    }
}
