package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private  BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


    @GetMapping("cases")
    public List<BankAccount> lists(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("cases/{caseId}")
    public BankAccount getCaseById(@PathVariable String caseId){
        return bankAccountRepository.findById(caseId)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found",caseId)));
    }
    @PostMapping("/cases")
    public BankAccount save(@RequestBody BankAccount caseDetails){
        if(caseDetails.getCaseId()==null) caseDetails.setCaseId(UUID.randomUUID().toString());
        caseDetails.setCreationDate(LocalDateTime.now());
        caseDetails.setLastUpdateDate(LocalDateTime.now());
        return bankAccountRepository.save(caseDetails);
    }

    @PutMapping("/cases/{caseId}")
    public BankAccount update(@PathVariable String caseId, @RequestBody BankAccount caseDetails){

        BankAccount caseToUpdate = bankAccountRepository.findById(caseId)
                .orElseThrow(() -> new RuntimeException(String.format("Case %s not found",caseId)));
        caseToUpdate.setTitle(caseDetails.getTitle());
        caseToUpdate.setDescription(caseDetails.getDescription());
        caseToUpdate.setLastUpdateDate(LocalDateTime.now());
        return bankAccountRepository.save(caseToUpdate);

    }
    @DeleteMapping("/cases/{caseId}")
    public void deleteAccount(@PathVariable String caseId){
        bankAccountRepository.deleteById(caseId);
    }
}
