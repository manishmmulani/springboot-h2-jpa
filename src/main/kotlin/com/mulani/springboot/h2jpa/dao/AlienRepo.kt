package com.mulani.springboot.h2jpa.dao

import com.mulani.springboot.h2jpa.model.Alien
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

@Component
interface AlienRepo : JpaRepository<Alien, Int> {
    fun findByTech(tech:String):List<Alien>
    fun findByAidGreaterThan(aid:Int):List<Alien>
}