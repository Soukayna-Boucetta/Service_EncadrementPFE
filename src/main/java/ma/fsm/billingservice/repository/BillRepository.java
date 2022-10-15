package ma.fsm.billingservice.repository;

import ma.fsm.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {
}
