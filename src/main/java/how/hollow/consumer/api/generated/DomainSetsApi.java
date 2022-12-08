package how.hollow.consumer.api.generated;

import com.netflix.hollow.core.type.*;
import how.hollow.consumer.api.generated.core.*;

import java.util.Objects;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.Map;
import com.netflix.hollow.api.consumer.HollowConsumerAPI;
import com.netflix.hollow.api.custom.HollowAPI;
import com.netflix.hollow.core.read.dataaccess.HollowDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowListTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowSetTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowMapTypeDataAccess;
import com.netflix.hollow.core.read.dataaccess.missing.HollowObjectMissingDataAccess;
import com.netflix.hollow.core.read.dataaccess.missing.HollowListMissingDataAccess;
import com.netflix.hollow.core.read.dataaccess.missing.HollowSetMissingDataAccess;
import com.netflix.hollow.core.read.dataaccess.missing.HollowMapMissingDataAccess;
import com.netflix.hollow.api.objects.provider.HollowFactory;
import com.netflix.hollow.api.objects.provider.HollowObjectProvider;
import com.netflix.hollow.api.objects.provider.HollowObjectCacheProvider;
import com.netflix.hollow.api.objects.provider.HollowObjectFactoryProvider;
import com.netflix.hollow.api.sampling.HollowObjectCreationSampler;
import com.netflix.hollow.api.sampling.HollowSamplingDirector;
import com.netflix.hollow.api.sampling.SampleResult;
import com.netflix.hollow.core.util.AllHollowRecordCollection;

@SuppressWarnings("all")
public class DomainSetsApi extends HollowAPI implements  HollowConsumerAPI.StringRetriever {

    private final HollowObjectCreationSampler objectCreationSampler;

    private final StringTypeAPI stringTypeAPI;
    private final AdsTxtEntryDTOTypeAPI adsTxtEntryDTOTypeAPI;

    private final HollowObjectProvider stringProvider;
    private final HollowObjectProvider adsTxtEntryDTOProvider;

    public DomainSetsApi(HollowDataAccess dataAccess) {
        this(dataAccess, Collections.<String>emptySet());
    }

    public DomainSetsApi(HollowDataAccess dataAccess, Set<String> cachedTypes) {
        this(dataAccess, cachedTypes, Collections.<String, HollowFactory<?>>emptyMap());
    }

    public DomainSetsApi(HollowDataAccess dataAccess, Set<String> cachedTypes, Map<String, HollowFactory<?>> factoryOverrides) {
        this(dataAccess, cachedTypes, factoryOverrides, null);
    }

