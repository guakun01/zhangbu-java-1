package github.guakun01.zhangbujava1.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import github.guakun01.zhangbujava1.model.persistence.GuaDO;

@Mapper
public interface GuaMapper {
    
    @Select("SELECT id, display_name, inner_id, salt, create_at, modified_at from hi_gua where id = #{id};")
    GuaDO getGuaById(@Param("id")long id);

    @Select("SELECT id, display_name, inner_id, salt, create_at, modified_at from hi_gua where display_name = #{gname};")
    GuaDO getGuaByName(@Param("gname")String gname);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT hi_gua(display_name,inner_id,salt,create_at) VALUES ( #{displayName}, #{innerId}, #{salt}, NOW());")
    int insertGua(GuaDO newGua);
}
