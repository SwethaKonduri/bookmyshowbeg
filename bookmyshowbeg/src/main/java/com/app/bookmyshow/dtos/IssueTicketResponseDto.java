package com.app.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueTicketResponseDto {
    ResponseStatus responseStatus;
    private int amount;
    private Long bookingId;
}
