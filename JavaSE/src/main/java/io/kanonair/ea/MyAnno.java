package io.kanonair.ea;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {FIELD, METHOD, TYPE})
@Repeatable(MyAnnos.class)
@Inherited
public @interface MyAnno {
    String value() default "1";
}
