package how.hollow.consumer.api.generated.core;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.core.*;

import com.netflix.hollow.api.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.schema.HollowObjectSchema;
import com.netflix.hollow.api.custom.HollowTypeAPI;
import com.netflix.hollow.api.objects.delegate.HollowCachedDelegate;

@SuppressWarnings("all")
public class ConversionsDelegateCachedImpl extends HollowObjectAbstractDelegate implements HollowCachedDelegate, ConversionsDelegate {

    private final Long id;
    private final String type;
    private final int typeOrdinal;
    private ConversionsTypeAPI typeAPI;

    public ConversionsDelegateCachedImpl(ConversionsTypeAPI typeAPI, int ordinal) {
        this.id = typeAPI.getIdBoxed(ordinal);
        this.typeOrdinal = typeAPI.getTypeOrdinal(ordinal);
        int typeTempOrdinal = typeOrdinal;
        this.type = typeTempOrdinal == -1 ? null : typeAPI.getAPI().getStringTypeAPI().getValue(typeTempOrdinal);
        this.typeAPI = typeAPI;
    }

    public long getId(int ordinal) {
        if(id == null)
            return Long.MIN_VALUE;
        return id.longValue();
    }

    public Long getIdBoxed(int ordinal) {
        return id;
    }

    public String getType(int ordinal) {
        return type;
    }

    public boolean isTypeEqual(int ordinal, String testValue) {
        if(testValue == null)
            return type == null;
        return testValue.equals(type);
    }

    public int getTypeOrdinal(int ordinal) {
        return typeOrdinal;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

    public ConversionsTypeAPI getTypeAPI() {
        return typeAPI;
    }

    public void updateTypeAPI(HollowTypeAPI typeAPI) {
        this.typeAPI = (ConversionsTypeAPI) typeAPI;
    }

}