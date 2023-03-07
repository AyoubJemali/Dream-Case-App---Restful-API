package org.sid.bankaccountservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String caseId;


    private LocalDateTime creationDate;


    private LocalDateTime lastUpdateDate;

    private String title;

    private String description;
}
