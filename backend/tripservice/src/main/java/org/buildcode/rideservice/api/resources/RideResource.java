package org.buildcode.rideservice.api.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.buildcode.rideservice.api.constants.ApiConstants;
import org.buildcode.rideservice.data.entity.Ride;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Ride Details Resource")

@RestController
@RequestMapping(value = ApiConstants.BOOKING_SERVICE_V1 + ApiConstants.BOOKING_REQUEST)
public interface RideResource {

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = ApiConstants.MESSAGE_SUCCESS),
                    @ApiResponse(responseCode = "400", description = ApiConstants.MESSAGE_BAD_REQUEST),
                    @ApiResponse(responseCode = "500", description = ApiConstants.MESSAGE_INTERNAL_SERVER_ERROR),
                    @ApiResponse(responseCode = "404", description = ApiConstants.MESSAGE_NOT_FOUND)
            }
    )
    @Operation(method = "GET", summary = "Get Ride Details By Id")
    @GetMapping("/{id}")
    ResponseEntity<Ride> getBookingRequest(
            @Parameter(name = "id", description = "ride id")
            @Schema(description = "Reference", example = "8732njsf87yh", required = true)
            @PathVariable String id
    );

    // New method to accept a ride
    @Operation(method = "POST", summary = "Accept Ride Request")
    @PostMapping("/{id}/accept")
    ResponseEntity<String> acceptRide(
            @Parameter(name = "id", description = "ride id")
            @Schema(description = "Ride ID", example = "8732njsf87yh", required = true)
            @PathVariable String id
    );

    // New method to reject a ride
    @Operation(method = "POST", summary = "Reject Ride Request")
    @PostMapping("/{id}/reject")
    ResponseEntity<String> rejectRide(
            @Parameter(name = "id", description = "ride id")
            @Schema(description = "Ride ID", example = "8732njsf87yh", required = true)
            @PathVariable String id
    );

    // New method to cancel a ride
    @Operation(method = "POST", summary = "Cancel Ride Request")
    @PostMapping("/{id}/cancel")
    ResponseEntity<String> cancelRide(
            @Parameter(name = "id", description = "ride id")
            @Schema(description = "Ride ID", example = "8732njsf87yh", required = true)
            @PathVariable String id
    );

    // New method to request a ride by the rider
     @Operation(method = "POST", summary = "Rider Requests a Ride")
      @PostMapping("/{rideId}/request")
      ResponseEntity<String> requestRide(
         @Parameter(name = "rideId", description = "ride id")
         @Schema(description = "Ride ID", example = "8732njsf87yh", required = true)
         @PathVariable String rideId
);

}