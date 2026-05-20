package com.oddno.lovelive.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.dto.response.tutorial.TutorialsStatusInfo;
import com.oddno.lovelive.enums.UserType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLoginResponse {

    @JsonProperty("type")
    private UserType type;

    @JsonProperty("session_token")
    private String sessionToken;

    @JsonProperty("is_tutorial")
    private boolean isTutorial;

    @JsonProperty("is_term_update")
    private boolean isTermUpdate;

    @JsonProperty("is_login_bonus_receive")
    private boolean isLoginBonusReceive;

    @JsonProperty("push_device_token")
    private String pushDeviceToken;

    @JsonProperty("sisca_product_id_list")
    private List<String> siscaProductIdList;

    @JsonProperty("membership_product_id_list")
    private List<String> membershipProductIdList;

    @JsonProperty("item_store_product_id_list")
    private List<String> itemStoreProductIdList;

    @JsonProperty("tutorials_status_list")
    private List<TutorialsStatusInfo> tutorialsStatusList;
}