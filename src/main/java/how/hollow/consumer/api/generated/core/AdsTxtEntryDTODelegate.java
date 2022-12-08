package how.hollow.consumer.api.generated.core;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.objects.delegate.HollowObjectDelegate;


@SuppressWarnings("all")
public interface AdsTxtEntryDTODelegate extends HollowObjectDelegate {

    public String getDomain(int ordinal);

    public boolean isDomainEqual(int ordinal, String testValue);

    public int getDomainOrdinal(int ordinal);

    public String getAccountId(int ordinal);

    public boolean isAccountIdEqual(int ordinal, String testValue);

    public int getAccountIdOrdinal(int ordinal);

    public String getAccountType(int ordinal);

    public boolean isAccountTypeEqual(int ordinal, String testValue);

    public int getAccountTypeOrdinal(int ordinal);

    public AdsTxtEntryDTOTypeAPI getTypeAPI();

}