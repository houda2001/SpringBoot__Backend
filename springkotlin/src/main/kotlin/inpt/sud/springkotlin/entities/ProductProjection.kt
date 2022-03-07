package inpt.sud.springkotlin.entities
import inpt.sud.springkotlin.data.Product
import org.springframework.data.rest.core.config.Projection


@Projection(name = "P1", types = [Product::class])
interface ProductProjection {
    var currentPrice: Double
}
