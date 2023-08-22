package models.create_user;

import lombok.Data;

@Data
public class CreateUserRequestBodyModel {
    private String name, job;
}