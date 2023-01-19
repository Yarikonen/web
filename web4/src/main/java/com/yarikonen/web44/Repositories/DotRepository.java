package com.yarikonen.web44.Repositories;

import com.yarikonen.web44.Data.Dot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotRepository extends JpaRepository<Dot,Long> {
}
