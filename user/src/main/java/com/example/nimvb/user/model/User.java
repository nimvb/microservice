package com.example.nimvb.user.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String email;

}
