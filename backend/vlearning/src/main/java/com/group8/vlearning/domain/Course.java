package com.group8.vlearning.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Tên khóa học không được để trống")
    private String title;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "courses_skills", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    @ManyToOne()
    @JoinColumn(name = "own_by")
    private UserOwnCourses ownBy;

    @ManyToMany(mappedBy = "purchasedCourses", fetch = FetchType.LAZY)
    // @JsonIgnoreProperties(value = { "skills", "purchasedUser" })
    private List<UserPurchasedCourses> purchasedUser;

    @ManyToMany(mappedBy = "favoriteCourses", fetch = FetchType.LAZY)
    // @JsonIgnoreProperties(value = { "skills", "purchasedUser" })
    private List<UserFavoriteCourses> favoriteUser;

}
