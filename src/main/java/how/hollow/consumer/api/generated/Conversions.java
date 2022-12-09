package how.hollow.consumer.api.generated;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.DomainSetsApi;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.index.UniqueKeyIndex;
import com.netflix.hollow.api.objects.HollowObject;
import com.netflix.hollow.core.schema.HollowObjectSchema;
import com.netflix.hollow.tools.stringifier.HollowRecordStringifier;

@SuppressWarnings("all")
public class Conversions extends HollowObject {

    public Conversions(ConversionsDelegate delegate, int ordinal) {
        super(delegate, ordinal);
    }

    public long getId() {
        return delegate().getId(ordinal);
    }



    public String getType() {
        return delegate().getType(ordinal);
    }

    public boolean isTypeEqual(String testValue) {
        return delegate().isTypeEqual(ordinal, testValue);
    }

    public HString getTypeHollowReference() {
        int refOrdinal = delegate().getTypeOrdinal(ordinal);
        if(refOrdinal == -1)
            return null;
        return  api().getHString(refOrdinal);
    }

    public DomainSetsApi api() {
        return typeApi().getAPI();
    }

    public ConversionsTypeAPI typeApi() {
        return delegate().getTypeAPI();
    }

    protected ConversionsDelegate delegate() {
        return (ConversionsDelegate)delegate;
    }

    public String toString() {
        return new HollowRecordStringifier().stringify(this);
    }

    /**
     * Creates a unique key index for {@code Conversions} that has a primary key.
     * The primary key is represented by the type {@code long}.
     * <p>
     * By default the unique key index will not track updates to the {@code consumer} and thus
     * any changes will not be reflected in matched results.  To track updates the index must be
     * {@link HollowConsumer#addRefreshListener(HollowConsumer.RefreshListener) registered}
     * with the {@code consumer}
     *
     * @param consumer the consumer
     * @return the unique key index
     */
    public static UniqueKeyIndex<Conversions, Long> uniqueIndex(HollowConsumer consumer) {
        return UniqueKeyIndex.from(consumer, Conversions.class)
            .bindToPrimaryKey()
            .usingPath("id", long.class);
    }

}