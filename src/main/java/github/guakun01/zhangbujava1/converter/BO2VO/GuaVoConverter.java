package github.guakun01.zhangbujava1.converter.BO2VO;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.service.GuaVO;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor 
@EqualsAndHashCode(callSuper = true)
public class GuaVoConverter extends Converter<GuaBO, GuaVO> {

    @Override
    protected GuaVO doForward(@NotNull GuaBO guaBO) {
        return GuaVO.builder()
                .id(guaBO.getId())
                .displayName(guaBO.getDisplayName())
                .innerId(guaBO.getInnerId())
                .build();
    }

    @Override
    protected GuaBO doBackward(GuaVO guaVO) {
        // 如果你不需要 可以抛出一个异常
        // throw new UnsupportedOperationException("不支持这样的操作");
        return GuaBO.builder()
                .id(guaVO.getId())
                .displayName(guaVO.getDisplayName())
                .innerId(guaVO.getInnerId())
                .build();
    }

}
