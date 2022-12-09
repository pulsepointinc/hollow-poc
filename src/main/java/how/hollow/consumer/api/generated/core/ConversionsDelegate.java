package how.hollow.consumer.api.generated.core;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.objects.delegate.HollowObjectDelegate;


@SuppressWarnings("all")
public interface ConversionsDelegate extends HollowObjectDelegate {

    public long getId(int ordinal);

    public Long getIdBoxed(int ordinal);

    public String getType(int ordinal);

    public boolean isTypeEqual(int ordinal, String testValue);

    public int getTypeOrdinal(int ordinal);

    public ConversionsTypeAPI getTypeAPI();

}