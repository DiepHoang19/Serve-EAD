package com.example.serveead.seeder;


import com.example.serveead.entity.Sale;
import com.example.serveead.repository.SaleRepository;
import com.example.serveead.util.NumberHelper;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SaleSeeder {
    private static final int NUMBER_OF_SALES = 100;
    public static List<Sale> saleList = new ArrayList<>();
    final SaleRepository saleRepository;

    public void generate() {
        Faker faker = new Faker();
        int maxIndexOfProducts = ProductSeeder.productList.size() - 1;
        int minIndexOfProducts = 0;
        for (int i = 0; i < NUMBER_OF_SALES; i++
        ) {
            Sale product = Sale.builder()
                    .saleName(faker.name().fullName())
                    .dOS(faker.cat().name())
                    .salesmanId(UUID.randomUUID().toString())
                    .product(ProductSeeder.productList.get(NumberHelper.generateRandom(minIndexOfProducts, maxIndexOfProducts)))
                    .build();
            saleList.add(product);
        }
        saleRepository.saveAll(saleList);
    }
}
