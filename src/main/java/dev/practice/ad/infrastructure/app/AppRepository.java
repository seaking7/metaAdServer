package dev.practice.ad.infrastructure.app;

import dev.practice.ad.domain.app.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {

}
