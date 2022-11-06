package github.guakun01.zhangbujava1.model.persistence;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuaDO {
    private Long id;
    private String displayName;
    private String innerId;
    private String salt;
    private LocalDate createAt;
    private LocalDate modifiedAt;
}
