package com.example.SPSProjectBackend.repository;

import com.example.SPSProjectBackend.model.Pcesthtt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SPSProjectBackend.model.PcesthttId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcesthttRepository extends JpaRepository<Pcesthtt, String> {

    @Query("SELECT p.status AS status, COUNT(p) AS totalRows " +
            "FROM Pcesthtt p " +
            "GROUP BY p.status")
    List<Object[]> getRowCountByStatus();
}

public interface PcesthttRepository extends JpaRepository<Pcesthtt, PcesthttId> {

    // ✅ Trim CHAR spaces for Oracle
    @Query("SELECT h FROM Pcesthtt h WHERE TRIM(h.id.estimateNo) = :estimateNo")
    List<Pcesthtt> findByEstimateNo(@Param("estimateNo") String estimateNo);
}
