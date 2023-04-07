package lt.tomas.SpringDemo.repository.customers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository <Customer,Integer> {
    Optional<Customer> findByCustomerNumber(int id);
    // SELECT * FROM customers WHERE

    Iterable<Customer> findByCustomerNameLike(String name);

    @Query(value = "SELECT * FROM customers WHERE customerName LIKE :name", nativeQuery = true)
    List<Customer> getCustomerQueryByNameLike(@Param("name") String customerName);
}
