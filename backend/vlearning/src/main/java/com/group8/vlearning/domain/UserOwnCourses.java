package com.group8.vlearning.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_own_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOwnCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "ownCourses")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "ownBy", fetch = FetchType.LAZY)
    // @JsonIgnoreProperties(value = { "ownBy" })
    private List<Course> ownCourses;
}
