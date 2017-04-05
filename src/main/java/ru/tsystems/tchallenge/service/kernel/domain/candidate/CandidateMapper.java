package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountMapper;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CandidateMapper extends GenericMapper {

    @Autowired
    private AccountMapper accountMapper;

    public CandidateInfo candidateInfo(Candidate candidate) {
        CandidateInfo candidateInfo = new CandidateInfo();
        candidateInfo.setAccount(accountInfo(candidate.getAccount()));
        candidateInfo.setFirstname(candidate.getFirstname());
        candidateInfo.setLastname(candidate.getLastname());
        return candidateInfo;
    }

    private AccountInfo accountInfo(Account account) {
        return accountMapper.accountInfo(account);
    }
}
