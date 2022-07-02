package dev.practice.ad.infrastructure.item.optiongroup;

import dev.practice.ad.domain.item.optiongroup.ItemOptionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOptionGroupRepository extends JpaRepository<ItemOptionGroup, Long> {
}
