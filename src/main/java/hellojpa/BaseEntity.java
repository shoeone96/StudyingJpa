package hellojpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "INSERT_MEMBER")
    private String cretedBy;
    private LocalDateTime createdDate;
    @Column(name = "UPDATE_MEMBER")
    private String modifiedBy;
    private LocalDateTime lastModifiedDate;

    public String getCretedBy() {
        return cretedBy;
    }

    public void setCretedBy(String cretedBy) {
        this.cretedBy = cretedBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
