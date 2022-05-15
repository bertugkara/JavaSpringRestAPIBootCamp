package Ankara.kara.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Ankara.kara.business.abstracts.ProductService;
import Ankara.kara.core.utilities.results.DataResult;
import Ankara.kara.core.utilities.results.Result;
import Ankara.kara.entities.concretes.Product;
import Ankara.kara.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	//IoC Dependency Injection
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);		
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}
	@GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
	}
	/*
	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam("categories") List<Integer> categories){
		return this.productService.getByCategoryIdIn(categories);
	}
	*/
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPageNumber")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	} 
	
	@GetMapping("/getAllSortedByAscendingName")
	public DataResult<List<Product>> getAllSortedByAscendingName(){
		return this.productService.getAllSortedByAscendingName();
	}
	
	@GetMapping("/getAllSortedByDescendingName")
	public DataResult<List<Product>> getAllSortedByDescendingName(){
		return this.productService.getAllSortedByDescendingName();
	}
	
	@GetMapping("/getAllSortedByAscendingPrice")
	public DataResult<List<Product>> getAllSortedByAscendingPrice(){
		return this.productService.getAllSortedByAscendingPrice();
	}
	
	@GetMapping("/getAllSortedByDescendingPrice")
	public DataResult<List<Product>> getAllSortedByDescendingPrice(){
		return this.productService.getAllSortedByDescendingPrice();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
}
