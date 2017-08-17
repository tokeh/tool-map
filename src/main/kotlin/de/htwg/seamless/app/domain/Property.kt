package de.htwg.seamless.app.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import de.htwg.seamless.app.domain.finder.PropertyFinder
import io.ebean.Model
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class Property(

        @Id
        @NotNull
        @Size(max = 200)
        val name: String,

        @NotNull
        @ManyToMany(cascade = arrayOf(CascadeType.REMOVE))
        @JoinTable(name = "property_dimension")
        val dimensions: MutableSet<Dimension> = mutableSetOf()

) : Model() {

    @JsonIgnore
    @ManyToMany(mappedBy = "properties", cascade = arrayOf(CascadeType.REMOVE))
    val tools: MutableSet<Tool> = mutableSetOf()

    companion object : PropertyFinder()
}