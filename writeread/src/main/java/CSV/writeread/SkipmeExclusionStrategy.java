package CSV.writeread;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;



public class SkipmeExclusionStrategy implements ExclusionStrategy {
    private final Class<?> typeToSkip;

    public SkipmeExclusionStrategy(Class<?> typeToSkip) {
        this.typeToSkip = typeToSkip;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz == typeToSkip);
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(SkipMe.class) != null;
    }

}
