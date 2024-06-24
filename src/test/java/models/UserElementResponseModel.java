package models;

import lombok.Data;

@Data
public class UserElementResponseModel {

    Integer id;
    String email, first_name, last_name, avatar;
}
