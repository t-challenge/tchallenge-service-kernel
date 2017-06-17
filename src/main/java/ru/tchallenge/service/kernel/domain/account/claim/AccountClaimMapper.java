package ru.tchallenge.service.kernel.domain.account.claim;

import ru.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tchallenge.service.kernel.domain.account.AccountInvoice;

public interface AccountClaimMapper {

    AccountClaimInfo info(AccountInfo account);

    AccountInvoice accountInvoice(AccountClaimInvoice claimInvoice);
}
