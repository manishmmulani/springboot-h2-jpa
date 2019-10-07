package com.mulani.springboot.h2jpa.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Alien(
        @Id
        val aid: Int,
        val aname: String,
        val tech: String)
