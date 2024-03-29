package org.sid.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString 
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id ;
  private String username;
  private String motPasse;
  private EnumRole role;
  
}
