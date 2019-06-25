package com.toycompany.demo.Model.Repository;

import com.toycompany.demo.Model.Toy;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ToyRepository {

    private List<Toy> toys = Arrays.asList();
}
