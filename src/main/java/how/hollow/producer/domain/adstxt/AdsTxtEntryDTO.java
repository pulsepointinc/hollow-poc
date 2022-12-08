package how.hollow.producer.domain.adstxt;

import com.netflix.hollow.core.write.objectmapper.HollowHashKey;
import com.netflix.hollow.core.write.objectmapper.HollowPrimaryKey;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO class for <em>adstxt_crawler_entries_data</em> and <em>appadstxt_crawler_entries_data</em> datasets
 */
public class AdsTxtEntryDTO {

    private String domain;
    private String accountId;
    private String accountType;

    public AdsTxtEntryDTO() {
    }

    public AdsTxtEntryDTO(String domain, String accountId, String accountType) {
        this.domain = domain;
        this.accountId = accountId;
        this.accountType = accountType;
    }

    public String getDomain() {
        return domain;
    }

    public AdsTxtEntryDTO setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public AdsTxtEntryDTO setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public AdsTxtEntryDTO setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AdsTxtEntryDTO that = (AdsTxtEntryDTO) o;

        return Objects.equals(domain, that.domain)
                && Objects.equals(accountId, that.accountId)
                && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain, accountId, accountType);
    }
}
