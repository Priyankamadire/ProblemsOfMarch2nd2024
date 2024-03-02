public class MultipleInheritance {
    public static void main(String args[]) {
        implementingclass im = new implementingclass();
        im.CD();
        im.AB();
        im.BC();

    }
}

interface Priyanka {
    void AB();
}

interface Madire extends Priyanka {
    void BC();
}

interface MYname extends Madire {
    void CD();
}

class implementingclass implements MYname {
    public void AB() {
        System.out.println("My Father's name is Prem Kumar");
    }

    public void BC() {
        System.out.println("My Mother's name is Rajeshwari");

    }

    public void CD() {
        System.out.println("My name is Priyanka");

    }
}
