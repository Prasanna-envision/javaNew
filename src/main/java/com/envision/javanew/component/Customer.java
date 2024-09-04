package com.envision.javanew.component;

import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String name;

    private String email;
    private List<String> phoneNumbers;
}
