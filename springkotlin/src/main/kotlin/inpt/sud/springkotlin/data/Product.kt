package inpt.sud.springkotlin.data

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import java.io.Serializable
import javax.persistence.*

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
 class Product(private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
               var name: String? = null, var description: String? = null,
                var currentPrice: Double = 0.0,  var promotion: Boolean = false,
                var selected: Boolean = false,  var available: Boolean = false,
                var photoName: String? = null
) : Serializable {

   @ManyToOne
    var category: Category? = null
}