package how.hollow.consumer.api.generated.accessor;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.DomainSetsApi;
import how.hollow.consumer.api.generated.AdsTxtEntryDTO;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.data.AbstractHollowDataAccessor;
import com.netflix.hollow.core.index.key.PrimaryKey;
import com.netflix.hollow.core.read.engine.HollowReadStateEngine;

@SuppressWarnings("all")
public class AdsTxtEntryDTODataAccessor extends AbstractHollowDataAccessor<AdsTxtEntryDTO> {

    public static final String TYPE = "AdsTxtEntryDTO";
    private DomainSetsApi api;

    public AdsTxtEntryDTODataAccessor(HollowConsumer consumer) {
        super(consumer, TYPE);
        this.api = (DomainSetsApi)consumer.getAPI();
    }

    public AdsTxtEntryDTODataAccessor(HollowReadStateEngine rStateEngine, DomainSetsApi api) {
        super(rStateEngine, TYPE);
        this.api = api;
    }

    public AdsTxtEntryDTODataAccessor(HollowReadStateEngine rStateEngine, DomainSetsApi api, String ... fieldPaths) {
        super(rStateEngine, TYPE, fieldPaths);
        this.api = api;
    }

    public AdsTxtEntryDTODataAccessor(HollowReadStateEngine rStateEngine, DomainSetsApi api, PrimaryKey primaryKey) {
        super(rStateEngine, TYPE, primaryKey);
        this.api = api;
    }

    @Override public AdsTxtEntryDTO getRecord(int ordinal){
        return api.getAdsTxtEntryDTO(ordinal);
    }

}