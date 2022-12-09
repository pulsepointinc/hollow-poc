package how.hollow.producer.domain.index;

import com.netflix.hollow.core.write.objectmapper.HollowPrimaryKey;

import java.util.Objects;

@HollowPrimaryKey(fields = "id")
public class Conversions {

    private long id;

    private String type;

    public Conversions() {
    }

    public Conversions(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public Conversions setId(long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Conversions setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conversions that = (Conversions) o;

        if (id != that.id) return false;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
