/*
 * Copyright 2025 Samitha Chathuranga
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sam.weather.impl;

import com.sam.weather.impl.dto.ErrorDTO;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WeatherImplUtils {
    private static CloseableHttpClient httpClient;

    /**
     * Sets the HTTP client with custom configurations.
     */
    public static void setHttpClient() {
        httpClient = HttpClients.custom()
                .setMaxConnTotal(100) // Set maximum total connections
                .setMaxConnPerRoute(10) // Set maximum connections per route
                .build();
    }

    /**
     * Returns the HTTP client.
     *
     * @return CloseableHttpClient instance
     */
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
