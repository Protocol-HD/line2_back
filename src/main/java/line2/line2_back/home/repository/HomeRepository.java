package line2.line2_back.home.repository;

import line2.line2_back.home.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home, Long> {
    List<Home> findByHomeAddressContaining(String homeAddress);
}
