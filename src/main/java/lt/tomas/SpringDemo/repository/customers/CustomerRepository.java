package lt.tomas.SpringDemo.repository.customers;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer,Integer> {
}
