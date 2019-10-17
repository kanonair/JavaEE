package io.kanonair.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
//@Repository
@Component
//@Controller
//@Service
//@Scope("singleton")
public class Book {
    private String no;
    private String name;
}
