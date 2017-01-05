package com.grinyov.spring.rest_client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by vgrinyov.
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StackOverflowWebsite {
    @Id
    private String id;
    private String website;
    private String iconImageUrl;
    private String title;
    private String description;

}
