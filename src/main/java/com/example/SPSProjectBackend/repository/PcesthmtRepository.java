package com.example.SPSProjectBackend.repository;

import com.example.SPSProjectBackend.dto.CommissionDTO;
import com.example.SPSProjectBackend.model.Pcesthmt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PcesthmtRepository extends JpaRepository<Pcesthmt, String> {

    @Query("SELECT p.id.estimateNo FROM Pcesthmt p")
    List<String> findAllEstimateNumbers();

    @Query(value = "SELECT TO_CHAR(ETIMATE_DT, 'YYYY-MM-DD') AS ETIMATE_DT, " +
            "TO_CHAR(PRJ_ASS_DT, 'YYYY-MM-DD') AS PRJ_ASS_DT " +
            "FROM SPSNEW.PCESTHMT " +
            "WHERE ESTIMATE_NO = :estimateNo",
            nativeQuery = true)
    Object[] findEstimateAndProjectDates(@Param("estimateNo") String estimateNo);

//    // Add this method to your existing repository
//    @Query(value =
//            "SELECT " +
//                    "p.PROJECT_NO AS projectNo, " +
//                    "p.ESTIMATE_NO AS estimateNo, " +
//                    "p.STD_COST AS totalCost, " +
//                    "p.DEPT_ID AS deptId, " +
//                    "p.DESCR AS description, " +
//                    "p.STATUS AS status " +
//                    "FROM PCESTHMT p " +
//                    "WHERE p.STATUS = 4 " +
//                    "ORDER BY p.ESTIMATE_NO, p.DEPT_ID",
//            nativeQuery = true)
//    List<CommissionDTO> findCommissionDetails();
//
//    //this is updated fetching data which is status=4 and also check login USER_ID get as paramter and
//    //support filter data according to logging users DEPT_ID
//    @Query(value =
//            "SELECT " +
//                    "p.PROJECT_NO AS projectNo, " +
//                    "p.ESTIMATE_NO AS estimateNo, " +
//                    "p.STD_COST AS totalCost, " +
//                    "p.DEPT_ID AS deptId, " +
//                    "p.DESCR AS description, " +
//                    "p.STATUS AS status " +
//                    "FROM PCESTHMT p " +
//                    "WHERE p.STATUS = 4 " +
//                    "AND p.DEPT_ID IN (" +
//                    "    SELECT s.DEPT_ID " +
//                    "    FROM SAUSRDPM s " +
//                    "    WHERE RTRIM(s.USER_ID) = :userId" +
//                    ")" +
//                    "ORDER BY p.ESTIMATE_NO, p.DEPT_ID",
//            nativeQuery = true)
//    List<CommissionDTO> findCommissionDetailsByUserId(@Param("userId") String userId);
//
//
//    //this is for get editing related data which have STATUS=10
//    @Query(value =
//            "SELECT " +
//                    "p.PROJECT_NO AS projectNo, " +
//                    "p.ESTIMATE_NO AS estimateNo, " +
//                    "p.STD_COST AS totalCost, " +
//                    "p.DEPT_ID AS deptId, " +
//                    "p.DESCR AS description, " +
//                    "p.STATUS AS status " +
//                    "FROM PCESTHMT p " +
//                    "WHERE p.STATUS = 10 " +
//                    "ORDER BY p.ESTIMATE_NO, p.DEPT_ID",
//            nativeQuery = true)
//    List<CommissionDTO> findEditCommissionDetails();
//
//
//    //this is for get editing related data which have STATUS=11
//    @Query(value =
//            "SELECT " +
//                    "p.PROJECT_NO AS projectNo, " +
//                    "p.ESTIMATE_NO AS estimateNo, " +
//                    "p.STD_COST AS totalCost, " +
//                    "p.DEPT_ID AS deptId, " +
//                    "p.DESCR AS description, " +
//                    "p.STATUS AS status " +
//                    "FROM PCESTHMT p " +
//                    "WHERE p.STATUS = 11 " +
//                    "ORDER BY p.ESTIMATE_NO, p.DEPT_ID",
//            nativeQuery = true)
//    List<CommissionDTO> findValidateCommissionDetails();


    // Unified repository method that accepts both userId and status as parameters
    // This replaces multiple methods (findCommissionDetailsByUserId, findEditCommissionDetails, findValidateCommissionDetails)
    // with a single flexible method
    @Query(value =
            "SELECT " +
                    "p.PROJECT_NO AS projectNo, " +
                    "p.ESTIMATE_NO AS estimateNo, " +
                    "p.STD_COST AS totalCost, " +
                    "p.DEPT_ID AS deptId, " +
                    "p.DESCR AS description, " +
                    "p.STATUS AS status " +
                    "FROM PCESTHMT p " +
                    "WHERE p.STATUS = :status " +  // Dynamic status parameter
                    "AND p.DEPT_ID IN (" +
                    "    SELECT s.DEPT_ID " +
                    "    FROM SAUSRDPM s " +
                    "    WHERE RTRIM(s.USER_ID) = :userId" +
                    ")" +
                    "ORDER BY p.ESTIMATE_NO, p.DEPT_ID",
            nativeQuery = true)
    List<CommissionDTO> findCommissionDetailsByUserIdAndStatus(
            @Param("userId") String userId,
            @Param("status") Integer status);

    @Query("SELECT DISTINCT CAST(p.id.deptId AS string) FROM Pcesthmt p WHERE p.id.estimateNo = :estimateNo")
    List<String> findDeptIdsByEstimateNo(@Param("estimateNo") String estimateNo);

    // NEW CODE - Added method to update status by estimateNo and deptId
    @Modifying
    @Query("UPDATE Pcesthmt p SET p.status = :status WHERE p.id.estimateNo = :estimateNo AND p.id.deptId = :deptId")
    void updateStatusByEstimateNoAndDeptId(@Param("estimateNo") String estimateNo,
                                           @Param("deptId") String deptId,
                                           @Param("status") Short status);
}