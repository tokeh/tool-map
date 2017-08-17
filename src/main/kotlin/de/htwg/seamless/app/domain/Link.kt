package de.htwg.seamless.app.domain

import de.htwg.seamless.app.domain.finder.LinkFinder
import io.ebean.Model
import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class Link(

        @Id
        @NotNull
        @Size(max = 200)
        val linkText: String,

        @NotNull
        @Size(max = 200)
        val name: String

) : Model() {

    companion object : LinkFinder()
}