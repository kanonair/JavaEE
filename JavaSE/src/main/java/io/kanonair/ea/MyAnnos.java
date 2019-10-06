package io.kanonair.ea;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {FIELD, METHOD, TYPE})
@Inherited
public @interface MyAnnos {
    MyAnno[] value();
}
