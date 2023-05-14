package www.butle.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import www.butle.models.Account;

public interface AccountRepo extends JpaRepository<Account,Long> {
    public Account findAccountById(Long id);

}
