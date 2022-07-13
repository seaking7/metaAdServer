package dev.practice.ad.infrastructure.app;

import dev.practice.ad.domain.ad.AdRequest;
import dev.practice.ad.domain.app.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppRepository extends JpaRepository<App, Long> {

}
