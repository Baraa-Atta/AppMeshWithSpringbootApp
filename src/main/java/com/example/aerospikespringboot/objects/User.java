package com.example.aerospikespringboot.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Document
@AllArgsConstructor
public class User {

    @Id
    private Integer id;
    private String name;
    private String email;
    private int age;
}
