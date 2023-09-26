package com.afrid.bank.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditaware")
public class AuditAwareImpl implements AuditorAware {
    /**
     * @return
     */
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("ACCOUNT_MS");
    }
}
