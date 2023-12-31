package models.create_user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties (ignoreUnknown = true)
public class CreateUserResponseBodyModel {
    private String name, job;
}
