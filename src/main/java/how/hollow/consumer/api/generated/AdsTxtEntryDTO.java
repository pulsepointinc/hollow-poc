package how.hollow.consumer.api.generated;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.DomainSetsApi;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.objects.HollowObject;
import com.netflix.hollow.core.schema.HollowObjectSchema;
import com.netflix.hollow.tools.stringifier.HollowRecordStringifier;

@SuppressWarnings("all")
public class AdsTxtEntryDTO extends HollowObject {

    public AdsTxtEntryDTO(AdsTxtEntryDTODelegate delegate, int ordinal) {
        super(delegate, ordinal);
    }

    public String getDomain() {
        return delegate().getDomain(ordinal);
    }

    public boolean isDomainEqual(String testValue) {
        return delegate().isDomainEqual(ordinal, testValue);
    }

    public HString getDomainHollowReference() {
        int refOrdinal = delegate().getDomainOrdinal(ordinal);
        if(refOrdinal == -1)
            return null;
        return  api().getHString(refOrdinal);
    }

    public String getAccountId() {
        return delegate().getAccountId(ordinal);
    }

    public boolean isAccountIdEqual(String testValue) {
        return delegate().isAccountIdEqual(ordinal, testValue);
    }

    public HString getAccountIdHollowReference() {
        int refOrdinal = delegate().getAccountIdOrdinal(ordinal);
        if(refOrdinal == -1)
            return null;
        return  api().getHString(refOrdinal);
    }

    public String getAccountType() {
        return delegate().getAccountType(ordinal);
    }

    public boolean isAccountTypeEqual(String testValue) {
        return delegate().isAccountTypeEqual(ordinal, testValue);
    }

    public HString getAccountTypeHollowReference() {
        int refOrdinal = delegate().getAccountTypeOrdinal(ordinal);
        if(refOrdinal == -1)
            return null;
        return  api().getHString(refOrdinal);
    }

    public DomainSetsApi api() {
        return typeApi().getAPI();
    }

    public AdsTxtEntryDTOTypeAPI typeApi() {
        return delegate().getTypeAPI();
    }

    protected AdsTxtEntryDTODelegate delegate() {
        return (AdsTxtEntryDTODelegate)delegate;
    }

    public String toString() {
        return new HollowRecordStringifier().stringify(this);
    }

}