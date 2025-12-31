//package com.example.SPSProjectBackend.model;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//@Entity
//@Table(name = "SAUSERM")
//public class SaUser {
//
//    @Id
//    @Column(name = "USER_ID", length = 12, nullable = false)
//    private String userId;
//
//    @Column(name = "PSWRD", length = 80, nullable = false)
//    private String password;
//
//    @Column(name = "USER_NM", length = 60)
//    private String userName;
//
//    @Column(name = "USER_LEVEL", length = 10)
//    private String userLevel;
//
//    @Column(name = "STATUS", precision = 1)
//    private Integer status;
//
//    @Column(name = "EXPIRY_DT", nullable = false)
//    private Date expiryDate;
//
//    @Column(name = "JOB_TITLE", length = 60)
//    private String jobTitle;
//
//    @Column(name = "ACESS_AUTH")
//    private Short acessAuth;
//
//    @Column(name = "RPT_USER", length = 12)
//    private String rptUser;
//
//    @Column(name = "OLD_PSWRD", length = 80)
//    private String oldPswrd;
//
//    @Column(name = "PSWRD_HINT", length = 60)
//    private String pswrdHint;
//
//    @Column(name = "CHANGE_DT", nullable = false)
//    private LocalDate changeDt;
//
//    @Column(name = "VALID_PRD")
//    private Short validPrd;
//
//    @Column(name = "WARN_PRD")
//    private Short warnPrd;
//
//    @Column(name = "CHANGE_FRQ")
//    private Short changeFrq;
//
//    @Column(name = "LOGIN_PRD")
//    private Boolean loginPrd;
//
//    @Column(name = "TRXN_AUTH")
//    private Boolean trxnAuth;
//
//    @Column(name = "LOG_ID")
//    private Integer logId;
//
//    @Column(name = "LOG_STATUS")
//    private Boolean logStatus;
//
//    @Column(name = "EXP_STATUS")
//    private Boolean expStatus;
//
//    @Column(name = "ENT_BY", length = 12)
//    private String entBy;
//
//    @Column(name = "ENT_DT", nullable = false)
//    private LocalDate entDt;
//
//    @Column(name = "MODI_BY", length = 12)
//    private String modiBy;
//
//    @Column(name = "MODI_DT", nullable = false)
//    private LocalDate modiDt;
//
//    @Column(name = "CONF_BY", length = 12)
//    private String confBy;
//
//    @Column(name = "CONF_DT", nullable = false)
//    private LocalDate confDt;
//
//    @Column(name = "EPFNO", length = 15)
//    private String epfno;
//
//    @Column(name = "EMAIL", length = 100)
//    private String email;
//
//    @Column(name = "MOBILENO", length = 15)
//    private String mobileno;
//
//    public String getMobileno() {
//        return mobileno;
//    }
//
//    public void setMobileno(String mobileno) {
//        this.mobileno = mobileno;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getEpfno() {
//        return epfno;
//    }
//
//    public void setEpfno(String epfno) {
//        this.epfno = epfno;
//    }
//
//    public LocalDate getConfDt() {
//        return confDt;
//    }
//
//    public void setConfDt(LocalDate confDt) {
//        this.confDt = confDt;
//    }
//
//    public String getConfBy() {
//        return confBy;
//    }
//
//    public void setConfBy(String confBy) {
//        this.confBy = confBy;
//    }
//
//    public LocalDate getModiDt() {
//        return modiDt;
//    }
//
//    public void setModiDt(LocalDate modiDt) {
//        this.modiDt = modiDt;
//    }
//
//    public String getModiBy() {
//        return modiBy;
//    }
//
//    public void setModiBy(String modiBy) {
//        this.modiBy = modiBy;
//    }
//
//    public LocalDate getEntDt() {
//        return entDt;
//    }
//
//    public void setEntDt(LocalDate entDt) {
//        this.entDt = entDt;
//    }
//
//    public String getEntBy() {
//        return entBy;
//    }
//
//    public void setEntBy(String entBy) {
//        this.entBy = entBy;
//    }
//
//    public Boolean getExpStatus() {
//        return expStatus;
//    }
//
//    public void setExpStatus(Boolean expStatus) {
//        this.expStatus = expStatus;
//    }
//
//    public Boolean getLogStatus() {
//        return logStatus;
//    }
//
//    public void setLogStatus(Boolean logStatus) {
//        this.logStatus = logStatus;
//    }
//
//    public Integer getLogId() {
//        return logId;
//    }
//
//    public void setLogId(Integer logId) {
//        this.logId = logId;
//    }
//
//    public Boolean getTrxnAuth() {
//        return trxnAuth;
//    }
//
//    public void setTrxnAuth(Boolean trxnAuth) {
//        this.trxnAuth = trxnAuth;
//    }
//
//    public Boolean getLoginPrd() {
//        return loginPrd;
//    }
//
//    public void setLoginPrd(Boolean loginPrd) {
//        this.loginPrd = loginPrd;
//    }
//
//    public Short getChangeFrq() {
//        return changeFrq;
//    }
//
//    public void setChangeFrq(Short changeFrq) {
//        this.changeFrq = changeFrq;
//    }
//
//    public Short getWarnPrd() {
//        return warnPrd;
//    }
//
//    public void setWarnPrd(Short warnPrd) {
//        this.warnPrd = warnPrd;
//    }
//
//    public Short getValidPrd() {
//        return validPrd;
//    }
//
//    public void setValidPrd(Short validPrd) {
//        this.validPrd = validPrd;
//    }
//
//    public LocalDate getChangeDt() {
//        return changeDt;
//    }
//
//    public void setChangeDt(LocalDate changeDt) {
//        this.changeDt = changeDt;
//    }
//
//    public String getPswrdHint() {
//        return pswrdHint;
//    }
//
//    public void setPswrdHint(String pswrdHint) {
//        this.pswrdHint = pswrdHint;
//    }
//
//    public String getOldPswrd() {
//        return oldPswrd;
//    }
//
//    public void setOldPswrd(String oldPswrd) {
//        this.oldPswrd = oldPswrd;
//    }
//
//    public String getRptUser() {
//        return rptUser;
//    }
//
//    public void setRptUser(String rptUser) {
//        this.rptUser = rptUser;
//    }
//
//    public Short getAcessAuth() {
//        return acessAuth;
//    }
//
//    public void setAcessAuth(Short acessAuth) {
//        this.acessAuth = acessAuth;
//    }
//
//    public String getJobTitle() {
//        return jobTitle;
//    }
//
//    public void setJobTitle(String jobTitle) {
//        this.jobTitle = jobTitle;
//    }
//
//    // Add other fields as needed
//
//    // Getters and Setters
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserLevel() {
//        return userLevel;
//    }
//
//    public void setUserLevel(String userLevel) {
//        this.userLevel = userLevel;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public Date getExpiryDate() {
//        return expiryDate;
//    }
//
//    public void setExpiryDate(Date expiryDate) {
//        this.expiryDate = expiryDate;
//    }
//}

////NEW UPDATED CODES
//package com.example.SPSProjectBackend.model;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//@Entity
//@Table(name = "SAUSERM")
//public class SaUser {
//
//    @Id
//    @Column(name = "USER_ID", length = 12, nullable = false)
//    private String userId;
//
//    @Column(name = "PSWRD", length = 80, nullable = false)
//    private String password;
//
//    @Column(name = "USER_NM", length = 60)
//    private String userName;
//
//    @Column(name = "USER_LEVEL", length = 10)
//    private String userLevel;
//
//    @Column(name = "STATUS", precision = 1)
//    private Integer status;
//
//    @Column(name = "EXPIRY_DT", nullable = false)
//    private Date expiryDate;
//
//    @Column(name = "RPT_USER", length = 12)
//    private String rptUser;
//
//    // CHANGED: Only keeping essential fields for login to reduce complexity
//    // Removed other fields that are not needed for login functionality
//
//    // Getters and Setters
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserLevel() {
//        return userLevel;
//    }
//
//    public void setUserLevel(String userLevel) {
//        this.userLevel = userLevel;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public Date getExpiryDate() {
//        return expiryDate;
//    }
//
//    public void setExpiryDate(Date expiryDate) {
//        this.expiryDate = expiryDate;
//    }
//
//    public String getRptUser() {
//        return rptUser;
//    }
//
//    public void setRptUser(String rptUser) {
//        this.rptUser = rptUser;
//    }
//}

//NEW UPDATED CODES 2
package com.example.SPSProjectBackend.model;

import jakarta.persistence.*;

import java.util.Date; // Changed: Imported java.util.Date instead of java.time.LocalDate for consistency

@Entity
@Table(name = "SAUSERM")
public class SaUser {

    @Id
    @Column(name = "USER_ID", length = 12, nullable = false)
    private String userId;

    @Column(name = "PSWRD", length = 80, nullable = false)
    private String password;

    @Column(name = "USER_NM", length = 60)
    private String userName;

    @Column(name = "USER_LEVEL", length = 10)
    private String userLevel;

    @Column(name = "STATUS", precision = 1)
    private Integer status;

    @Column(name = "EXPIRY_DT", nullable = false)
    private Date expiryDate;

    @Column(name = "JOB_TITLE", length = 60)
    private String jobTitle;

    @Column(name = "ACESS_AUTH")
    private Short acessAuth;

    @Column(name = "RPT_USER", length = 12)
    private String rptUser;

    @Column(name = "OLD_PSWRD", length = 80)
    private String oldPswrd;

    @Column(name = "PSWRD_HINT", length = 60)
    private String pswrdHint;

    @Column(name = "CHANGE_DT", nullable = false)
    private Date changeDt; // Changed: From LocalDate to Date for consistency with database timestamp
                           // fields and other date fields like expiryDate

    @Column(name = "VALID_PRD")
    private Short validPrd;

    @Column(name = "WARN_PRD")
    private Short warnPrd;

    @Column(name = "CHANGE_FRQ")
    private Short changeFrq;

    @Column(name = "LOGIN_PRD")
    private Boolean loginPrd;

    @Column(name = "TRXN_AUTH")
    private Boolean trxnAuth;

    @Column(name = "LOG_ID")
    private Integer logId;

    @Column(name = "LOG_STATUS")
    private Boolean logStatus;

    @Column(name = "EXP_STATUS")
    private Boolean expStatus;

    @Column(name = "ENT_BY", length = 12)
    private String entBy;

    @Column(name = "ENT_DT", nullable = false)
    private Date entDt; // Changed: From LocalDate to Date for consistency with database timestamp
                        // fields

    @Column(name = "MODI_BY", length = 12)
    private String modiBy;

    @Column(name = "MODI_DT", nullable = false)
    private Date modiDt; // Changed: From LocalDate to Date for consistency with database timestamp
                         // fields

    @Column(name = "CONF_BY", length = 12)
    private String confBy;

    @Column(name = "CONF_DT", nullable = false)
    private Date confDt; // Changed: From LocalDate to Date for consistency with database timestamp
                         // fields

    @Column(name = "EPFNO", length = 15)
    private String epfno;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "MOBILENO", length = 15)
    private String mobileno;

    // Existing getters and setters (updated where necessary for date changes)
    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEpfno() {
        return epfno;
    }

    public void setEpfno(String epfno) {
        this.epfno = epfno;
    }

    public Date getConfDt() { // Changed: Return type from LocalDate to Date
        return confDt;
    }

    public void setConfDt(Date confDt) { // Changed: Parameter type from LocalDate to Date
        this.confDt = confDt;
    }

    public String getConfBy() {
        return confBy;
    }

    public void setConfBy(String confBy) {
        this.confBy = confBy;
    }

    public Date getModiDt() { // Changed: Return type from LocalDate to Date
        return modiDt;
    }

    public void setModiDt(Date modiDt) { // Changed: Parameter type from LocalDate to Date
        this.modiDt = modiDt;
    }

    public String getModiBy() {
        return modiBy;
    }

    public void setModiBy(String modiBy) {
        this.modiBy = modiBy;
    }

    public Date getEntDt() { // Changed: Return type from LocalDate to Date
        return entDt;
    }

    public void setEntDt(Date entDt) { // Changed: Parameter type from LocalDate to Date
        this.entDt = entDt;
    }

    public String getEntBy() {
        return entBy;
    }

    public void setEntBy(String entBy) {
        this.entBy = entBy;
    }

    public Boolean getExpStatus() {
        return expStatus;
    }

    public void setExpStatus(Boolean expStatus) {
        this.expStatus = expStatus;
    }

    public Boolean getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Boolean logStatus) {
        this.logStatus = logStatus;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Boolean getTrxnAuth() {
        return trxnAuth;
    }

    public void setTrxnAuth(Boolean trxnAuth) {
        this.trxnAuth = trxnAuth;
    }

    public Boolean getLoginPrd() {
        return loginPrd;
    }

    public void setLoginPrd(Boolean loginPrd) {
        this.loginPrd = loginPrd;
    }

    public Short getChangeFrq() {
        return changeFrq;
    }

    public void setChangeFrq(Short changeFrq) {
        this.changeFrq = changeFrq;
    }

    public Short getWarnPrd() {
        return warnPrd;
    }

    public void setWarnPrd(Short warnPrd) {
        this.warnPrd = warnPrd;
    }

    public Short getValidPrd() {
        return validPrd;
    }

    public void setValidPrd(Short validPrd) {
        this.validPrd = validPrd;
    }

    public Date getChangeDt() { // Changed: Return type from LocalDate to Date
        return changeDt;
    }

    public void setChangeDt(Date changeDt) { // Changed: Parameter type from LocalDate to Date
        this.changeDt = changeDt;
    }

    public String getPswrdHint() {
        return pswrdHint;
    }

    public void setPswrdHint(String pswrdHint) {
        this.pswrdHint = pswrdHint;
    }

    public String getOldPswrd() {
        return oldPswrd;
    }

    public void setOldPswrd(String oldPswrd) {
        this.oldPswrd = oldPswrd;
    }

    public String getRptUser() {
        return rptUser;
    }

    public void setRptUser(String rptUser) {
        this.rptUser = rptUser;
    }

    public Short getAcessAuth() {
        return acessAuth;
    }

    public void setAcessAuth(Short acessAuth) {
        this.acessAuth = acessAuth;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}