package ma.fsm.billingservice.web;

import ma.fsm.billingservice.entities.Bill;
import ma.fsm.billingservice.entities.billing;
import ma.fsm.billingservice.feign.CustomerRestClient;
import ma.fsm.billingservice.feign.ProductItemRestClient;
import ma.fsm.billingservice.model.Customer;
import ma.fsm.billingservice.model.Product;
import ma.fsm.billingservice.repository.BillRepository;
import ma.fsm.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;
    private double prix =0;
    private double quantite=0;
    private String name;
    private billing bi;
    private List<billing> billingList;
    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }


    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill=billRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi->{
            Product product=productItemRestClient.getProductById(pi.getProductID());
            //pi.setProduct(product);
            pi.setProductName(product.getName());
        });
        return bill;

    }
    @GetMapping(path="/fullBill")
    public billing getBills(){
        Bill bill=billRepository.findById(3L).get();
        Customer customer=customerRestClient.getCustomerById(bill.getCustomerID());
        bill.getProductItems().forEach(p->{
        Product product=productItemRestClient.getProductById(p.getProductID());
         prix = prix + product.getPrice();
         quantite=quantite+product.getQuality();
         name=customer.getName();
         bi=new billing(bill.getId(),name,quantite,prix);

    });

        return bi;

    }
}



