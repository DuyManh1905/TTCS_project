package com.project.Shop.repository;

import com.project.Shop.entity.BillReturn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<BillReturn, Long> {
}
