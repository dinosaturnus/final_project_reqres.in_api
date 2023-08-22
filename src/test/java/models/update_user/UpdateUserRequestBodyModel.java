package models.update_user;

import lombok.Data;

@Data
public class UpdateUserRequestBodyModel {
    private String name, job;
}
