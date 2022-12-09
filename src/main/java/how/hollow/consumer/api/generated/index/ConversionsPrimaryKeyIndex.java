package how.hollow.consumer.api.generated.index;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.DomainSetsApi;
import how.hollow.consumer.api.generated.Conversions;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.index.AbstractHollowUniqueKeyIndex;
import com.netflix.hollow.api.consumer.index.HollowUniqueKeyIndex;
import com.netflix.hollow.core.schema.HollowObjectSchema;

/**
 * @deprecated see {@link com.netflix.hollow.api.consumer.index.UniqueKeyIndex} which can be created as follows:
 * <pre>{@code
 *     UniqueKeyIndex<Conversions, long> uki = Conversions.uniqueIndex(consumer);
 *     long k = ...;
 *     Conversions m = uki.findMatch(k);
 * }</pre>
 * @see Conversions#uniqueIndex
 */
@Deprecated
@SuppressWarnings("all")
public class ConversionsPrimaryKeyIndex extends AbstractHollowUniqueKeyIndex<DomainSetsApi, Conversions> {

    public ConversionsPrimaryKeyIndex(HollowConsumer consumer) {
        this(consumer, false);
    }

    public ConversionsPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefresh) {
        this(consumer, isListenToDataRefresh, ((HollowObjectSchema)consumer.getStateEngine().getNonNullSchema("Conversions")).getPrimaryKey().getFieldPaths());
    }

    private ConversionsPrimaryKeyIndex(HollowConsumer consumer, String... fieldPaths) {
        this(consumer, false, fieldPaths);
    }

    private ConversionsPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefresh, String... fieldPaths) {
        super(consumer, "Conversions", isListenToDataRefresh, fieldPaths);
    }

    public Conversions findMatch(long id) {
        int ordinal = idx.getMatchingOrdinal(id);
        if(ordinal == -1)
            return null;
        return api.getConversions(ordinal);
    }

}