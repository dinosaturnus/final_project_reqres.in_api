package models.get_user;

import lombok.Data;

@Data
public class GetUserResponseModel {
    private UserInfoDataObject data;

    private SupportDataObject support;
}
