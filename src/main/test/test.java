import org.junit.Test;

public class test {

    @Test
    public void test1(){
        String s="2018-12-02";
        String[] split = s.split("-");
        for (String s1 : split) {
            System.out.println(s1);
            int i = Integer.parseInt(s1);
            System.out.println(i);
        }

    }


}
