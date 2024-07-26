package com.app.bookmyshow.controllers;

import com.app.bookmyshow.dtos.IssueTicketRequestDto;
import com.app.bookmyshow.dtos.IssueTicketResponseDto;
import com.app.bookmyshow.dtos.ResponseStatus;
import com.app.bookmyshow.models.Booking;
import com.app.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto) {
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();
        Booking booking = null;

        try {
            booking = bookingService.issueTicket(
                    requestDto.getUserId(),
                    requestDto.getShowId(),
                    requestDto.getShowSeatIds()
            );
            responseDto.setBookingId(booking.getId());
            responseDto.setAmount(booking.getAmount());
        } catch (Exception ex) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
