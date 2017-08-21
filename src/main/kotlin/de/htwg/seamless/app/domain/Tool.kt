package de.htwg.seamless.app.domain

import com.fasterxml.jackson.annotation.JsonIgnore
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

    init {
        this.updateToolData()
    }

    fun test(): String {
        return "test"
    }
    companion object : ToolFinder()

    @JsonIgnore
    @Transient
    var mapView = mutableListOf<MutableList<Property>>()

    fun updateToolData(): Tool {
        this.mapView = this.updateMapView()
        this.updateRating()

        return this
    }

    private fun updateMapView(): MutableList<MutableList<Property>> {
        val mapView = mutableListOf<MutableList<Property>>()

        //val dimensions = Dimension.where().orderBy("index").findList()

        for (idx in 0 until Dimension.all().size) {
            mapView.add(mutableListOf())
        }

        this.properties.forEach {
            for ((index) in it.dimensions) {
                mapView[index].add(it)
            }
        }

        return mapView
    }

    private fun updateRating() {
        var stars = 0

        this.ratings.forEach {
            stars += it.stars
        }

        if (this.ratings.size > 0) {
            this.rating = stars / this.ratings.size
        }
    }
}
