package github.guakun01.zhangbujava1.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuaBO {
    private Long id;
    private String displayName;
    private String innerId;
}
