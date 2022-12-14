package github.guakun01.zhangbujava1.converter.DO2BO;

import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GuaBoConverter extends Converter<GuaDO, GuaBO>{

    @Override
    protected GuaBO doForward(GuaDO guaDO) {
        return GuaBO.builder()
        .id(guaDO.getId())
        .displayName(guaDO.getDisplayName())
        .innerId(guaDO.getInnerId())
        .salt(guaDO.getSalt())
        .build();
    }

    @Override
    protected GuaDO doBackward(GuaBO guaBO) {
        return GuaDO.builder()
        .id(guaBO.getId())
        .displayName(guaBO.getDisplayName())
        .innerId(guaBO.getInnerId())
        .salt(guaBO.getSalt())
        .build();
    }
    
}
