package yte.intern.alertSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.alertSystem.model.Alert;

public interface AlertRepository extends JpaRepository<Alert,Long> {

    void deleteById(Long id);

    Alert getById(Long id);
}
