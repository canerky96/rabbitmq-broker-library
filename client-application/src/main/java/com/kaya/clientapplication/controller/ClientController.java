package com.kaya.clientapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.model.Category;
import product.model.Product;
import product.service.ProductProducerService;

import java.util.Arrays;

@RequestMapping
@RestController
public class ClientController {

  @Autowired ProductProducerService producerService;

  @GetMapping
  public String send() {

    Product product =
        new Product("Elma", 5, Arrays.asList(new Category("Yiyecek"), new Category("Meyve")));

    producerService.send(product);
    return "Message sent";
  }
}
