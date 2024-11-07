package com.group8.vlearning.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_purchased_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPurchasedCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "purchasedCourses")
    @JsonIgnore
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    // @JsonIgnoreProperties(value = { "ownBy", "favoriteUser", "purchasedUser" })
    @JoinTable(name = "purchased_courses", joinColumns = @JoinColumn(name = "purchased_courses_collection_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> purchasedCourses;
}
