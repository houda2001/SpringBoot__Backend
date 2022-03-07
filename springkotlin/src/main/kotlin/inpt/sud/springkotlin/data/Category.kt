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
class Category(private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
               private var name: String? = null, private var description: String? = null,
               private @OneToMany(mappedBy = "category") var products: Collection<Product>? = null
) : Serializable {

}
