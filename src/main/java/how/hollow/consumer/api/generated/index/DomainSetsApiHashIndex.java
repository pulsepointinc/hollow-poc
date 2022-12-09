package how.hollow.consumer.api.generated.index;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.DomainSetsApi;
import how.hollow.consumer.api.generated.Conversions;
import how.hollow.consumer.api.generated.AdsTxtEntryDTO;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.core.index.HollowHashIndexResult;
import java.util.Collections;
import java.lang.Iterable;
import com.netflix.hollow.api.consumer.index.AbstractHollowHashIndex;
import com.netflix.hollow.api.consumer.data.AbstractHollowOrdinalIterable;


/**
 * @deprecated see {@link com.netflix.hollow.api.consumer.index.HashIndex} which can be built as follows:
 * <pre>{@code
 *     HashIndex<HString, K> uki = HashIndex.from(consumer, HString.class)
 *         .usingBean(k);
 *     Stream<HString> results = uki.findMatches(k);
 * }</pre>
 * where {@code K} is a class declaring key field paths members, annotated with
 * {@link com.netflix.hollow.api.consumer.index.FieldPath}, and {@code k} is an instance of
 * {@code K} that is the query to find the matching {@code HString} objects.
 */
@Deprecated
@SuppressWarnings("all")
public class DomainSetsApiHashIndex extends AbstractHollowHashIndex<DomainSetsApi> {

    public DomainSetsApiHashIndex(HollowConsumer consumer, String queryType, String selectFieldPath, String... matchFieldPaths) {
        super(consumer, false, queryType, selectFieldPath, matchFieldPaths);
    }

    public DomainSetsApiHashIndex(HollowConsumer consumer, boolean isListenToDataRefresh, String queryType, String selectFieldPath, String... matchFieldPaths) {
        super(consumer, isListenToDataRefresh, queryType, selectFieldPath, matchFieldPaths);
    }

    public Iterable<HString> findStringMatches(Object... keys) {
        HollowHashIndexResult matches = idx.findMatches(keys);
        if(matches == null) return Collections.emptySet();

        return new AbstractHollowOrdinalIterable<HString>(matches.iterator()) {
            public HString getData(int ordinal) {
                return api.getHString(ordinal);
            }
        };
    }

    public Iterable<AdsTxtEntryDTO> findAdsTxtEntryDTOMatches(Object... keys) {
        HollowHashIndexResult matches = idx.findMatches(keys);
        if(matches == null) return Collections.emptySet();

        return new AbstractHollowOrdinalIterable<AdsTxtEntryDTO>(matches.iterator()) {
            public AdsTxtEntryDTO getData(int ordinal) {
                return api.getAdsTxtEntryDTO(ordinal);
            }
        };
    }

    public Iterable<Conversions> findConversionsMatches(Object... keys) {
        HollowHashIndexResult matches = idx.findMatches(keys);
        if(matches == null) return Collections.emptySet();

        return new AbstractHollowOrdinalIterable<Conversions>(matches.iterator()) {
            public Conversions getData(int ordinal) {
                return api.getConversions(ordinal);
            }
        };
    }

}