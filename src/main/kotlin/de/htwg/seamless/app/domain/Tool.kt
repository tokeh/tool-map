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

    companion object : ToolFinder()

    init {
        this.updateMapView()
        this.updateRating()
    }

    @JsonIgnore
    @Transient
    var mapView = mutableListOf<MutableList<Dimension>>()

    fun updateMapView() {
        this.mapView = this.createMapView()
    }

    private fun createMapView(): MutableList<MutableList<Dimension>> {
        val mapView = mutableListOf<MutableList<Dimension>>()

        //val dimensions = Dimension.where().orderBy("index").findList()

        for (idx in 0 until Dimension.all().size) {
            mapView.add(mutableListOf())
        }

        this.properties.forEach {
            for (dimension in it.dimensions) {
                mapView[dimension.index].add(dimension)
            }
        }

        return mapView
    }

    fun updateRating() {
        var stars = 0

        this.ratings.forEach {
            stars += it.stars
        }

        if (this.ratings.size > 0) {
            this.rating = stars / this.ratings.size
        }
    }
}
