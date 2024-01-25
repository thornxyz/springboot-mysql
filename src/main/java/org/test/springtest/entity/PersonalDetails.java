package org.test.springtest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONAL_DETAILS")

public class PersonalDetails {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String gender;
    private Long phone;
    private String email;
}