    public DomainSetsApi(HollowDataAccess dataAccess, Set<String> cachedTypes, Map<String, HollowFactory<?>> factoryOverrides, DomainSetsApi previousCycleAPI) {
        super(dataAccess);
        HollowTypeDataAccess typeDataAccess;
        HollowFactory factory;

        objectCreationSampler = new HollowObjectCreationSampler("String","AdsTxtEntryDTO");

        typeDataAccess = dataAccess.getTypeDataAccess("String");
        if(typeDataAccess != null) {
            stringTypeAPI = new StringTypeAPI(this, (HollowObjectTypeDataAccess)typeDataAccess);
        } else {
            stringTypeAPI = new StringTypeAPI(this, new HollowObjectMissingDataAccess(dataAccess, "String"));
        }
        addTypeAPI(stringTypeAPI);
        factory = factoryOverrides.get("String");
        if(factory == null)
            factory = new StringHollowFactory();
        if(cachedTypes.contains("String")) {
            HollowObjectCacheProvider previousCacheProvider = null;
            if(previousCycleAPI != null && (previousCycleAPI.stringProvider instanceof HollowObjectCacheProvider))
                previousCacheProvider = (HollowObjectCacheProvider) previousCycleAPI.stringProvider;
            stringProvider = new HollowObjectCacheProvider(typeDataAccess, stringTypeAPI, factory, previousCacheProvider);
        } else {
            stringProvider = new HollowObjectFactoryProvider(typeDataAccess, stringTypeAPI, factory);
        }

        typeDataAccess = dataAccess.getTypeDataAccess("AdsTxtEntryDTO");
        if(typeDataAccess != null) {
            adsTxtEntryDTOTypeAPI = new AdsTxtEntryDTOTypeAPI(this, (HollowObjectTypeDataAccess)typeDataAccess);
        } else {
            adsTxtEntryDTOTypeAPI = new AdsTxtEntryDTOTypeAPI(this, new HollowObjectMissingDataAccess(dataAccess, "AdsTxtEntryDTO"));
        }
        addTypeAPI(adsTxtEntryDTOTypeAPI);
        factory = factoryOverrides.get("AdsTxtEntryDTO");
        if(factory == null)
            factory = new AdsTxtEntryDTOHollowFactory();
        if(cachedTypes.contains("AdsTxtEntryDTO")) {
            HollowObjectCacheProvider previousCacheProvider = null;
            if(previousCycleAPI != null && (previousCycleAPI.adsTxtEntryDTOProvider instanceof HollowObjectCacheProvider))
                previousCacheProvider = (HollowObjectCacheProvider) previousCycleAPI.adsTxtEntryDTOProvider;
            adsTxtEntryDTOProvider = new HollowObjectCacheProvider(typeDataAccess, adsTxtEntryDTOTypeAPI, factory, previousCacheProvider);
        } else {
            adsTxtEntryDTOProvider = new HollowObjectFactoryProvider(typeDataAccess, adsTxtEntryDTOTypeAPI, factory);
        }

    }

    public void detachCaches() {
        if(stringProvider instanceof HollowObjectCacheProvider)
            ((HollowObjectCacheProvider)stringProvider).detach();
        if(adsTxtEntryDTOProvider instanceof HollowObjectCacheProvider)
            ((HollowObjectCacheProvider)adsTxtEntryDTOProvider).detach();
    }

    public StringTypeAPI getStringTypeAPI() {
        return stringTypeAPI;
    }
    public AdsTxtEntryDTOTypeAPI getAdsTxtEntryDTOTypeAPI() {
        return adsTxtEntryDTOTypeAPI;
    }
    public Collection<HString> getAllHString() {
        HollowTypeDataAccess tda = Objects.requireNonNull(getDataAccess().getTypeDataAccess("String"), "type not loaded or does not exist in dataset; type=String");
        return new AllHollowRecordCollection<HString>(tda.getTypeState()) {
            protected HString getForOrdinal(int ordinal) {
                return getHString(ordinal);
            }
        };
    }
    public HString getHString(int ordinal) {
        objectCreationSampler.recordCreation(0);
        return (HString)stringProvider.getHollowObject(ordinal);
    }
    public Collection<AdsTxtEntryDTO> getAllAdsTxtEntryDTO() {
        HollowTypeDataAccess tda = Objects.requireNonNull(getDataAccess().getTypeDataAccess("AdsTxtEntryDTO"), "type not loaded or does not exist in dataset; type=AdsTxtEntryDTO");
        return new AllHollowRecordCollection<AdsTxtEntryDTO>(tda.getTypeState()) {
            protected AdsTxtEntryDTO getForOrdinal(int ordinal) {
                return getAdsTxtEntryDTO(ordinal);
            }
        };
    }
    public AdsTxtEntryDTO getAdsTxtEntryDTO(int ordinal) {
        objectCreationSampler.recordCreation(1);
        return (AdsTxtEntryDTO)adsTxtEntryDTOProvider.getHollowObject(ordinal);
    }
    public void setSamplingDirector(HollowSamplingDirector director) {
        super.setSamplingDirector(director);
        objectCreationSampler.setSamplingDirector(director);
    }

    public Collection<SampleResult> getObjectCreationSamplingResults() {
        return objectCreationSampler.getSampleResults();
    }

}
