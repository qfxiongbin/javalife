package brian.annotations;

public class Test {

    @UserCase(id=1,desc="测试")
    public String test(){
        return "";
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }
}
