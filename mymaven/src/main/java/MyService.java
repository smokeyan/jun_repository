import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@MyComonent
@Documented
@Inherited
public @interface MyService {
}
