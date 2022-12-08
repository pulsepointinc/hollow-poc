package how.hollow.consumer.api.generated.core;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.DomainSetsApi;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.custom.HollowObjectTypeAPI;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;

@SuppressWarnings("all")
public class AdsTxtEntryDTOTypeAPI extends HollowObjectTypeAPI {

    private final AdsTxtEntryDTODelegateLookupImpl delegateLookupImpl;

    public AdsTxtEntryDTOTypeAPI(DomainSetsApi api, HollowObjectTypeDataAccess typeDataAccess) {
        super(api, typeDataAccess, new String[] {
            "domain",
            "accountId",
            "accountType"
        });
        this.delegateLookupImpl = new AdsTxtEntryDTODelegateLookupImpl(this);
    }

    public int getDomainOrdinal(int ordinal) {
        if(fieldIndex[0] == -1)
            return missingDataHandler().handleReferencedOrdinal("AdsTxtEntryDTO", ordinal, "domain");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[0]);
    }

    public StringTypeAPI getDomainTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public int getAccountIdOrdinal(int ordinal) {
        if(fieldIndex[1] == -1)
            return missingDataHandler().handleReferencedOrdinal("AdsTxtEntryDTO", ordinal, "accountId");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[1]);
    }

    public StringTypeAPI getAccountIdTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public int getAccountTypeOrdinal(int ordinal) {
        if(fieldIndex[2] == -1)
            return missingDataHandler().handleReferencedOrdinal("AdsTxtEntryDTO", ordinal, "accountType");
        return getTypeDataAccess().readOrdinal(ordinal, fieldIndex[2]);
    }

    public StringTypeAPI getAccountTypeTypeAPI() {
        return getAPI().getStringTypeAPI();
    }

    public AdsTxtEntryDTODelegateLookupImpl getDelegateLookupImpl() {
        return delegateLookupImpl;
    }

    @Override
    public DomainSetsApi getAPI() {
        return (DomainSetsApi) api;
    }

}