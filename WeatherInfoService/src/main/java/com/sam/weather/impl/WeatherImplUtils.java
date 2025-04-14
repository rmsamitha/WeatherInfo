package com.sam.weather.impl;

import com.sam.weather.impl.dto.ErrorDTO;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WeatherImplUtils {
    private static CloseableHttpClient httpClient;

    public static void setHttpClient() {
        httpClient = HttpClients.custom()
                .setMaxConnTotal(100) // Set maximum total connections
                .setMaxConnPerRoute(10) // Set maximum connections per route
                .build();
    }

    public static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            setHttpClient();
        }
        return httpClient;
    }

    /**
     * Returns a generic errorDTO
     *
     * @param message specifies the error message
     * @return A generic errorDTO with the specified details
     */
    public static ErrorDTO getErrorDTO(String message, Long code, String description) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(code);
        errorDTO.setMoreInfo("");
        errorDTO.setMessage(message);
        errorDTO.setDescription(description);
        return errorDTO;
    }

    /**
     * Returns a new InternalServerErrorException
     *
     * @param errorDescription Error Description
     * @return a new InternalServerErrorException with default details as a response DTO
     */
    public static Response buildInternalServerErrorResponse(String errorDescription) {
        ErrorDTO errorDTO = getErrorDTO(RestApiConstants.STATUS_INTERNAL_SERVER_ERROR_MESSAGE_DEFAULT, 500l,
                errorDescription);
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorDTO)
                .build();
    }

    /**
     * Returns a new BadGateway Response
     *
     * @param errorDescription Error Description
     * @return a new BadGateway Response with default details as a response DTO
     */
    public static Response buildBadGatewayResponse(String errorDescription) {
        ErrorDTO errorDTO = getErrorDTO(RestApiConstants.STATUS_BAD_GATEWAY_MESSAGE_DEFAULT, 502l,
                errorDescription);
        return Response
                .status(Response.Status.BAD_GATEWAY)
                .type(MediaType.APPLICATION_JSON)
                .entity(errorDTO)
                .build();
    }

    /**
     * Returns a new BadRequest Response
     *
     * @param errorDescription Error Description
     * @return a new BadRequest Response with default details as a response DTO
     */
    public static Response buildBadRequestResponse(String errorDescription) {
        ErrorDTO errorDTO = getErrorDTO(RestApiConstants.STATUS_BAD_REQUEST_MESSAGE_DEFAULT, 400l,
                errorDescription);
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON)
                .entity(errorDTO)
                .build();
    }
}
