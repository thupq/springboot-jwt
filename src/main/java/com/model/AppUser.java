package com.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.util.LocalDateTimeDeserializer;
import com.util.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data // Create getters and setters
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
//    @Column(unique = true, nullable = false)
    private String username;

//    @Column(unique = true, nullable = false)
    private String email;

    //  @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    @Column(name = "status")
    private Integer status;

    @ElementCollection(fetch = FetchType.EAGER)
    List<AppUserRole> appUserRoles;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdDate;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "last_updated_date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastUpdatedDate;

}
