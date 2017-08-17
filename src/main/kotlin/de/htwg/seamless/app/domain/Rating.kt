package de.htwg.seamless.app.domain

import com.fasterxml.jackson.annotation.JsonFormat
import de.htwg.seamless.app.domain.finder.RatingFinder
import io.ebean.Model
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
data class Rating(

        @Id
        @NotNull
        val uuid: UUID,

        @NotNull
        @Size(max = 10000)
        val text: String,

        @NotNull
        @Size(max = 200)
        val context: String,

        @NotNull
        @Size(max = 200)
        val author: String,

        @NotNull
        val stars: Int,

        @NotNull
        @JsonFormat(pattern = "dd.MM.yyyy")
        val date: LocalDate

) : Model() {

    override fun toString(): String {
        return "id:$uuid"
    }

    companion object : RatingFinder()
}