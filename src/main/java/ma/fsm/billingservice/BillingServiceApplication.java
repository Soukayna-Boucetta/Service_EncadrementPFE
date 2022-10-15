package ma.fsm.billingservice;

import ma.fsm.billingservice.entities.Bill;
import ma.fsm.billingservice.entities.ProductItem;
import ma.fsm.billingservice.feign.CustomerRestClient;
import ma.fsm.billingservice.feign.ProductItemRestClient;
import ma.fsm.billingservice.model.Customer;
import ma.fsm.billingservice.model.Product;
import ma.fsm.billingservice.repository.BillRepository;
import ma.fsm.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductItemRestClient productItemRestClient){
        return  args -> {

            Customer customer=customerRestClient.getCustomerById(1L);
            Customer customer1=customerRestClient.getCustomerById(2L);
            Bill bill1=billRepository.save(new Bill(null,new Date(),null,customer.getId(),null));
            PagedModel<Product> productPagedModel=productItemRestClient.pageProducts();
            productPagedModel.forEach(p->{
                ProductItem productItem=new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setBill(bill1);
                productItem.setProductID(p.getId());
                productItemRepository.save(productItem);

            });
            Bill bill2=billRepository.save(new Bill(null,new Date(),null,customer1.getId(),null));
            PagedModel<Product> productPagedModel1=productItemRestClient.pageProducts();
            productPagedModel1.forEach(p->{
                ProductItem productItem=new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setBill(bill2);
                productItem.setProductID(p.getId());
                productItemRepository.save(productItem);

            });

        };

    }

}
