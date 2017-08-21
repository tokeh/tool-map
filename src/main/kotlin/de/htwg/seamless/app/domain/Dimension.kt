package de.htwg.seamless.app.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import de.htwg.seamless.app.domain.finder.DimensionFinder
import io.ebean.Model
import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class Dimension(

        @NotNull
        @Column(unique = true)
        val index: Int,

        @Id
        @NotNull
        @Size(max = 200)
        val name: String,

        @NotNull
        @Size(max = 200)
        val description: String = ""

) : Model() {

    @JsonIgnore
    @ManyToMany(mappedBy = "dimensions", cascade = arrayOf(CascadeType.REMOVE))
    val properties: MutableSet<Property> = mutableSetOf()

    companion object : DimensionFinder()
}