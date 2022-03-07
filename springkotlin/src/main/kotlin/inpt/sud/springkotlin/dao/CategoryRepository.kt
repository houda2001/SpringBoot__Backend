package inpt.sud.springkotlin.dao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.CrossOrigin
import inpt.sud.springkotlin.data.Category

@CrossOrigin("*")
@RepositoryRestResource
interface CategoryRepository : JpaRepository<Category?, Long?>