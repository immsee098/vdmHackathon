package metlife.team01.application.adapter.in.controller.pjtest.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import metlife.team01.application.domain.pjtest.model.PjtestEntity;

import java.io.Serial;
import java.io.Serializable;

//DTO임
@Getter
@NoArgsConstructor
public class PjtestResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    private int empNo;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String hireDate;

    @QueryProjection
    public PjtestResponse(PjtestEntity pjtestEntity, String firstName, String lastName) {
        this.empNo = pjtestEntity.getEmpNo();
        this.birthDate = pjtestEntity.getBirthDate();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = pjtestEntity.getGender();
        this.hireDate = pjtestEntity.getHireDate();
    }
}
