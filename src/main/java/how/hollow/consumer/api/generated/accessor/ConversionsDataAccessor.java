package how.hollow.consumer.api.generated.accessor;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.DomainSetsApi;
import how.hollow.consumer.api.generated.Conversions;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.data.AbstractHollowDataAccessor;
import com.netflix.hollow.core.index.key.PrimaryKey;
import com.netflix.hollow.core.read.engine.HollowReadStateEngine;

@SuppressWarnings("all")
public class ConversionsDataAccessor extends AbstractHollowDataAccessor<Conversions> {

    public static final String TYPE = "Conversions";
    private DomainSetsApi api;

    public ConversionsDataAccessor(HollowConsumer consumer) {
        super(consumer, TYPE);
        this.api = (DomainSetsApi)consumer.getAPI();
    }

    public ConversionsDataAccessor(HollowReadStateEngine rStateEngine, DomainSetsApi api) {
        super(rStateEngine, TYPE);
        this.api = api;
    }

    public ConversionsDataAccessor(HollowReadStateEngine rStateEngine, DomainSetsApi api, String ... fieldPaths) {
        super(rStateEngine, TYPE, fieldPaths);
        this.api = api;
    }

    public ConversionsDataAccessor(HollowReadStateEngine rStateEngine, DomainSetsApi api, PrimaryKey primaryKey) {
        super(rStateEngine, TYPE, primaryKey);
        this.api = api;
    }

    @Override public Conversions getRecord(int ordinal){
        return api.getConversions(ordinal);
    }

}