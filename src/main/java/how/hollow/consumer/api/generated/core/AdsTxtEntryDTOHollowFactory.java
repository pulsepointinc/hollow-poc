package how.hollow.consumer.api.generated.core;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.AdsTxtEntryDTO;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.objects.provider.HollowFactory;
import com.netflix.hollow.core.read.dataaccess.HollowTypeDataAccess;
import com.netflix.hollow.api.custom.HollowTypeAPI;

@SuppressWarnings("all")
public class AdsTxtEntryDTOHollowFactory<T extends AdsTxtEntryDTO> extends HollowFactory<T> {

    @Override
    public T newHollowObject(HollowTypeDataAccess dataAccess, HollowTypeAPI typeAPI, int ordinal) {
        return (T)new AdsTxtEntryDTO(((AdsTxtEntryDTOTypeAPI)typeAPI).getDelegateLookupImpl(), ordinal);
    }

    @Override
    public T newCachedHollowObject(HollowTypeDataAccess dataAccess, HollowTypeAPI typeAPI, int ordinal) {
        return (T)new AdsTxtEntryDTO(new AdsTxtEntryDTODelegateCachedImpl((AdsTxtEntryDTOTypeAPI)typeAPI, ordinal), ordinal);
    }

}