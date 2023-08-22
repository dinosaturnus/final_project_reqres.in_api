package models.update_user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UpdateUserResponseBodyModel {
    private String name, job;
}
