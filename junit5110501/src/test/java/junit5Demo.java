import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class junit5Demo {


   @Test
   public  void  addErrorTest()
    {
        int result1 =Add.addNum(1,2);
        System.out.println("result1:"+result1);
        Assertions.assertEquals(result1,4,"加法错误");
    }


    @Test
    public void  addSuccessTest()
    {
        int result2=Add.addNum(1,1);
        System.out.println("result2:"+result2);
        Assertions.assertEquals(result2,2,"加法正确");
    }

//    @Test
//    public  void addErrorAndSuccessTest()
//    {
//        int result1 =Add.addNum(1,2);
//        int result2 =Add.addNum(1,1);
//
//       Assertions.assertAll(("计算结果："),
//               ()-> Assertions.assertEquals(result1,3,"加法错误"),
//               ()-> Assertions.assertEquals(result2,1,"加法正确")
//               );
//    }
}
