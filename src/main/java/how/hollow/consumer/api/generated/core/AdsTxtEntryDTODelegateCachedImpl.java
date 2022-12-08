package how.hollow.consumer.api.generated.core;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.schema.HollowObjectSchema;
import com.netflix.hollow.api.custom.HollowTypeAPI;
import com.netflix.hollow.api.objects.delegate.HollowCachedDelegate;

@SuppressWarnings("all")
public class AdsTxtEntryDTODelegateCachedImpl extends HollowObjectAbstractDelegate implements HollowCachedDelegate, AdsTxtEntryDTODelegate {

    private final String domain;
    private final int domainOrdinal;
    private final String accountId;
    private final int accountIdOrdinal;
    private final String accountType;
    private final int accountTypeOrdinal;
    private AdsTxtEntryDTOTypeAPI typeAPI;

    public AdsTxtEntryDTODelegateCachedImpl(AdsTxtEntryDTOTypeAPI typeAPI, int ordinal) {
        this.domainOrdinal = typeAPI.getDomainOrdinal(ordinal);
        int domainTempOrdinal = domainOrdinal;
        this.domain = domainTempOrdinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(domainTempOrdinal);
        this.accountIdOrdinal = typeAPI.getAccountIdOrdinal(ordinal);
        int accountIdTempOrdinal = accountIdOrdinal;
        this.accountId = accountIdTempOrdinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(accountIdTempOrdinal);
        this.accountTypeOrdinal = typeAPI.getAccountTypeOrdinal(ordinal);
        int accountTypeTempOrdinal = accountTypeOrdinal;
        this.accountType = accountTypeTempOrdinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(accountTypeTempOrdinal);
        this.typeAPI = typeAPI;
    }

    public String getDomain(int ordinal) {
        return domain;
    }

    public boolean isDomainEqual(int ordinal, String testValue) {
        if(testValue == null)
            return domain == null;
        return testValue.equals(domain);
    }

    public int getDomainOrdinal(int ordinal) {
        return domainOrdinal;
    }

    public String getAccountId(int ordinal) {
        return accountId;
    }

    public boolean isAccountIdEqual(int ordinal, String testValue) {
        if(testValue == null)
            return accountId == null;
        return testValue.equals(accountId);
    }

    public int getAccountIdOrdinal(int ordinal) {
        return accountIdOrdinal;
    }

    public String getAccountType(int ordinal) {
        return accountType;
    }

    public boolean isAccountTypeEqual(int ordinal, String testValue) {
        if(testValue == null)
            return accountType == null;
        return testValue.equals(accountType);
    }

    public int getAccountTypeOrdinal(int ordinal) {
        return accountTypeOrdinal;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

    public AdsTxtEntryDTOTypeAPI getTypeAPI() {
        return typeAPI;
    }

    public void updateTypeAPI(HollowTypeAPI typeAPI) {
        this.typeAPI = (AdsTxtEntryDTOTypeAPI) typeAPI;
    }

}