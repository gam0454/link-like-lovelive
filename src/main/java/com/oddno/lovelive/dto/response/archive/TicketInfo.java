package com.oddno.lovelive.dto.response.archive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oddno.lovelive.enums.LiveTicketRank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketInfo {

    @JsonProperty("item_id")
    private int itemId;

    @JsonProperty("shop_item_id")
    private int shopItemId;

    @JsonProperty("is_paid_sisca_only")
    private boolean isPaidSiscaOnly;

    @JsonProperty("price")
    private int price;

    @JsonProperty("order_id")
    private int orderId;

    @JsonProperty("ticket_rank")
    private LiveTicketRank ticketRank;

}