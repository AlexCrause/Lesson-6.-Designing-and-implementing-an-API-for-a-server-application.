package com.example.personalnotetaking.repository;

import com.example.personalnotetaking.model.Remark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemarkRepo extends JpaRepository<Remark, Long> {
}
