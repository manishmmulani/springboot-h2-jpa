package com.mulani.springboot.h2jpa.controller

import com.mulani.springboot.h2jpa.dao.AlienRepo
import com.mulani.springboot.h2jpa.model.Alien
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.ArrayList

@RestController
@RequestMapping("aliens")
class AlienResourceController(@Autowired val alienRepo: AlienRepo) {

    @GetMapping("/")
    fun getAllAliens(@RequestParam tech: String?, @RequestParam minAid: Int?): Set<Alien> {
        var all: List<Alien> = alienRepo.findAll()

        val resultMinAid = if (minAid != null) alienRepo.findByAidGreaterThan(minAid)  else all
        val resultByTech = if (tech != null) alienRepo.findByTech(tech) else all

        return resultMinAid.intersect(resultByTech)
    }

    @GetMapping("/{aid}")
    fun getAlien(@PathVariable aid: Int): Optional<Alien> {
        return alienRepo.findById(aid)
    }

    @PostMapping("/")
    fun addAlien(@RequestBody alien:Alien):Alien {
        alienRepo.save(alien)
        return alien
    }
}