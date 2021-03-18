import java.lang.annotation.Annotation;

public class Test2 extends  Test{

    private Annotation anno;

    public static void main(String[] args) {
        Class test2=Test2.class;
        Annotation[] annos=test2.getAnnotations();
        System.out.println(annos.length);
        for (Annotation anno : annos) {
            System.out.println(anno.annotationType().toString());
        }
    }
}
