package de.htwg.seamless.app.domain

import de.htwg.seamless.app.domain.finder.ToolFinder
import io.ebean.Model
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class Tool(

        @Id
        @NotNull
        @Size(max = 200)
        val toolName: String,

        @NotNull
        @Size(max = 10000)
        val description: String,

        @NotNull
        @ManyToMany
        @JoinTable(name = "tool_property")
        val properties: MutableSet<Property> = mutableSetOf(),

        @NotNull
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        val links: MutableSet<Link> = mutableSetOf(),

        @NotNull
        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        val ratings: MutableSet<Rating> = mutableSetOf(),

        @NotNull
        var rating: Int = 0

) : Model() {

    companion object : ToolFinder()

    fun mapView(): MutableList<MutableList<String>> {
        val mapView = mutableListOf<MutableList<String>>()

        //val dimensions = Dimension.where().orderBy("index").findList()

        for (idx in 0 until Dimension.all().size) {
            mapView[idx] = mutableListOf()
        }

        this.properties.forEach {
            for ((index, name) in it.dimensions) {
                mapView[index].add(name)
            }
        }

        return mapView
    }

    fun updateRating() {
        var stars = 0

        this.ratings.forEach {
            stars += it.stars
        }

        this.rating = stars / this.ratings.size
    }
}
