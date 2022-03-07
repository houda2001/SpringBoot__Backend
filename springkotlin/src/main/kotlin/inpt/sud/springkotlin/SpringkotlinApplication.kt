package inpt.sud.springkotlin
import inpt.sud.springkotlin.dao.CategoryRepository
import inpt.sud.springkotlin.dao.ProductRepository
import inpt.sud.springkotlin.data.Category
import inpt.sud.springkotlin.data.Product
import net.bytebuddy.utility.RandomString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import java.util.*

@SpringBootApplication
class SpringkotlinApplication : CommandLineRunner {
    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @Autowired
    private lateinit var repositoryRestConfiguration: RepositoryRestConfiguration

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        repositoryRestConfiguration!!.exposeIdsFor(Product::class.java, Category::class.java)

        categoryRepository!!.save(Category(null, "Computers", null, null))
        categoryRepository!!.save(Category(null, "Printers", null, null))
        categoryRepository!!.save(Category(null, "Smartphones", null, null))

        val rnd = Random()

        categoryRepository!!.findAll().forEach { category ->
            for (i in 0..9) {
                val p = Product()
                p.name=RandomString.make(10)
                p.currentPrice=100.0
                p.available=rnd.nextBoolean()
                p.promotion=rnd.nextBoolean()
                p.selected=rnd.nextBoolean()
                p.category=category
                p.photoName="unknown.png"
                productRepository!!.save(p)
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringkotlinApplication::class.java, *args)
        }
    }
}