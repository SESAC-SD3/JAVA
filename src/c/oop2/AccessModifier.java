package c.oop2;

public class AccessModifier {
    public static void main(String[] args) {
        PrivateClass pc = new PrivateClass(10);
        pc.resetValue();
        System.out.println(pc.getValue());

        // private
        //pc.value = 100;
        // public
        pc.value2 = "test msg";
    }
}
