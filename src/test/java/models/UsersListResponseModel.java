package models;

import lombok.Data;

@Data
public class UsersListResponseModel {

    Integer page, per_page, total, total_pages;
    UserElementResponseModel[] data;
    SupportModel support;
}
