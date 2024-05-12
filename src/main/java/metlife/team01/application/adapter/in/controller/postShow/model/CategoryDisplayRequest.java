package metlife.team01.application.adapter.in.controller.postShow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDisplayRequest {

    private int codeNum;
    private int menuLevel;
    private String codeName;
    private String chatResponse;
    private String createdAt;
    private String modifyAt;
    private String deleteYn;
    private Integer parentLevel;

}
