package sv.com.webster.gestionusuarios04.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import sv.com.webster.gestionusuarios04.model.User;

public interface UserRepository extends ListCrudRepository<User, Integer>, ListPagingAndSortingRepository<User, Integer>, QueryByExampleExecutor<User> {

}
