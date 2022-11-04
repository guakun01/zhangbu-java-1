package github.guakun01.zhangbujava1.model.service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuaVO {
    private Long id;
    private String displayName;
}
