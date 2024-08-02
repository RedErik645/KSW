package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
    DataBinderMapperImpl() {
        addMapper(new com.wits.ksw.DataBinderMapperImpl());
    }
}
