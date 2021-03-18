import javax.annotation.Generated;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resources;
import java.lang.annotation.*;

@MyService
public class Test {

    public static void main(String[] args) {
       Class<UserService> classz= UserService.class;
       getAnnos(classz);
    }



    private static void getAnnos(Class<?> classz){
        Annotation[] annotations = classz.getAnnotations();
        for (Annotation annotation : annotations) {

                System.out.println(annotation.annotationType().toString());
                if (annotation.annotationType() == MyComonent.class){
                    System.out.println(" 存在注解 @MyComponent ");
                }else{
                    System.out.println("没有");
                    getAnnos(annotation.annotationType());
                }

        }
    }


}
