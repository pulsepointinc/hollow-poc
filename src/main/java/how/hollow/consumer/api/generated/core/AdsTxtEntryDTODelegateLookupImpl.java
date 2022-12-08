package how.hollow.consumer.api.generated.core;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.schema.HollowObjectSchema;

@SuppressWarnings("all")
public class AdsTxtEntryDTODelegateLookupImpl extends HollowObjectAbstractDelegate implements AdsTxtEntryDTODelegate {

    private final AdsTxtEntryDTOTypeAPI typeAPI;

    public AdsTxtEntryDTODelegateLookupImpl(AdsTxtEntryDTOTypeAPI typeAPI) {
        this.typeAPI = typeAPI;
    }

    public String getDomain(int ordinal) {
        ordinal = typeAPI.getDomainOrdinal(ordinal);
        return ordinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(ordinal);
    }

    public boolean isDomainEqual(int ordinal, String testValue) {
        ordinal = typeAPI.getDomainOrdinal(ordinal);
        return ordinal == -1 ? testValue == null : typeAPI.getAPI().getStringTypeAPI().isValueEqual(ordinal, testValue);
    }

    public int getDomainOrdinal(int ordinal) {
        return typeAPI.getDomainOrdinal(ordinal);
    }

    public String getAccountId(int ordinal) {
        ordinal = typeAPI.getAccountIdOrdinal(ordinal);
        return ordinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(ordinal);
    }

    public boolean isAccountIdEqual(int ordinal, String testValue) {
        ordinal = typeAPI.getAccountIdOrdinal(ordinal);
        return ordinal == -1 ? testValue == null : typeAPI.getAPI().getStringTypeAPI().isValueEqual(ordinal, testValue);
    }

    public int getAccountIdOrdinal(int ordinal) {
        return typeAPI.getAccountIdOrdinal(ordinal);
    }

    public String getAccountType(int ordinal) {
        ordinal = typeAPI.getAccountTypeOrdinal(ordinal);
        return ordinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(ordinal);
    }

    public boolean isAccountTypeEqual(int ordinal, String testValue) {
        ordinal = typeAPI.getAccountTypeOrdinal(ordinal);
        return ordinal == -1 ? testValue == null : typeAPI.getAPI().getStringTypeAPI().isValueEqual(ordinal, testValue);
    }

    public int getAccountTypeOrdinal(int ordinal) {
        return typeAPI.getAccountTypeOrdinal(ordinal);
    }

    public AdsTxtEntryDTOTypeAPI getTypeAPI() {
        return typeAPI;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

}