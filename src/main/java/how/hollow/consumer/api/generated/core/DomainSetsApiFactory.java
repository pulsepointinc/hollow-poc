package how.hollow.consumer.api.generated.core;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.DomainSetsApi;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.client.HollowAPIFactory;
import com.netflix.hollow.api.custom.HollowAPI;
import com.netflix.hollow.api.objects.provider.HollowFactory;
import com.netflix.hollow.core.read.dataaccess.HollowDataAccess;
import java.util.Collections;
import java.util.Set;

@SuppressWarnings("all")
public class DomainSetsApiFactory implements HollowAPIFactory {

    private final Set<String> cachedTypes;

    public DomainSetsApiFactory() {
        this(Collections.<String>emptySet());
    }

    public DomainSetsApiFactory(Set<String> cachedTypes) {
        this.cachedTypes = cachedTypes;
    }

    @Override
    public HollowAPI createAPI(HollowDataAccess dataAccess) {
        return new DomainSetsApi(dataAccess, cachedTypes);
    }

    @Override
    public HollowAPI createAPI(HollowDataAccess dataAccess, HollowAPI previousCycleAPI) {
        if (!(previousCycleAPI instanceof DomainSetsApi)) {
            throw new ClassCastException(previousCycleAPI.getClass() + " not instance of DomainSetsApi");        }
        return new DomainSetsApi(dataAccess, cachedTypes, Collections.<String, HollowFactory<?>>emptyMap(), (DomainSetsApi) previousCycleAPI);
    }

}