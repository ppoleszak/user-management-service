package com.poleszak.security.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserApp {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "user_app_id_sequence")
    @SequenceGenerator(name = "user_app_id_sequence", sequenceName = "user_app_id_sequence")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
